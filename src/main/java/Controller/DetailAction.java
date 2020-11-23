package Controller;

import DAO.ArticleDAO;
import DAO.Model;
import DataBean.ArticleBean;
import org.genericdao.RollbackException;

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
        int id = Integer.parseInt(request.getParameter("id"));
        ArticleBean article = null;

        try {
            article = articleDAO.read(id);
        } catch (RollbackException e) {
            e.printStackTrace();
        }

        request.setAttribute("article", article);

        return "detail.jsp";
    }
}
