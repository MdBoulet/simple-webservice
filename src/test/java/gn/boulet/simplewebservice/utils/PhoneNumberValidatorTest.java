package gn.boulet.simplewebservice.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValider underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValider();
    }

    @Test
    @DisplayName("It should failed if phone number is incorrect")
    void itShouldValidatePhoneNumber() {
        String phoneNumber = "+224611126722";

        boolean isValid = underTest.test(phoneNumber);

        assertThat(isValid).isTrue();
    }

    @Test
    void isTextValid() {
        String username = "username";

        boolean isValid = underTest.isTextValid(username);

        assertThat(isValid).isTrue();
    }
}
