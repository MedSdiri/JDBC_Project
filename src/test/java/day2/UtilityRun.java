package day2 ;

import utility.ConfigurationReader;
import utility.DB_Utility;

import java.sql.*;

public class UtilityRun {

    public static void main(String[] args) throws SQLException {

//       DB_Utility.createConnection() ;


        String url      = ConfigurationReader.getProperty("hr.database.url") ;
        String username = ConfigurationReader.getProperty("hr.database.username") ;
        String password = ConfigurationReader.getProperty("hr.database.password") ;

        DB_Utility.createConnection(url, username, password);

        ResultSet result = DB_Utility.runQuery("SELECT * FROM REGIONS") ;
        result.next();
        System.out.println("region name " + result.getString("REGION_NAME"));

        int totalRow = DB_Utility.getRowCount() ;
        System.out.println("totalRow = " + totalRow);

        int totalColumn = DB_Utility.getColumnCount() ;
        System.out.println("totalColumn = " + totalColumn);

        System.out.println("DB_Utility.getAllColumnNamesAsList() = "
                    + DB_Utility.getAllColumnNamesAsList());

        System.out.println("DB_Utility.getRowDataAsList(3) = "
                        + DB_Utility.getRowDataAsList(3));

        System.out.println("DB_Utility.getCellValue(3,2) = "
             + DB_Utility.getCellValue(3,2));

        System.out.println("DB_Utility.getCellValue(3, \"REGION_NAME\") = "
                + DB_Utility.getCellValue(3, "REGION_NAME"));

//        System.out.println("RIGHT NOW WE ARE AT ROW " + result.getRow() );

        System.out.println("DB_Utility.getColumnDataAsList(2) = "
                    + DB_Utility.getColumnDataAsList(2));

        System.out.println("DB_Utility.getColumnDataAsList(\"REGION_NAME\") = "
                            + DB_Utility.getColumnDataAsList("REGION_NAME"));

//        DB_Utility.displayAllData();
        System.out.println("DB_Utility.getRowMap(3) = "
                    + DB_Utility.getRowMap(3));


        DB_Utility.destroy();

    }

}
