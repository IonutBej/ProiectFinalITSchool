package DataBase.Queries;

import DataBase.DBConnection;

import java.sql.SQLException;

public class CommonTable {

    protected DBConnection dbConnection;

    public CommonTable() throws SQLException {
        dbConnection = DBConnection.getInstance();
    }
}