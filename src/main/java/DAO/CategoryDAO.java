package DAO;

import DataBean.CategoryBean;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

public class CategoryDAO extends GenericDAO<CategoryBean> {
    public CategoryDAO(ConnectionPool connectionPool, String tableName) throws DAOException {
        super(CategoryBean.class, tableName, connectionPool);
    }
}
