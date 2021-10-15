package JDBCConnector;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class DBConnectionTest {

    DBConnection conn = new DBConnection();

    @Test
    public void testIsHouseID() {
        boolean flag = conn.isHouseID(1);
        assertEquals(flag, true);
    }

    @Test
    public void testGetHouseInfo() {
        ArrayList<String> info = conn.getHouseInfo(2);
        assertEquals("condo", info.get(3));
    }

}