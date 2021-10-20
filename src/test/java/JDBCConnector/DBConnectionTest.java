package JDBCConnector;

import Property.Property;
import User.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DBConnectionTest {

    DBConnectionForTest conn = new DBConnectionForTest();

    @Test
    public void testCreateUser() {
        User user = new User("testing234", "abcd1234");
        conn.createUser(user);
        boolean check = conn.isEmptyUser();
        assertEquals(check, false);
    }

    @Test
    public void testCreateHouse() {
        Property property = new Property("test address", "F", 3500.8, "Apartment");
        User user = new User("testing234", "abcd1234");
        conn.createUser(user);
        User userReturned = conn.getLoginInfo("testing234", "abcd1234");
        conn.createHouse(property, userReturned.getUserId());
        boolean flag = conn.isEmptyHouse();
        assertEquals(flag, false);
    }

    @Test
    public void testGetHouseInfo() {
        Property property = new Property("test address", "F", 3500.8, "Apartment");
        User user = new User("test2345", "abcd1234");
        conn.createUser(user);
        User userReturned = conn.getLoginInfo("test2345", "abcd1234");
        conn.createHouse(property, userReturned.getUserId());
        Property property2 = conn.getHouseInfo("test address");
        assertEquals("Apartment", property2.getPropertyType());
    }

    /**
     * User exists in the database should return true
     */
    @Test
    public void testCheckUser() {
        User user = new User("test2345", "abcd1234");
        conn.createUser(user);
        boolean target = conn.checkUser(user.getUsername());
        assertTrue(target);
    }

    @Test
    public void testCheckUserDoesNotExistInDatabase() {
        boolean target = conn.checkUser("testing124214");
        assertFalse(target);
    }

    @AfterAll
    @Test
    public void dropTables() {
        conn.dropTable();
    }
}