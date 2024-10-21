import java.sql.*;
import java.util.Properties;

public class GetVillainNames {
    public static void main(String[] args) throws SQLException {

        String jdbc = "jdbc:mysql://localhost:3306/minions_db";
        String sql = "SELECT `name`, COUNT(v.`id`) as count FROM `villains` v" +
                " JOIN `minions_villains` mv ON v.`id` = mv.`villain_id`" +
                " GROUP BY v.`id` " +
                " HAVING `count` > 15" +
                " ORDER BY `count` DESC;";

        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection(jdbc, props);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d", resultSet.getString(1), resultSet.getInt(2)).append(System.lineSeparator());
        }
    }
}
