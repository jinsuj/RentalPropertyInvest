package DatabaseSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseSetupDev {

    private static Connection con;
    private static Statement st;
    private static ResultSet rs;

    public static void main(String[] args) {
        createTables();
    }

    public static void createTables() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalProperty", "root", "");
            st = con.createStatement();
            String SQL = "CREATE TABLE testdata (userID int NOT NULL AUTO_INCREMENT, username varchar(255), password varchar(255), PRIMARY KEY (userID))";
            st.executeUpdate(SQL);
            SQL = "CREATE TABLE testhouseinfo (address varchar(255), houseID int NOT NULL AUTO_INCREMENT, housetype varchar(255), rentAmount double(20,2), vacant varchar(20), user_id int, PRIMARY KEY (houseID), FOREIGN KEY (user_id) REFERENCES testdata(userID))";
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println("Can't connect to database, " + e.getMessage());
        }
    }
}
