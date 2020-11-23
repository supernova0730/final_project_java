package Controller;

import DAO.ArticleDAO;
import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.Model;
import DataBean.Article;
import DataBean.ArticleBean;
import DataBean.CategoryBean;
import DataBean.CommentBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class BlogAction extends Action{
    private CategoryDAO categoryDAO;
    private ArticleDAO articleDAO;
    private CommentDAO commentDAO;

    public BlogAction(Model model) {
        categoryDAO = model.getCategoryDAO();
        articleDAO = model.getArticleDAO();
        commentDAO = model.getCommentDAO();
    }

    @Override
    public String getName() { return "blog.do"; }

    @Override
    public String performGet(HttpServletRequest request) {
        List<Article> articles = new ArrayList<>();
        List<ArticleBean> articleBeanList = articleDAO.getAllArticles();

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
