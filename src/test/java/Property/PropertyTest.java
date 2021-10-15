package Property;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PropertyTest {

    Property property = new Property("test street", "F", 1500.58, "Apartment");

    @Test
    public void testGetAddress() {
        assertEquals("test street", property.getAddress());
    }

    @Test
    public void testGetVacant() {
        assertEquals("F", property.getVacant());
    }

    @Test
    public void testGetRentAmount() {
        assertEquals(1500.58, property.getRentAmount());
    }

    @Test
    public void testGetPropertytype() {
        assertEquals("Apartment", property.getPropertyType());
    }

    @Test
    public void testSetAddress() {
        property.setAddress("different street");
        assertEquals("different street", property.getAddress());
    }

    @Test
    public void testSetVacant() {
        property.setVacant("T");
        assertEquals("T", property.getVacant());
    }

    @Test
    public void testSetRentAmount() {
        property.setRentAmount(3000);
        assertEquals(3000, property.getRentAmount());
    }

    @Test
    public void testSetPropertyType() {
        property.setPropertyType("Single family home");
        assertEquals("Single family home", property.getPropertyType());
    }
}