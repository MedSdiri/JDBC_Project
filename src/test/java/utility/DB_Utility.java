package utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Utility {

    private static Connection con ;
    private static Statement stm ;
    private static ResultSet rs ;
    private static ResultSetMetaData rsmd ;

    /**
     * Create connection method , just checking one connection successful or not
     */
    public static void createConnection(){

        String url      = ConfigurationReader.getProperty("hr.database.url") ;
        String username = ConfigurationReader.getProperty("hr.database.username") ;
        String password = ConfigurationReader.getProperty("hr.database.password") ;

        try {
            con = DriverManager.getConnection(url , username, password) ;
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED " + e.getMessage() );
        }


    }

    /**
     * Create Connection by jdbc url and username , password provided
     * @param url
     * @param username
     * @param password
     */
    public static void createConnection(String url , String username, String password){


        try {
            con = DriverManager.getConnection(url, username, password) ;
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED " + e.getMessage() );
        }

    }

    /**
     * Run the sql query provided and return ResultSet object
     * @param sql
     * @return ResultSet object  that contains data
     */
    public static ResultSet runQuery(String sql){

        try {
             stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = stm.executeQuery(sql); // setting the value of ResultSet object
             rsmd = rs.getMetaData() ;  // setting the value of ResulSetMetaData for reuse
        }catch(SQLException e){
            System.out.println("ERROR OCCURRED WHILE RUNNING QUERY "+ e.getMessage() );
        }

         return rs ;

    }

    /**
     * destroy method to clean up all the resources after being used
     */
    public static void destroy(){
        // WE HAVE TO CHECK IF WE HAVE THE VALID OBJECT FIRST BEFORE CLOSING THE RESOURCE
        // BECAUSE WE CAN NOT TAKE ACTION ON AN OBEJCT THAT DOES NOT EXIST
        try {
            if( rs!=null)  rs.close();
            if( stm!=null)  stm.close();
            if( con!=null)  con.close();
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE CLOSING RESOURCES " + e.getMessage() );
        }

    }


    // find out the row count

    /**
     * find out the row count
     * @return row count of this ResultSet
     */
    public static int getRowCount(){

        int rowCount = 0 ;
        try {
            rs.last() ;
            rowCount = rs.getRow() ;
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE GETTING ROW COUNT " + e.getMessage() );
        }

        return rowCount ;

    }


    /**
     * find out the column count
     * @return column count of this ResultSet
     */
    public static int getColumnCount(){

        int columnCount = 0 ;

        try {
            columnCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE GETTING COLUMN COUNT " + e.getMessage() );
        }

        return columnCount ;

    }

    // Get all the Column names into a list object

    public static List<String> getAllColumnNamesAsList(){

        List<String> columnNameLst = new ArrayList<>();

        try {
            for (int colIndex = 1; colIndex <= getColumnCount() ; colIndex++) {
                String columnName =  rsmd.getColumnName(colIndex) ;
                columnNameLst.add(columnName) ;
            }
        }catch (SQLException e){
            System.out.println("ERROR OCCURRED WHILE getAllColumnNamesAsList "+ e.getMessage());
        }

        return columnNameLst ;

    }




}
