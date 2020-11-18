package DAO;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Model {
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;

    public Model(ServletConfig config) throws ServletException {
        try {
            String jdbcDriver = config.getInitParameter("jdbcDriverName");
            String jdbcURL = config.getInitParameter("jdbcURL");

            ConnectionPool connectionPool = new ConnectionPool(jdbcDriver, jdbcURL);

            categoryDAO = new CategoryDAO(connectionPool, "category");
            articleDAO = new ArticleDAO(connectionPool, "article");
            commentDAO = new CommentDAO(connectionPool, "comment");

        } catch (DAOException ex) {
            throw new ServletException(ex);
        }
    }

    public CategoryDAO getCategoryDAO() {return categoryDAO;}
    public ArticleDAO getArticleDAO() {return articleDAO;}
    public CommentDAO getCommentDAO() {return commentDAO;}
}
