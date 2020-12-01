package DAO;

import DataBean.ArticleBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO extends DAO {

    private final String tableName;

    public ArticleDAO(String jdbcDriver, String jdbcURL, String tableName) {
        super(jdbcDriver, jdbcURL);
        this.tableName = tableName;
    }

    public void create(ArticleBean articleBean) {
        final String QUERY = String.format("INSERT INTO %s (title, min_content, content, category_id, image) VALUES(?, ?, ?, ?, ?)", tableName);

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, articleBean.getTitle());
            preparedStatement.setString(2, articleBean.getMinContent());
            preparedStatement.setString(3, articleBean.getContent());
            preparedStatement.setInt(4, articleBean.getCategoryId());
            preparedStatement.setString(5, articleBean.getImage());

            int count = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);
    }

    public ArticleBean read(int id) {
        final String QUERY = String.format("SELECT * FROM %s WHERE id = ?", tableName);

        ArticleBean article = null;

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                article = createArticleBean(resultSet);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return article;
    }

    public List<ArticleBean> getAllArticles() {
        final String QUERY = String.format("SELECT * FROM %s", tableName);
        return getArticlesByQuery(QUERY);
    }

    public List<ArticleBean> getLastArticles(int n) {
        final String QUERY = String.format("SELECT * FROM %s ORDER BY date_created DESC LIMIT %d", tableName, n);
        return getArticlesByQuery(QUERY);
    }

    public List<ArticleBean> getArticlesByCategoryID(int categoryId) {
        final String QUERY = String.format("SELECT * FROM %s WHERE category_id = ?", tableName);

        List<ArticleBean> articles = null;

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, categoryId);
            articles = getArticlesByPreparedQuery(preparedStatement);

            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return articles;

    }

    public List<ArticleBean> getArticlesBySearch(String content) {
        final String QUERY = "SELECT * FROM " + tableName + " WHERE title LIKE '%" + content + "%'";
        List<ArticleBean> articles = getArticlesByQuery(QUERY);
        return articles;
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

    private List<ArticleBean> getArticlesByPreparedQuery(PreparedStatement preparedStatement) {
        List<ArticleBean> articles = new ArrayList<>();

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArticleBean article = createArticleBean(resultSet);
                articles.add(article);
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return articles;
    }

    private List<ArticleBean> getArticlesByQuery(String query) {
        List<ArticleBean> articles = new ArrayList<>();

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ArticleBean articleBean = createArticleBean(resultSet);
                articles.add(articleBean);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return articles;
    }

    private ArticleBean createArticleBean(ResultSet resultSet) {
        ArticleBean articleBean = new ArticleBean();

        try {
            articleBean.setId(resultSet.getInt("id"));
            articleBean.setTitle(resultSet.getString("title"));
            articleBean.setMinContent(resultSet.getString("min_content"));
            articleBean.setContent(resultSet.getString("content"));
            articleBean.setDateCreated(resultSet.getDate("date_created"));
            articleBean.setCategoryId(resultSet.getInt("category_id"));
            articleBean.setImage(resultSet.getString("image"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            articleBean = null;
        }

        return articleBean;
    }
}