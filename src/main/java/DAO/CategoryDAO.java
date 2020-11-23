package DAO;

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

    public List<CategoryBean> getAllCategories() {
        final String QUERY = String.format("SELECT * FROM %s", tableName);

        List<CategoryBean> categories = new ArrayList<>();

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                int categoryId = resultSet.getInt("id");
                String categoryTitle = resultSet.getString("title");

                CategoryBean categoryBean = new CategoryBean();
                categoryBean.setId(categoryId);
                categoryBean.setTitle(categoryTitle);

                categories.add(categoryBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

}