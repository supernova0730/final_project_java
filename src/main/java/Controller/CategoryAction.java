package Controller;

import DAO.*;
import DataBean.Article;
import DataBean.ArticleBean;
import DataBean.CategoryBean;
import DataBean.CommentBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CategoryAction extends Action {
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;

    public CategoryAction(Model model) {
        categoryDAO = model.getCategoryDAO();
        articleDAO = model.getArticleDAO();
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "category.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        CategoryBean category = categoryDAO.read(categoryId);

        if (category == null) {
            return "blog.do";
        }

        List<Article> articles = new ArrayList<>();
        List<ArticleBean> articleBeanList = articleDAO.getArticlesByCategoryID(category.getId());

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
