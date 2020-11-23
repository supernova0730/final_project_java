package DAO;

public class ArticleDAO extends DAO {

    private final String tableName;

    public ArticleDAO(String jdbcDriver, String jdbcURL, String tableName) {
        super(jdbcDriver, jdbcURL);
        this.tableName = tableName;
    }
}