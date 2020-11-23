package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO {
    private List<Connection> connectionPool;
    private String jdbcDriver;
    private String jdbcURL;

    public DAO(String jdbcDriver, String jdbcURL) {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;
        connectionPool = new ArrayList<>();
    }

    protected synchronized Connection getConnection() throws DAOException {
        if (connectionPool.size() > 0) {
            return connectionPool.remove(connectionPool.size() - 1);
        }

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }

        try {
            return DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    protected synchronized void releaseConnection(Connection con) {
        connectionPool.add(con);
    }
}
