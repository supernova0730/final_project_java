package DataBean;

public class Article {
    private ArticleBean articleBean;
    private int numberOfComments;
    private String categoryName;

    public ArticleBean getArticleBean() { return articleBean; }
    public void setArticleBean(ArticleBean articleBean) { this.articleBean = articleBean; }

    public int getNumberOfComments() { return numberOfComments; }
    public void setNumberOfComments(int numberOfComments) { this.numberOfComments = numberOfComments; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}