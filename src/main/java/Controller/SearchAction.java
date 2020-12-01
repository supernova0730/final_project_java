package Controller;

import Controller.Action;
import DAO.ArticleDAO;
import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.Model;
import DataBean.Article;
import DataBean.ArticleBean;
import DataBean.CategoryBean;
import DataBean.CommentBean;
import FormBean.SearchForm;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SearchAction extends Action {
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;

    public SearchAction(Model model) {
        categoryDAO = model.getCategoryDAO();
        articleDAO = model.getArticleDAO();
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "search.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        SearchForm form = new SearchForm(request);

        List<String> errors = form.getValidationErrors();

        if (errors.size() > 0) {
            return "blog.do";
        }

        List<Article> articles = new ArrayList<>();
        List<ArticleBean> articleBeanList = articleDAO.getArticlesBySearch(form.getContent());

        for (ArticleBean articleBean: articleBeanList) {
            Article article = new Article();
            article.setArticleBean(articleBean);

            List<CommentBean> comments = commentDAO.getArticleComments(articleBean.getId());
            article.setNumberOfComments(comments.size());

            CategoryBean categoryBean = categoryDAO.read(articleBean.getCategoryId());
            article.setCategoryName(categoryBean.getTitle());

            articles.add(article);
        }

        request.setAttribute("articles", articles);

        return "blog.jsp";
    }
}
