package FormBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CategoryForm {
    private String title;

    public CategoryForm(HttpServletRequest request) {
        title = request.getParameter("title");
    }

    public String getTitle() { return title; }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (title == null || title.length() == 0) {
            errors.add("Title is required");
            return errors;
        }

        if (title.matches(".*[<>\"].*")) {
            errors.add("Title may not contain angle brackets or quotes");
        }

        return errors;
    }
}
