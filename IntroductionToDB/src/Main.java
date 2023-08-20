import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String GET_VILLIAN_NAME ="SELECT name FROM minions_db.villains WHERE id=?" ;
    public static void main(String[] args) throws SQLException {
        final Scanner scanner = new Scanner(System.in);
        final int villainID =scanner.nextInt();

        final Connection connection = Utils.getSQLconnection();
        //check if Villain Exists:
        PreparedStatement statement = connection.prepareStatement(GET_VILLIAN_NAME);
        statement.setInt(1,villainID);
        ResultSet rs=statement.executeQuery();
       // rs.next();
        System.out.println(rs.getString("name"));

        System.out.println("Hello world!");
    }
}