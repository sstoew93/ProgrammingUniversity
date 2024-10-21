import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement state = connection.prepareStatement("SELECT CONCAT_WS(' ', `first_name`, `last_name`) FROM employees" +
                " WHERE `salary` > 70000");

        ResultSet resultSet = state.executeQuery();

        while(resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }
}