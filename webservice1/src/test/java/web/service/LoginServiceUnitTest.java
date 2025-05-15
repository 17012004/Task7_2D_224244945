package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testLoginSuccess() {
        Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "01-01-2000"));
    }

    @Test
    public void testLoginFailWrongUsername() {
        Assert.assertFalse(LoginService.login("wrong", "ahsan_pass", "01-01-2000"));
    }

    @Test
    public void testLoginFailWrongPassword() {
        Assert.assertFalse(LoginService.login("ahsan", "wrong_pass", "01-01-2000"));
    }

    @Test
    public void testLoginFailWrongDOB() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "02-01-2000"));
    }

    @Test
    public void testLoginFailEmptyUsername() {
        Assert.assertFalse(LoginService.login("", "ahsan_pass", "01-01-2000"));
    }

    @Test
    public void testLoginFailNullUsername() {
        Assert.assertFalse(LoginService.login(null, "ahsan_pass", "01-01-2000"));
    }

    @Test
    public void testLoginFailEmptyPassword() {
        Assert.assertFalse(LoginService.login("ahsan", "", "01-01-2000"));
    }

    @Test
    public void testLoginFailEmptyDOB() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
    }

    @Test
    public void testLoginFailAllFieldsEmpty() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }
}
