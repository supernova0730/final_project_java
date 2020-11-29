package Controller.Admin;

import Controller.Action;
import DAO.ArticleDAO;
import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.Model;
import DataBean.ArticleBean;
import DataBean.CategoryBean;
import DataBean.CommentBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminListAction extends Action {
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;

    public AdminListAction(Model model) {
        categoryDAO = model.getCategoryDAO();
        articleDAO = model.getArticleDAO();
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "list.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        List<CategoryBean> categories = categoryDAO.getAllCategories();
        List<ArticleBean> articles = articleDAO.getAllArticles();
        List<CommentBean> comments = commentDAO.getAllComments();

        request.setAttribute("categories", categories);
        request.setAttribute("articles", articles);
        request.setAttribute("comments", comments);

        return "admin/list.jsp";
    }
}
