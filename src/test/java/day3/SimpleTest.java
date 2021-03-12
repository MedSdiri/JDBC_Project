package day3;

import org.junit.BeforeClass;
import org.junit.Test;
import utility.ConfigurationReader;
import utility.DB_Utility;

import static org.junit.Assert.*;

public class SimpleTest {

    /**
     * Assuming that we captured the UI dashboard numbers from library1 app
     * Now we want to makes sure those numbers match the database data
     */
    @Test
    public void testDashboardNumbers(){

        int userCountUI = 8553 ;
        int bookCountUI = 1993 ;
        int borrowedBookCountUI = 800 ;

        String url      = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(url, username, password);
        DB_Utility.runQuery("SELECT count(*) FROM books")  ;

        String bookCountDB_Str =  DB_Utility.getFirstRowFirstColumn();
        int bookCountDB = Integer.parseInt(bookCountDB_Str) ;

        assertEquals(bookCountDB, bookCountUI );

        DB_Utility.runQuery("SELECT count(*) FROM users") ;
        int userCountDB =  Integer.parseInt(   DB_Utility.getFirstRowFirstColumn()   ) ;

        assertEquals(userCountDB, userCountUI);

        DB_Utility.runQuery("SELECT COUNT(*) FROM book_borrow " +
                                    "WHERE returned_date IS NULL") ;

        int borrowedBookCountDB = Integer.parseInt( DB_Utility.getFirstRowFirstColumn()  ) ;
        assertEquals(borrowedBookCountDB, borrowedBookCountUI);

        DB_Utility.destroy();

    }


}
