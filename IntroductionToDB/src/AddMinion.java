import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {
    private static final String GET_TOWN_ID_BY_NAME = "SELECT id from towns WHERE name = ?";
    private static final String GET_VILLAIN_BY_NAME = "SELECT id FROM villains WHERE name = ?";
    private static final String ADD_TOWN_BY_NAME = "INSERT INTO towns(name) VALUES(?)";
    private static final String ADD_VILLAIN_BY_NAME = "INSERT INTO villains(name,evilness_factor) VALUES(?,'evil')";
    private static final String ADD_MINION_BY_NAME = "INSERT INTO minions(name,age,town_id) VALUES(?,?,?)";
    private static final String PRINT_FORMAT_TOWN_ADDED = "Town %s was added to the database.%n";
    private static final String PRINT_FORMAT_VILLAIN_ADDED = "Villain %s was added to the database.%n";
    private static final String PRINT_FORMAT_MINION_ADDED = "Successfully added %s to be minion of %s";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String[] minionInput = scanner.nextLine().split(" ");
        String villainName = scanner.nextLine().split(" ")[1];

        String minionName = minionInput[1];
        int minionAge = Integer.parseInt(minionInput[2]);
        String minionTown = minionInput[3];

        final Connection connection = Utils.getSQLconnection();

        addMinionWithVillain(connection, minionName, minionAge, minionTown, villainName);

        connection.close();

    }

    private static void addMinionWithVillain(Connection connection, String minionName, int minionAge, String minionTown, String villainName) throws SQLException {
        int townID = getTownID(connection, minionTown);
        int villainID = getVillainID(connection, villainName);

        PreparedStatement statementAddMinion = connection.prepareStatement(ADD_MINION_BY_NAME);
        statementAddMinion.setString(1, minionName);
        statementAddMinion.setInt(2, minionAge);
        statementAddMinion.setInt(3, townID);

        System.out.printf(PRINT_FORMAT_MINION_ADDED, minionName, villainName);
    }

    private static int getVillainID(Connection connection, String villainName) throws SQLException {
        PreparedStatement statementGetVillain = connection.prepareStatement(GET_VILLAIN_BY_NAME);
        statementGetVillain.setString(1, villainName);
        ResultSet resultSet = statementGetVillain.executeQuery();

        if (resultSet.next() == false) {
            PreparedStatement statementAddVillain = connection.prepareStatement(ADD_VILLAIN_BY_NAME);
            statementAddVillain.setString(1, villainName);
            statementAddVillain.executeUpdate();
            System.out.printf(PRINT_FORMAT_VILLAIN_ADDED, villainName);
            return getVillainID(connection, villainName);
        } else {
            return resultSet.getInt(Constants.COLUMN_LABEL_ID);
        }
    }

    private static int getTownID(Connection connection, String minionTown) throws SQLException {
        PreparedStatement statementGetTown = connection.prepareStatement(GET_TOWN_ID_BY_NAME);
        statementGetTown.setString(1, minionTown);
        ResultSet resultSet = statementGetTown.executeQuery();
        if (resultSet.next() == false) {
            PreparedStatement statementAddTown = connection.prepareStatement(ADD_TOWN_BY_NAME);
            statementAddTown.setString(1, minionTown);
            statementAddTown.executeUpdate();
            System.out.printf(PRINT_FORMAT_TOWN_ADDED, minionTown);
            return getTownID(connection, minionTown);
        } else {
            return resultSet.getInt(Constants.COLUMN_LABEL_ID);
        }

    }

}
