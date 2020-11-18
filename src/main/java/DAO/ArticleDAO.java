package DAO;

import DataBean.ArticleBean;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

public class ArticleDAO extends GenericDAO<ArticleBean> {
    public ArticleDAO(ConnectionPool connectionPool, String tableName) throws DAOException {
        super(ArticleBean.class, tableName, connectionPool);
    }
}

