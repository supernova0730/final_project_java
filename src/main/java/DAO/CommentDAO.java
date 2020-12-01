package DAO;

import DataBean.CommentBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends DAO {

    private final String tableName;

    public CommentDAO(String jdbcDriver, String jdbcURL, String tableName) {
        super(jdbcDriver, jdbcURL);
        this.tableName = tableName;
    }

    public void create(CommentBean commentBean) {
        final String QUERY = String.format("INSERT INTO %s (author_name, email, content, article_id) VALUES(?, ?, ?, ?)", tableName);

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, commentBean.getAuthorName());
            preparedStatement.setString(2, commentBean.getEmail());
            preparedStatement.setString(3, commentBean.getContent());
            preparedStatement.setInt(4, commentBean.getArticleId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);
    }

    public List<CommentBean> getAllComments() {
        final String QUERY = String.format("SELECT * FROM %s", tableName);

        List<CommentBean> comments = new ArrayList<>();

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                CommentBean comment = createCommentBean(resultSet);
                comments.add(comment);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return comments;
    }

    public List<CommentBean> getArticleComments(int articleId) {
        final String QUERY = String.format("SELECT * FROM %s WHERE article_id = ?", tableName);

        List<CommentBean> comments = new ArrayList<>();

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, articleId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CommentBean comment = createCommentBean(resultSet);
                comments.add(comment);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return comments;
    }

    public void delete(int id) {
        final String QUERY = String.format("DELETE FROM %s WHERE id = ?", tableName);

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);
    }

    private CommentBean createCommentBean(ResultSet resultSet) {
        CommentBean commentBean = new CommentBean();

        try {
            commentBean.setId(resultSet.getInt("id"));
            commentBean.setAuthorName(resultSet.getString("author_name"));
            commentBean.setEmail(resultSet.getString("email"));
            commentBean.setContent(resultSet.getString("content"));
            commentBean.setDateCreated(resultSet.getDate("date_created"));
            commentBean.setArticleId(resultSet.getInt("article_id"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            commentBean = null;
        }

        return commentBean;
    }
}