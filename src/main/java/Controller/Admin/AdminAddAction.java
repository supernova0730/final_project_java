package Controller.Admin;

import Controller.Action;

import javax.servlet.http.HttpServletRequest;

public class AdminAddAction extends Action {
    @Override
    public String getName() { return "add.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "admin/add.jsp";
    }
}
