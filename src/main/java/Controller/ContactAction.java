package Controller;

import javax.servlet.http.HttpServletRequest;

public class ContactAction extends Action {
    @Override
    public String getName() { return "contact.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "contact.jsp";
    }
}
