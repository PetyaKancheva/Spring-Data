import java.sql.*;

public class GetVillainName {
    private  static final String GET_VILLAIN_NAME ="SELECT v.name, COUNT(distinct mv.minion_id) AS countOfMinions FROM villains AS v\n" +
            "JOIN minions_villains AS mv ON v.id=mv.villain_id\n" +
            "GROUP BY v.id\n" +
            "HAVING countOfMinions>?\n" +
            "ORDER BY countOfMinions DESC;";
    private static final String PRINT_FORMAT ="%s %s";
    private static final String COLUMN_LABEL_NAME="name";
    private static final String COLUMN_LABEL_MINIONSCOUNT ="countOfMinions";




    public static void main(String[] args) throws SQLException {
        final  Connection connection = Utils.getSQLconnection();
        final PreparedStatement statement = connection.prepareStatement(GET_VILLAIN_NAME);
        statement.setInt(1,15);
        final ResultSet resultSet= statement.executeQuery();

       printResult(resultSet);
       connection.close();

    }

    private static void printResult(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            System.out.printf(PRINT_FORMAT, resultSet.getString(COLUMN_LABEL_NAME), resultSet.getInt(COLUMN_LABEL_MINIONSCOUNT));
        }
    }


}
