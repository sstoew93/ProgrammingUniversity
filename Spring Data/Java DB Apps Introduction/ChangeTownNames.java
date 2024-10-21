import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ChangeTownNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        String jdbc = "jdbc:mysql://localhost:3306/minions_db";

        Connection connection = DriverManager.getConnection(jdbc, props);

        String sql = "SELECT `name` FROM `towns` WHERE `country` = ?;";

        String updateStatement = "UPDATE `towns` SET `name` = UPPER(`name`) WHERE `country` = ?;";

        PreparedStatement selectStatement = connection.prepareStatement(sql);
        selectStatement.setString(1, input);

        ResultSet resultSet = selectStatement.executeQuery();

        PreparedStatement update = connection.prepareStatement(updateStatement);
        update.setString(1, input);

        int updatedRows = update.executeUpdate();

        if (updatedRows == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        List<String> updatedTowns = new ArrayList<>();

        while (resultSet.next()) {
            updatedTowns.add(resultSet.getString("name"));
        }

        System.out.printf("%d town names were affected.%n", updatedRows);
        System.out.println(updatedTowns);
    }
}
