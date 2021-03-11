package day2;

import utility.ConfigurationReader;
import utility.DB_Utility;

public class PracticeUtility_Library {

    public static void main(String[] args) {


        String url      = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(url, username, password);

        DB_Utility.runQuery("SELECT count(*) FROM books") ;

        DB_Utility.displayAllData();

        System.out.println("FIRST ROW FIRST COLUMN VALUE IS "
                + DB_Utility.getFirstRowFirstColumn() );




        DB_Utility.destroy();





    }

}
