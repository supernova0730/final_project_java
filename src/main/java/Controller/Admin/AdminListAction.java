package Controller.Admin;

import Controller.Action;
import DAO.*;
import DataBean.ArticleBean;
import DataBean.CategoryBean;
import DataBean.CommentBean;
import DataBean.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminListAction extends Action {
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;
    private UserDAO userDAO;

    public AdminListAction(Model model) {
        categoryDAO = model.getCategoryDAO();
        articleDAO = model.getArticleDAO();
        commentDAO = model.getCommentDAO();
        userDAO = model.getUserDAO();
    }

    @Override
    public String getName() { return "list.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user == null) {
            return "login.do";
        }

        List<CategoryBean> categories = categoryDAO.getAllCategories();
        List<ArticleBean> articles = articleDAO.getAllArticles();
        List<CommentBean> comments = commentDAO.getAllComments();
        List<UserBean> users = userDAO.getAllUsers();

        request.setAttribute("categories", categories);
        request.setAttribute("articles", articles);
        request.setAttribute("comments", comments);
        request.setAttribute("users", users);

        return "admin/list.jsp";
    }
}
