package Controller;

import Controller.Admin.*;
import DAO.Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class Controller extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Model model = new Model(getServletConfig());

        ServletContext context = getServletContext();
        context.setAttribute("model", model);

        Action.add(new BlogAction(model));
        Action.add(new DetailAction(model));
        Action.add(new AboutAction());
        Action.add(new ContactAction());
        Action.add(new CommentAction(model));
        Action.add(new CategoryAction(model));
        Action.add(new SearchAction(model));

        Action.add(new AdminListAction(model));
        Action.add(new AdminAddAction(model));
        Action.add(new CategoryAddAction(model));
        Action.add(new ArticleAddAction(model));
        Action.add(new CategoryDeleteAction(model));
        Action.add(new ArticleDeleteAction(model));
        Action.add(new CommentDeleteAction(model));
        Action.add(new RegisterAction(model));
        Action.add(new LoginAction(model));
        Action.add(new LogoutAction());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage, request, response);
    }

    /*
     * Extracts the requested action and (depending on whether the user is
     * logged in) perform it (or make the user login).
     *
     * @param request
     *
     * @return the next page (the view)
     */
    private String performTheAction(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String action = getActionName(servletPath);
        return Action.perform(action, request);
    }

    /*
     * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
     * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
     * page (the view) This is the common case
     */
    private void sendToNextPage(String nextPage, HttpServletRequest request,
                                HttpServletResponse response) throws IOException, ServletException {
        if (nextPage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    request.getServletPath());
            return;
        }

        if (nextPage.endsWith(".do")) {
            response.sendRedirect(nextPage);
            return;
        }

        if (nextPage.contains(".do?")) {
            response.sendRedirect(nextPage);
            return;
        }

        if (nextPage.endsWith(".jsp")) {
            RequestDispatcher d = request.getRequestDispatcher("view/" + nextPage);
            d.forward(request, response);
            return;
        }

        throw new ServletException(Controller.class.getName()
                + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }

    /*
     * Returns the path component after the last slash removing any "extension"
     * if present.
     */
    private String getActionName(String path) {
        // We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash + 1);
    }
}
