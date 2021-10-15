package JDBCConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalProperty", "root", "wjd3289");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Can't connect to database" + e.getMessage());
        }
    }

    public boolean isHouseID(int houseID) {
        try {
            String SQL = "SELECT * FROM houseinfo WHERE houseid = " + houseID;
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error on database search" + e.getMessage());
        }
        return false;
    }

    public String getHouseAddress(int houseID) {
        try {
            String SQL = "SELECT * FROM houseinfo WHERE houseid = " + houseID;
            rs = st.executeQuery(SQL);
        if (rs.next()) {
                return rs.getString("address");
            }
        } catch (Exception e) {
            System.out.println("Error on searching houseID in database" + e.getMessage());
        }
        return null;
    }
}
