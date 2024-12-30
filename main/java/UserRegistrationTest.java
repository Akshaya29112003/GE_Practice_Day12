import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserRegistrationTest {
    @Test
    public void FirstName_Happy() {
        assertDoesNotThrow(() -> UserRegistration.validateFirstName("John"));
    }

    @Test
    public void FirstName_Sad() {
        Exception exception = Assert.assertThrows(UserDetailsException.class, () -> UserRegistration.validateFirstName("jo"));
        Assert.assertEquals("Invalid First Name: Must start with a capital letter and have at least 3 characters.", exception.getMessage());
    }

    @Test
    public void LastName_Happy() {
        assertDoesNotThrow(() -> UserRegistration.validateLastName("Doe"));
    }

    @Test
    public void LastName_Sad() {
        Exception exception = Assert.assertThrows(UserDetailsException.class, () -> UserRegistration.validateLastName("do"));
        Assert.assertEquals("Invalid Last Name: Must start with a capital letter and have at least 3 characters.", exception.getMessage());
    }

    @Test
    public void Email_Happy() {
        assertDoesNotThrow(() -> UserRegistration.validateEmail("john.doe@example.com"));
    }

    @Test
    public void Email_Sad() {
        Exception exception = Assert.assertThrows(UserDetailsException.class, () -> UserRegistration.validateEmail("john.doe@.com"));
        Assert.assertEquals("Invalid Email: Must follow the format abc.xyz@bl.co.in.", exception.getMessage());
    }

    @Test
    public void Phone_Happy() {
        assertDoesNotThrow(() -> UserRegistration.validatePhone("91 1234567890"));
    }

    @Test
    public void Phone_Sad() {
        Exception exception = Assert.assertThrows(UserDetailsException.class, () -> UserRegistration.validatePhone("911234567890"));
        Assert.assertEquals("Invalid Phone Number: Must follow the format 91 1234567890.", exception.getMessage());
    }

    @Test
    public void Password_Happy() {
        assertDoesNotThrow(() -> UserRegistration.validatePassword("Abc@1234"));
    }

    @Test
    public void Password_Sad() {
        Exception exception = Assert.assertThrows(UserDetailsException.class, () -> UserRegistration.validatePassword("abc1234"));
        Assert.assertEquals("Invalid Password: Must have:\n"
                + "- Minimum 8 characters\n"
                + "- At least 1 uppercase letter\n"
                + "- At least 1 numeric digit\n"
                + "- Exactly 1 special character.", exception.getMessage());
    }
}
