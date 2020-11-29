package Controller.Admin;

import Controller.Action;
import DAO.ArticleDAO;
import DAO.Model;
import DataBean.ArticleBean;
import FormBean.ArticleForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;

public class ArticleAddAction extends Action {
    private ArticleDAO articleDAO;

    public ArticleAddAction(Model model) {
        articleDAO = model.getArticleDAO();
    }

    @Override
    public String getName() { return "addArticle.do"; }

    @Override
    public String performPost(HttpServletRequest request) {
        ArticleForm form = new ArticleForm(request);

        List<String> errors = form.getValidationErrors();

        if (errors.size() > 0) {
            return "add.do";
        }

        ArticleBean article = new ArticleBean();
        article.setTitle(form.getTitle());
        article.setMinContent(form.getMinContent());
        article.setContent(form.getContent());
        article.setCategoryId(form.getCategoryId());
        article.setImage(form.getImageFileName());

        articleDAO.create(article);

        uploadImage(request);

        return "list.do";
    }

    private void uploadImage(HttpServletRequest request) {
        try {
            Part filePart = request.getPart("image");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream inputStream = filePart.getInputStream();
            OutputStream outputStream = new FileOutputStream("C:/Users/kuany/IdeaProjects/blog/src/main/webapp/images/" + fileName);

            int val;

            while ((val = inputStream.read()) != -1) {
                outputStream.write(val);
            }

            inputStream.close();
            outputStream.close();

        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
