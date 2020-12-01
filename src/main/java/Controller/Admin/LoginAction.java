package Controller.Admin;

import Controller.Action;
import DAO.Model;
import DAO.UserDAO;
import DataBean.UserBean;
import FormBean.LoginForm;
import Validator.PasswordHash;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class LoginAction extends Action {
    private UserDAO userDAO;

    public LoginAction(Model model) {
        userDAO = model.getUserDAO();
    }

    @Override
    public String getName() { return "login.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            return "list.do";
        }

        return "admin/login.jsp";
    }

    @Override
    public String performPost(HttpServletRequest request) {
        LoginForm form = new LoginForm(request);

        List<String> errors = form.getValidationErrors();
        request.setAttribute("errors", errors);

        if (errors.size() > 0) {
            return performGet(request);
        }

        UserBean user = userDAO.read(form.getUsername());

        if (user == null) {
            errors.add("Username is incorrect");
            return performGet(request);
        }

        String hashedPassword = PasswordHash.getHash(form.getPassword());

        if (!user.getPassword().equals(hashedPassword)) {
            errors.add("Password is incorrect");
            return performGet(request);
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "list.do";

//        try {
//            user = userDAO.read(form.getUsername());
//
//            if (user != null) {
//                String hashedPassword = PasswordHash.getHash(form.getPassword());
//
//                if (user.getPassword().equals(hashedPassword)) {
//                    HttpSession session = request.getSession();
//                    session.setAttribute("user", user);
//
//                    return "list.do";
//                } else {
//                    errors.add("Password is incorrect");
//                }
//            } else {
//                errors.add("Username is incorrect");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        if (errors.size() > 0) {
//            request.setAttribute("errors", errors);
//            return "admin.do";
//        }
//
//        return "admin.do";
    }
}
