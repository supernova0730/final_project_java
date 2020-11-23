package DataBean;
import java.util.Date;

public class CommentBean {
    private int id;
    private String authorName;
    private String email;
    private String content;
    private Date dateCreated;
    private int articleId;

    public int getId() {return id;}
    public String getAuthorName() {return authorName;}
    public String getEmail() {return email;}
    public String getContent() {return content;}
    public Date getDateCreated() {return dateCreated;}
    public int getArticleId() {return articleId;}

    public void setId(int id) {this.id = id;}
    public void setAuthorName(String authorName) {this.authorName = authorName;}
    public void setEmail(String email) {this.email = email;}
    public void setContent(String content) {this.content = content;}
    public void setDateCreated(Date dateCreated) {this.dateCreated = dateCreated;}
    public void setArticleId(int articleId) {this.articleId = articleId;}
}
