package day3;

import org.junit.Test;
import utility.ConfigurationReader;
import utility.DB_Utility;

public class SpartanTest {


    @Test
    public void testSpartanApp(){

        String url = ConfigurationReader.getProperty("spartan.database.url");
        String username = ConfigurationReader.getProperty("spartan.database.username");
        String password = ConfigurationReader.getProperty("spartan.database.password");

        DB_Utility.createConnection(url,username, password);

        DB_Utility.runQuery("SELECT * FROM SPARTANS") ;
        DB_Utility.displayAllData();

        DB_Utility.destroy();

    }

}
