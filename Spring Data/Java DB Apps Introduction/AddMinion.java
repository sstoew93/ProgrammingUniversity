import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class AddMinion {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        Scanner scanner = new Scanner(System.in);
        int inputID = Integer.parseInt(scanner.nextLine());

        String sql = String.format("SELECT DISTINCT m.name, m.age FROM villains v " +
                "JOIN minions_villains mv ON v.id = mv.villain_id " +
                "JOIN minions m ON mv.minion_id = m.id " +
                "WHERE v.id = %s", inputID);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        String villainName = get_villainName(inputID, connection);

        System.out.printf("Villain: %s", villainName).append(System.lineSeparator());

        int minionsCounter = 0;
        while (resultSet.next()) {
            minionsCounter++;

            String minionName = resultSet.getString(1);
            int minionAge = resultSet.getInt(2);
            System.out.printf("%d. %s %d", minionsCounter, minionName, minionAge).append(System.lineSeparator());
        }

    }

    private static String get_villainName(int inputID, Connection connection) throws SQLException {
        String query = String.format("SELECT name FROM villains " +
                "WHERE id = %s", inputID);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            return resultSet.getString(1);
        }
        return String.format("No villain with ID %s exists in the database.", inputID);
    }
}
