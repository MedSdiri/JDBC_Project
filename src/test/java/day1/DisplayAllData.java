package day1;

import java.sql.*;

public class DisplayAllData {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        Connection con = DriverManager.getConnection(url, username, password) ;
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet  rs  = stm.executeQuery("SELECT * FROM EMPLOYEES") ;

        // How to move to last row  --->> rs.last()
        // How to get current row number  --->> rs.getRow()
        rs.last() ;
        int rowNum =  rs.getRow() ;
        //System.out.println("rowNum = " + rowNum);

        ResultSetMetaData rsmd = rs.getMetaData() ;
        int colCount = rsmd.getColumnCount();


        // I want to print out my entire first row of data in one line
//        rs.first();
//        for (int col = 1; col <= colCount; col++) {
//
//            System.out.print(rs.getString( col )   + "\t" );
//
//        }
//        System.out.println();
        // THIS IS PRINTING COLUMN NAMES
        for (int col = 1; col <= colCount; col++) {
            System.out.print( rsmd.getColumnName(col) + "\t");
        }
        System.out.println();

        // THIS IS PRINTING EACH ROW DATA
        rs.beforeFirst();
        // now I want to go through each and every row
        while(rs.next()) {
            // this will print entire row
            for (int col = 1; col <= colCount; col++) {
                System.out.print(rs.getString(col) + "\t");
            }
            System.out.println();
        }














    }


}
