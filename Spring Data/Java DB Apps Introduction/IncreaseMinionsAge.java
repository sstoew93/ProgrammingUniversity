import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "root");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        for (String id : input) {
            String sql = "UPDATE minions" +
                    " SET age = age + 1, name = LOWER(name)" +
                    " WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        }

        PreparedStatement statement = connection.prepareStatement("SELECT name, age FROM minions");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String minionName = resultSet.getString(1);
            Integer minionAge = resultSet.getInt(2);
            System.out.printf("%s %d", minionName, minionAge).append(System.lineSeparator());
        }

    }
}
