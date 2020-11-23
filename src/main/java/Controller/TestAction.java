package Controller;

import DAO.ArticleDAO;
import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.Model;

import javax.servlet.http.HttpServletRequest;

public class TestAction extends Action {
    private ArticleDAO articleDAO;
    private CategoryDAO categoryDAO;
    private CommentDAO commentDAO;

    public TestAction(Model model) {
        articleDAO = model.getArticleDAO();
        categoryDAO = model.getCategoryDAO();
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "test.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "";
    }
}
