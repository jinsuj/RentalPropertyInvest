package Main;

import JDBCConnector.DBConnection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DBConnection conn = new DBConnection();
        System.out.println("What's your username?");
        String username = scan.next();
        System.out.println("What's your password?");
        String password = scan.next();
/*        boolean loginStatus = conn.getLoginInfo(username, password);
        if (loginStatus) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }*/
    }
}
