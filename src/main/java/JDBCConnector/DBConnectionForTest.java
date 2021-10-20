package JDBCConnector;

import Property.Property;
import User.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnectionForTest {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnectionForTest() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalProperty", "root", "wjd3289");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Can't connect to database, " + e.getMessage());
        }
    }

    public void dropTable() {
        try {
            String SQL = "DELETE FROM testhouseinfo";
            st.executeUpdate(SQL);
            SQL = "DELETE FROM testdata";
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Check if house is empty
     * @return false if house is not empty
     */
    public boolean isEmptyHouse() {
        try {
            String SQL = "SELECT * FROM testhouseinfo";
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * Check if user is empty
     * @return false if house is not empty
     */
    public boolean isEmptyUser() {
        try {
            String SQL = "SELECT * FROM testdata";
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void createUser(User user) throws IllegalArgumentException {
        try {
            boolean check = checkUser(user.getUsername());
            if (check) {
                throw new IllegalArgumentException("There's already same username");
            }
            String SQL = "INSERT INTO testdata(username, password) VALUES ('" + user.getUsername() + "','" +  user.getPassword() +"')";
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createHouse(Property house, int userID) {
        try {
            String SQL = "INSERT INTO testhouseinfo " +
                            "SET address = '" + house.getAddress() + "'," +
                                "housetype = '" + house.getPropertyType() + "'," +
                                "rentAmount = " + house.getRentAmount() + "," +
                                "vacant = '" + house.getVacant() + "'," +
                                "user_id = (" +
                                    "SELECT userID " +
                                    "FROM testdata " +
                                    "WHERE userID = " + userID + ")";
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Property getHouseInfo(String address) {
        try {
            String SQL = "SELECT * FROM testhouseinfo WHERE address = '" + address + "'";
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                Property property = new Property();
                property.setAddress(rs.getString("address"));
                property.setVacant(rs.getString("vacant"));
                property.setRentAmount(rs.getDouble("rentAmount"));
                property.setPropertyType(rs.getString("housetype"));
                property.setPropertyId(rs.getInt("houseId"));
                property.setUserId(rs.getInt("user_id"));
                return property;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User getLoginInfo(String username, String password) {
        try {
            String SQL = "SELECT * FROM testdata WHERE username = '" + username + "' and password = '" + password + "'";
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserId(rs.getInt("userID"));
                return user;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean checkUser(String username) {
        try {
            String SQL = "SELECT * FROM testdata WHERE username = '" + username + "'";
            rs = st.executeQuery(SQL);
            if (rs.next()) {
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
            String SQL = "INSERT into testdata values ( '" + username + "', '" + password + "')";
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void removeUser(String username) {
        try {
            String SQL = "DELETE FROM testdata WHERE username = '" + username + "'";
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
