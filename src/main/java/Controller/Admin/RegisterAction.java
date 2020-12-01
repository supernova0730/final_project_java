package Controller.Admin;

import Controller.Action;
import DAO.Model;
import DAO.UserDAO;
import DataBean.UserBean;
import FormBean.RegisterForm;
import Validator.PasswordHash;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RegisterAction extends Action {
    private UserDAO userDAO;

    public RegisterAction(Model model) {
        userDAO = model.getUserDAO();
    }

    @Override
    public String getName() { return "register.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user == null) {
            return "login.do";
        }

        return "admin/register.jsp";
    }

    @Override
    public String performPost(HttpServletRequest request) {
        RegisterForm form = new RegisterForm(request);

        List<String> errors = form.getValidationErrors();
        request.setAttribute("errors", errors);

        if (errors.size() > 0) {
            return performGet(request);
        }

        UserBean user = userDAO.read(form.getUsername());

        if (user != null) {
            errors.add("User already exists");
            return performGet(request);
        }

        if (!form.getPassword1().equals(form.getPassword2())) {
            errors.add("Password does not match");
            return performGet(request);
        }

        user = new UserBean();
        user.setUsername(form.getUsername());
        String hashedPassword = PasswordHash.getHash(form.getPassword2());
        user.setPassword(hashedPassword);

        userDAO.create(user);

        return "list.do";
    }
}
