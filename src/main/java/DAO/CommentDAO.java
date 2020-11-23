package DAO;

import DataBean.CommentBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends DAO {

    private final String tableName;

    public CommentDAO(String jdbcDriver, String jdbcURL, String tableName) {
        super(jdbcDriver, jdbcURL);
        this.tableName = tableName;
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