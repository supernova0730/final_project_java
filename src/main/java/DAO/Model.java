package DAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Model {
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;

    public Model(ServletConfig config) throws ServletException {
        String jdbcDriver = config.getInitParameter("jdbcDriverName");
        String jdbcURL = config.getInitParameter("jdbcURL");

        categoryDAO = new CategoryDAO(jdbcDriver, jdbcURL, "category");
        articleDAO = new ArticleDAO(jdbcDriver, jdbcURL, "article");
        commentDAO = new CommentDAO(jdbcDriver, jdbcURL, "comment");
    }

    public CategoryDAO getCategoryDAO() {return categoryDAO;}
    public ArticleDAO getArticleDAO() {return articleDAO;}
    public CommentDAO getCommentDAO() {return commentDAO;}
}
