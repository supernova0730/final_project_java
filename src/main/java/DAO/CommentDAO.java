package DAO;

public class CommentDAO extends DAO {

    private final String tableName;

    public CommentDAO(String jdbcDriver, String jdbcURL, String tableName) {
        super(jdbcDriver, jdbcURL);
        this.tableName = tableName;
    }

}