package Controller;

import DAO.ArticleDAO;
import DAO.Model;

import javax.servlet.http.HttpServletRequest;

public class HomeAction extends Action {
    private ArticleDAO articleDAO;

    public HomeAction(Model model) {
        articleDAO = model.getArticleDAO();
    }

    @Override
    public String getName() { return "home.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "index.jsp";
    }
}
