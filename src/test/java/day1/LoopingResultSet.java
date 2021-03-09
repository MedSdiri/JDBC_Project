package day1;

import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args) throws SQLException {


        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        Connection con = DriverManager.getConnection(url, username, password) ;
        Statement  stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet  rs  = stm.executeQuery("SELECT * FROM REGIONS") ;

        // next method will move your cursor to next line
        // and also return true if you have more row and return false if there is no row
//        rs.next();
//        System.out.println("Region Value at this row is " + rs.getString("REGION_NAME")    ) ;

        while( rs.next() ) {

            System.out.println("REGION ID at this row is "  +   rs.getString("REGION_ID")    );
            System.out.println("Region Value at this row is " + rs.getString("REGION_NAME")    ) ;

        }

        // CREATE NEW ResultSet Object by running different query like
        // SELECT * FROM JOBS
        // you may reuse same variable





    }

}
