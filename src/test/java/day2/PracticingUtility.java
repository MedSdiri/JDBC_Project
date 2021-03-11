package day2;

import utility.DB_Utility;

public class PracticingUtility {

    public static void main(String[] args) {

        DB_Utility.createConnection();

        DB_Utility.runQuery("SELECT * FROM EMPLOYEES ") ;

//        DB_Utility.displayAllData();
        System.out.println("DB_Utility.getRowCount() = " + DB_Utility.getRowCount());
        System.out.println("DB_Utility.getColumnCount() = " + DB_Utility.getColumnCount());
        System.out.println("DB_Utility.getAllColumnNamesAsList() = \n\t"
                                + DB_Utility.getAllColumnNamesAsList());
        System.out.println("DB_Utility.getRowDataAsList(1) = \n\t"
                                + DB_Utility.getRowDataAsList(1));


        DB_Utility.destroy();



    }

}
