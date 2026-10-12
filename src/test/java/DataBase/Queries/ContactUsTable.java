package DataBase.Queries;
import ObjectData.ContactUsObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactUsTable extends CommonTable {

    public ContactUsTable() throws SQLException {
        super();
    }

    public void insertContactUsData(ContactUsObject data)
            throws SQLException {

        if (isContactUsDataPresent(data)) {
            return;
        }

        String query = "INSERT INTO contact_us(first_name, last_name, email, message) " + "VALUES (?, ?, ?, ?)";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);

        statement.setString(1, data.getFirstName());
        statement.setString(2, data.getLastName());
        statement.setString(3, data.getEmail());
        statement.setString(4, data.getMessage());

        statement.executeUpdate();
        statement.close();
    }
    public boolean isContactUsDataPresent(ContactUsObject data)
            throws SQLException {

        String query =
                "SELECT * FROM contact_us "
                        + "WHERE first_name = ? "
                        + "AND last_name = ? "
                        + "AND email = ? "
                        + "AND message = ?";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);

        statement.setString(1, data.getFirstName());
        statement.setString(2, data.getLastName());
        statement.setString(3, data.getEmail());
        statement.setString(4, data.getMessage());

        ResultSet resultSet = statement.executeQuery();

        boolean result = resultSet.next();

        resultSet.close();
        statement.close();

        return result;
    }
}