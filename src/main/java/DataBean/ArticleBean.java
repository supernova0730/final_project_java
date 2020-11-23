package DataBean;

import java.util.Date;

public class ArticleBean {
    private int id;
    private String title;
    private String minContent;
    private String content;
    private Date dateCreated;
    private int categoryId;
    private String image;

    public int getId() {return id;}
    public String getTitle() {return title;}
    public String getMinContent() {return minContent;}
    public String getContent() {return content;}
    public Date getDateCreated() {return dateCreated;}
    public int getCategoryId() {return categoryId;}
    public String getImage() {return image;}

    public void setId(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setMinContent(String minContent) {this.minContent = minContent;}
    public void setContent(String content) {this.content = content;}
    public void setDateCreated(Date dateCreated) {this.dateCreated = dateCreated;}
    public void setCategoryId(int categoryId) {this.categoryId = categoryId;}
    public void setImage(String image) {this.image = image;}
}
