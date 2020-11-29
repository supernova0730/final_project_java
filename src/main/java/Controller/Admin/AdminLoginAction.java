package Controller.Admin;

import Controller.Action;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginAction extends Action {
    @Override
    public String getName() { return "admin.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "admin/login.jsp";
    }

    @Override
    public String performPost(HttpServletRequest request) {
        return performGet(request);
    }
}
