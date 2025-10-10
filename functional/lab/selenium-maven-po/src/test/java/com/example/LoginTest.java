package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends DriverLifeCycleSetting {
    private LoginFormPO loginForm;
    private LoginSuccessPO loginSuccess;

    @Test
    void testLoginOK() {

        loginForm = new LoginFormPO(driver);
        // goto login success page
        loginSuccess = (LoginSuccessPO) loginForm.with("user", "user");
        assertTrue(loginSuccess.validBoxIsPresent());
    }

    @Test
    void testLoginFail() {

        loginForm = new LoginFormPO(driver);
        loginForm.with("user", "pippo");
        // stay in the login page
        assertTrue(loginForm.invalidBoxIsPresent());
    }

}
