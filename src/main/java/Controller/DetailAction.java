package Controller;

import DAO.ArticleDAO;
import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.Model;
import DataBean.ArticleBean;
import DataBean.CategoryBean;
import DataBean.CommentBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DetailAction extends Action {
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;

    public DetailAction(Model model) {
        categoryDAO = model.getCategoryDAO();
        articleDAO = model.getArticleDAO();
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "detail.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        ArticleBean article = articleDAO.read(id);
        CategoryBean category = categoryDAO.read(article.getCategoryId());
        List<CommentBean> comments = commentDAO.getArticleComments(article.getId());

        request.setAttribute("article", article);
        request.setAttribute("category", category);
        request.setAttribute("comments", comments);

        return "detail.jsp";
    }
}
