package Controller;

import DAO.ArticleDAO;
import DAO.Model;

import javax.servlet.http.HttpServletRequest;

public class BlogAction extends Action{
    private ArticleDAO articleDAO;

    public BlogAction(Model model) {
        articleDAO = model.getArticleDAO();
    }

    @Override
    public String getName() { return "blog.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "blog.jsp";
    }
}
