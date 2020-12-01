package DAO;

import DataBean.UserBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {
    private final String tableName;

    public UserDAO(String jdbcDriver, String jdbcURL, String tableName) {
        super(jdbcDriver, jdbcURL);
        this.tableName = tableName;
    }

    public UserBean read(String username) {
        final String QUERY = String.format("SELECT * FROM %s WHERE username = ?", tableName);

        UserBean userBean = null;

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userBean = new UserBean();
                userBean.setId(resultSet.getInt("id"));
                userBean.setUsername(resultSet.getString("username"));
                userBean.setPassword(resultSet.getString("password"));
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return userBean;
    }

    public void create(UserBean user) {
        final String QUERY = String.format("INSERT INTO %s (username, password) VALUES(?, ?)", tableName);

        Connection connection = null;

        try {
            connection = getConnection();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            int count = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);
    }

    public List<UserBean> getAllUsers() {
        List<UserBean> users = new ArrayList<>();

        final String QUERY = String.format("SELECT * FROM %s", tableName);

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
                UserBean userBean = new UserBean();
                userBean.setId(resultSet.getInt("id"));
                userBean.setUsername(resultSet.getString("username"));
                users.add(userBean);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        releaseConnection(connection);

        return users;
    }

}
