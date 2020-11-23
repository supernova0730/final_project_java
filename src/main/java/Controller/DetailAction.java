package Controller;

import DAO.ArticleDAO;
import DAO.Model;

import javax.servlet.http.HttpServletRequest;

public class DetailAction extends Action {
    private ArticleDAO articleDAO;

    public DetailAction(Model model) {
        articleDAO = model.getArticleDAO();
    }

    @Override
    public String getName() { return "detail.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "detail.jsp";
    }
}
