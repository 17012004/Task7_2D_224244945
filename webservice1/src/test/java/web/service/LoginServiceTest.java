package web.service;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // ✅ Update path with correct ChromeDriver version 136
        System.setProperty("webdriver.chrome.driver",
            "C:/Users/HP/Downloads/chromedriver-win64_2/chromedriver-win64/chromedriver.exe");

        driver = new ChromeDriver();

        // ✅ Correct local file path format
        driver.get("file:///C:/Users/HP/Downloads/pages/login.html");
        sleep(1);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performLogin(String username, String password, String dob) {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys(password);

        driver.findElement(By.name("dob")).clear();
        driver.findElement(By.name("dob")).sendKeys(dob);

        driver.findElement(By.cssSelector("[type=submit]")).click();
    }

    @Test
    public void testLoginSuccess() {
        performLogin("ahsan", "ahsan_pass", "01-01-2000");
        sleep(1);
        String title = driver.getTitle();
        System.out.println("testLoginSuccess - Title: " + title);
        Assert.assertEquals("success", title);
    }

    @Test
    public void testLoginFailInvalidUsername() {
        performLogin("wrong_user", "ahsan_pass", "01-01-2000");
        sleep(1);
        String title = driver.getTitle();
        System.out.println("testLoginFailInvalidUsername - Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testLoginFailInvalidDOB() {
        performLogin("ahsan", "ahsan_pass", "02-01-2000");
        sleep(1);
        String title = driver.getTitle();
        System.out.println("testLoginFailInvalidDOB - Title: " + title);
        Assert.assertEquals("fail", title);
    }
}
