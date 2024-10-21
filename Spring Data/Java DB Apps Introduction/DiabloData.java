import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DiabloData {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String query = String.format("SELECT user_name, CONCAT(first_name, ' ', last_name), COUNT(*) AS count FROM users u" +
                " JOIN users_games ug ON ug.user_id = u.id" +
                " WHERE user_name = '%s'" +
                " GROUP BY u.id", input);

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(!resultSet.next()) {
            System.out.println("No such user exists");
            return;
        }

        String user = resultSet.getString(1);
        String names = resultSet.getString(2);
        int countGames = resultSet.getInt(3);

        System.out.printf("User: %s", input).append(System.lineSeparator());
        System.out.printf("%s has played %d games", names, countGames);
    }
}
