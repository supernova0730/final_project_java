package DAO;

import DataBean.ArticleBean;
import DataBean.CategoryBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DAO {

    private final String tableName;

    public CategoryDAO(String jdbcDriver, String jdbcURL, String tableName) {
        super(jdbcDriver, jdbcURL);
        this.tableName = tableName;
    }

    public void create(CategoryBean categoryBean) {
        final String QUERY = String.format("INSERT INTO %s (title) VALUES(?)", tableName);

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, categoryBean.getTitle());
            int count = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);
    }

    public CategoryBean read(int id) {
        final String QUERY = String.format("SELECT * FROM %s WHERE id = ?", tableName);

        CategoryBean category = null;

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
                category = createCategoryBean(resultSet);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return category;
    }

    public List<CategoryBean> getAllCategories() {
        final String QUERY = String.format("SELECT * FROM %s", tableName);

        List<CategoryBean> categories = new ArrayList<>();

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
                CategoryBean categoryBean = createCategoryBean(resultSet);
                categories.add(categoryBean);
            }

            statement.close();
            resultSet.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return categories;
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

    private CategoryBean createCategoryBean(ResultSet resultSet) {
        CategoryBean categoryBean = new CategoryBean();

        try {
            categoryBean.setId(resultSet.getInt("id"));
            categoryBean.setTitle(resultSet.getString("title"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            categoryBean = null;
        }

        return categoryBean;
    }

}