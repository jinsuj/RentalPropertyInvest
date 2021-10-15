import JDBCConnector.DBConnection;

public class RentalProperty {

    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        System.out.println("admin: " + conn.isHouseID(1));
        System.out.println("address: " + conn.getHouseAddress(1));
    }
}
