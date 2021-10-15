package User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    private User user = new User("testttttttt", "testtttttt");

    @Test
    public void testGetUsername() {
        assertEquals(user.getUsername(), "testttttttt");
    }

    @Test
    public void testGetPassword() {
        assertEquals(user.getPassword(), "testtttttt");
    }

    @Test
    public void testSetUsername() {
        user.setUsername("TESTTTTTTTTTTTT");
        assertEquals(user.getUsername(), "TESTTTTTTTTTTTT");
    }

    @Test
    public void testSetUsernameWithWrongArgument() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.setUsername("Jin"),"Please set your username length to be between 5 to 20");
    }

    @Test
    public void testSetPassword() {
        user.setPassword("abcdabcdabcdabcd");
        assertEquals(user.getPassword(), "abcdabcdabcdabcd");
    }

    @Test
    public void testSetPasswordWithWrongArgument() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.setPassword("Jin"));
    }
}