package FormBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class LoginForm {
    private String username;
    private String password;

    public LoginForm(HttpServletRequest request) {
        username = request.getParameter("username").trim();
        password = request.getParameter("password").trim();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (username == null || username.length() == 0) {
            errors.add("Username is required");
            return errors;
        }

        if (password == null || password.length() == 0) {
            errors.add("Password is required");
            return errors;
        }

        String[] fields = {username, password};

        for (String field: fields) {
            if (field.matches(".*[<>\"].*")) {
                errors.add("Field may not contain angle brackets or quotes");
                break;
            }
        }

        return errors;
    }
}
