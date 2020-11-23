package DAO;

public class DAOException extends Exception {
    public DAOException(Exception ex) {
        super(ex);
    }

    public DAOException(String str) {
        super(str);
    }
}
