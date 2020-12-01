package Controller.Admin;

import Controller.Action;
import DAO.CategoryDAO;
import DAO.Model;

import javax.servlet.http.HttpServletRequest;

public class CategoryDeleteAction extends Action {
    private CategoryDAO categoryDAO;

    public CategoryDeleteAction(Model model) {
        categoryDAO = model.getCategoryDAO();
    }

    @Override
    public String getName() { return "deleteCategory.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        categoryDAO.delete(id);

        return "list.do";
    }
}
