package FormBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArticleForm {
    private String title;
    private String minContent;
    private String content;
    private String categoryId;
    private String imageFileName;

    public ArticleForm(HttpServletRequest request) {
        title = request.getParameter("title");
        minContent = request.getParameter("minContent");
        content = request.getParameter("content");
        categoryId = request.getParameter("categoryId");

        try {
            imageFileName = Paths.get(request.getPart("image").getSubmittedFileName()).getFileName().toString();
        } catch (ServletException | IOException ex) {
            imageFileName = null;
        }
    }

    public String getTitle() { return title; }
    public String getMinContent() { return minContent; }
    public String getContent() { return content; }
    public int getCategoryId() { return Integer.parseInt(categoryId); }
    public String getImageFileName() { return imageFileName; }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (title == null || title.length() == 0) {
            errors.add("Title is required");
            return errors;
        }

        if (minContent == null || minContent.length() == 0) {
            errors.add("Minimal content is required");
            return errors;
        }

        if (content == null || content.length() == 0) {
            errors.add("Content is required");
            return errors;
        }

        if (categoryId == null || content.length() == 0) {
            errors.add("Category id is reqiured");
            return errors;
        }

        try {
            Integer.parseInt(categoryId);
        } catch (NumberFormatException ex) {
            errors.add("Category id must be number");
            return errors;
        }

        if (imageFileName == null || imageFileName.length() == 0) {
            errors.add("Image file is required");
            return errors;
        }

        String[] fields = {title, minContent, content, imageFileName};

        for (String field: fields) {
            if (field.matches(".*[<>\"].*")) {
                errors.add("Field may not contain angle brackets or quotes");
                break;
            }
        }

        return errors;
    }
}
