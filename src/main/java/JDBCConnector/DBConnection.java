package JDBCConnector;

import User.User;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

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
            System.out.println("Can't connect to database, " + e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean getLoginInfo(String username, String password) {
        try {
            String SQL = "SELECT * FROM user WHERE username = '" + username + "' and password = '" + password + "'";
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkUser(String username) {
        try {
            String SQL = "SELECT * FROM user WHERE username = '" + username + "'";
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                System.out.println(rs.getString("username"));
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean createUser(String username, String password) {
        try {
            boolean checkUser = checkUser(username);
            if (checkUser) {
                return false;
            }
            User user = new User(username, password);
            String SQL = "INSERT into user values ( '" + username + "', '" + password + "')";
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
