package Controller.Admin;

import Controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {
    @Override
    public String getName() { return "logout.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "blog.do";
    }
}
