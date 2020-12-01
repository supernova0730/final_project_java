package Controller;

import DAO.CommentDAO;
import DAO.Model;
import DataBean.CommentBean;
import FormBean.CommentForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommentAction extends Action {
    private CommentDAO commentDAO;

    public CommentAction(Model model) {
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "comment.do"; }

    @Override
    public String performPost(HttpServletRequest request) {
        CommentForm form = new CommentForm(request);

        List<String> errors = form.getValidationErrors();

        if (errors.size() > 0)
            return "blog.do";

        CommentBean comment = new CommentBean();
        comment.setAuthorName(form.getAuthorName());
        comment.setEmail(form.getEmail());
        comment.setContent(form.getContent());
        comment.setArticleId(form.getArticleId());

        commentDAO.create(comment);

        String url = String.format("detail.do?id=%d", form.getArticleId());
        return url;
    }
}
