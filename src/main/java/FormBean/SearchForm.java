package FormBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SearchForm {
    private String content;

    public SearchForm(HttpServletRequest request) {
        content = request.getParameter("q");
    }

    public String getContent() { return content; }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (content == null || content.length() == 0) {
            errors.add("Content must required");
            return errors;
        }

        if (content.matches(".*[<>\"].*")) {
            errors.add("Content may not contain angle brackets or quotes");
        }

        return errors;
    }
}
