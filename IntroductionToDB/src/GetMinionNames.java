import java.sql.*;
import java.util.Scanner;

public class GetMinionNames {
    private static final String GET_MINIOINS_BY_VILLAIN_ID = "SELECT DISTINCT m.name, m.age FROM villains AS v\n" +
            "         JOIN minions_villains mv ON v.id = mv.villain_id\n" +
            "         JOIN minions m ON mv.minion_id = m.id\n" +
            "WHERE villain_id =?";
    private static final String GET_VILLIAN_NAME = "SELECT name FROM minions_db.villains WHERE id=?";
    private static final String PRINT_FORMAT_VILLAIN_NAME = "Villain: %s%n";
    private static final String PRINT_FORMAT_NO_VILLAIN_FOUND = "No villain with ID %d exists in the database.";
    private static final String PRINT_FORMAT_MINION_NAMES = "%d. %s %d%n";


    public static void main(String[] args) throws SQLException {

        final Scanner scanner = new Scanner(System.in);
        final int villainID = scanner.nextInt();

        final Connection connection = Utils.getSQLconnection();

        PreparedStatement statement = connection.prepareStatement(GET_VILLIAN_NAME);
        statement.setInt(1, villainID);
        ResultSet rs = statement.executeQuery();

        printVillainName(rs, villainID);

        statement = connection.prepareStatement(GET_MINIOINS_BY_VILLAIN_ID);
        statement.setInt(1, villainID);
        rs = statement.executeQuery();
        printMinionsNames(rs);

        connection.close();
    }

    private static void printVillainName(ResultSet resultSet, int villainID) throws SQLException {
        if (resultSet.next() == false) {
            System.out.printf(PRINT_FORMAT_NO_VILLAIN_FOUND, villainID);

        } else {
            System.out.printf(PRINT_FORMAT_VILLAIN_NAME, resultSet.getString(Constants.COLUMN_LABEL_NAME));
        }
    }

    private static void printMinionsNames(ResultSet resultSet) throws SQLException {
        int count = 1;
        while (resultSet.next()) {
            System.out.printf(PRINT_FORMAT_MINION_NAMES, count, resultSet.getString(Constants.COLUMN_LABEL_NAME), resultSet.getInt(Constants.COLUMN_LABEL_AGE));
            count++;
        }
        ;
    }
}
