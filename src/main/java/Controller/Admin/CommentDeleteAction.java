package Controller.Admin;

import Controller.Action;
import DAO.CommentDAO;
import DAO.Model;

import javax.servlet.http.HttpServletRequest;

public class CommentDeleteAction extends Action {
    private CommentDAO commentDAO;

    public CommentDeleteAction(Model model) {
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "deleteComment.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        commentDAO.delete(id);

        return "list.do";
    }
}
