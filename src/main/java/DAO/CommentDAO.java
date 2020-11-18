package DAO;

import DataBean.CommentBean;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

public class CommentDAO extends GenericDAO<CommentBean> {
    public CommentDAO(ConnectionPool connectionPool, String tableName) throws DAOException {
        super(CommentBean.class, tableName, connectionPool);
    }
}
