package Controller.Admin;

import Controller.Action;
import DAO.ArticleDAO;
import DAO.Model;

import javax.servlet.http.HttpServletRequest;

public class ArticleDeleteAction extends Action {
    private ArticleDAO articleDAO;

    public ArticleDeleteAction(Model model) {
        articleDAO = model.getArticleDAO();
    }

    @Override
    public String getName() { return "deleteArticle.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        articleDAO.delete(id);

        return "list.do";
    }
}
