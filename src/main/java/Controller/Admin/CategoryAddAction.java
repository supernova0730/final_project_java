package Controller.Admin;

import Controller.Action;
import DAO.CategoryDAO;
import DAO.Model;
import DataBean.CategoryBean;
import FormBean.CategoryForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CategoryAddAction extends Action {
    private CategoryDAO categoryDAO;

    public CategoryAddAction(Model model) {
        categoryDAO = model.getCategoryDAO();
    }

    @Override
    public String getName() { return "addCategory.do"; }

    @Override
    public String performPost(HttpServletRequest request) {
        CategoryForm form = new CategoryForm(request);

        List<String> errors = form.getValidationErrors();

        if (errors.size() > 0) {
            return "add.do";
        }

        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setTitle(form.getTitle());
        categoryDAO.create(categoryBean);

        return "list.do";
    }
}
