package JDBCConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ArrayList<String> getHouseInfo(int houseID) {
        try {
            String SQL = "SELECT * FROM houseinfo WHERE houseid = " + houseID;
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(0, rs.getString("address"));
                list.add(1, rs.getString("vacant"));
                list.add(2, String.valueOf(rs.getDouble("rentAmount")));
                list.add(3, rs.getString("housetype"));
                return list;
            }
        } catch (Exception e) {
            System.out.println("Error on searching houseID in database" + e.getMessage());
        }
        return null;
    }
}
