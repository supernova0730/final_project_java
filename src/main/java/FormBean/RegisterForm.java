package FormBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RegisterForm {
    private String username;
    private String password1;
    private String password2;

    public RegisterForm(HttpServletRequest request) {
        username = request.getParameter("username");
        password1 = request.getParameter("password1");
        password2 = request.getParameter("password2");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (username == null || username.length() == 0) {
            errors.add("Username is required");
            return errors;
        }

        if (password1 == null || password1.length() == 0) {
            errors.add("Password is required");
            return errors;
        }

        if (password2 == null || password2.length() == 0) {
            errors.add("Confirm password is required");
            return errors;
        }

        String[] fields = {username, password1, password2};

        for (String field: fields) {
            if (field.matches(".*[<>\"].*")) {
                errors.add("Field may not contain angle brackets or quotes");
                break;
            }
        }

        return errors;
    }
}

