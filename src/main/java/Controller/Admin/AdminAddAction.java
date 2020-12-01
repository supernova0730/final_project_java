package Controller.Admin;

import Controller.Action;
import DAO.CategoryDAO;
import DAO.Model;
import DataBean.CategoryBean;
import DataBean.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminAddAction extends Action {
    private CategoryDAO categoryDAO;

    public AdminAddAction(Model model) {
        categoryDAO = model.getCategoryDAO();
    }

    @Override
    public String getName() { return "add.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user == null) {
            return "login.do";
        }

        List<CategoryBean> categories = categoryDAO.getAllCategories();

        request.setAttribute("categories", categories);

        return "admin/add.jsp";
    }
}
