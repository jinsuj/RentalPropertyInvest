package JDBCConnector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {

    DBConnectionForTest conn = new DBConnectionForTest();

    @Test
    public void testIsHouseID() {
        conn.createTables();
        boolean flag = conn.isHouseID(1);
        assertEquals(flag, true);
    }

    @Test
    public void testIsHouseIDWithInvalidID() {
        boolean flag = conn.isHouseID(3);
        assertEquals(flag, false);
    }

    @Test
    public void testGetHouseInfo() {
        ArrayList<String> info = conn.getHouseInfo(2);
        assertEquals("condo", info.get(3));
    }

    @Test
    public void testGetUsernameInfo() {
        boolean target = conn.getLoginInfo("testing", "abcd1234");
        assertTrue(target);
    }

    /**
     * User exists in the database should return true
     */
    @Test
    public void testCheckUser() {
        boolean target = conn.checkUser("testing");
        assertTrue(target);
    }

    @Test
    public void testCheckUserDoesNotExistInDatabase() {
        boolean target = conn.checkUser("testing124214");
        assertFalse(target);
    }

    @Test
    public void testCheckUserWithUserThatDoesNotExist() {
        boolean target = conn.checkUser("asdlkfj");
        assertFalse(target);
    }

    @Test
    public void testCreateUser() {
        boolean target = conn.createUser("testing234", "abcd1234");
        assertTrue(target);
    }

    @Test
    public void dropTables() {
        conn.dropTable();
    }
}