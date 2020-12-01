package FormBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CommentForm {
    private String authorName;
    private String email;
    private String content;
    private String articleId;

    public CommentForm(HttpServletRequest request) {
        authorName = request.getParameter("authorName");
        email = request.getParameter("email");
        content = request.getParameter("content");
        articleId = request.getParameter("articleId");
    }

    public String getAuthorName() { return authorName; }
    public String getEmail() { return email; }
    public String getContent() { return content; }
    public int getArticleId() { return Integer.parseInt(articleId); }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (authorName == null || authorName.length() == 0) {
            errors.add("Author name is required");
            return errors;
        }

        if (email == null || email.length() == 0) {
            errors.add("Email is required");
            return errors;
        }

        if (content == null || content.length() == 0) {
            errors.add("Content is required");
            return errors;
        }

        if (articleId == null || articleId.length() == 0) {
            errors.add("Article id is required");
            return errors;
        }

        String[] fields = {authorName, email, content, articleId};
        for (String field: fields) {
            if (field.matches(".*[<>\"].*")) {
                errors.add("Field may not contain angle brackets or quotes");
                break;
            }
        }

        try {
            Integer.parseInt(articleId);
        } catch (NumberFormatException ex) {
            errors.add("Article id must be number");
            return errors;
        }

        return errors;
    }
}
