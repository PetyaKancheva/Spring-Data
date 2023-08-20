

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeTownNamesCasing {
    private static final String GET_TOWN_COUNT = "SELECT COUNT(name) FROM towns WHERE country =?";
    private static final String GET_TOWNS_NAMES = "SELECT name FROM towns WHERE country =?";
    private static final String NO_AVAILABLE_TOWN = "No town names were affected.";
    private static final String PRINT_FORMAT_NUMBER_OF_AVAILABLE_TOWNS = "%d town names were affected.%n";
    private static final String UPDATE_TOWNS_NAMES ="UPDATE towns SET name = UPPER(name) WHERE country =?" ;

    public static void main(String[] args) throws SQLException {
        String countryName = new Scanner(System.in).nextLine();
        Connection connection = Utils.getSQLconnection();

        PreparedStatement statementCountTowns = connection.prepareStatement(GET_TOWN_COUNT);
        statementCountTowns.setString(1, countryName);
        ResultSet rs = statementCountTowns.executeQuery();
        rs.next();

        int countTown = rs.getInt(1);

        if (countTown == 0) {
            System.out.println(NO_AVAILABLE_TOWN);
            return;
        } else {
            System.out.printf(PRINT_FORMAT_NUMBER_OF_AVAILABLE_TOWNS, countTown);
            PreparedStatement updateTownsNames =connection.prepareStatement(UPDATE_TOWNS_NAMES);
            updateTownsNames.setString(1,countryName);
            updateTownsNames.executeUpdate();
            
            
            PreparedStatement statementGetTownsNames = connection.prepareStatement(GET_TOWNS_NAMES);
            statementGetTownsNames.setString(1, countryName);

            
            ResultSet resultSetNames = statementGetTownsNames.executeQuery();
            List<String> listOfTownNames= new ArrayList<>();
            while(resultSetNames.next()){
                listOfTownNames.add(resultSetNames.getString(1));
            }
            System.out.printf("[%s]", listOfTownNames.stream().collect(Collectors.joining(","))) ;
        }


        connection.close();
    }
}
