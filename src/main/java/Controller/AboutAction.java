package Controller;

import javax.servlet.http.HttpServletRequest;

public class AboutAction extends Action {
    @Override
    public String getName() { return "about.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        return "about.jsp";
    }
}
