//import automation.HomePage;

//import automation.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Zenchik Nikita.
 */
public class LogPageTest {
    //System.setProperty("webdriver.opera.driver",".\\operadriver.exe");
    private WebDriver driver;

    @Test
    public void testSignIn() {
        driver = new OperaDriver();
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login"))
                .sendKeys("User1");
        //Enter password
        driver.findElement(By.id("user_pass"))
                .sendKeys("user1");
        //Click 'Sign in using our secure server' button
        driver.findElement(By.id("wp-submit"))
                .click();
        driver.manage()
                .timeouts()
                .implicitlyWait(2, TimeUnit.SECONDS);
        assert (driver.findElement(By.id("wpwrap")).isDisplayed());

    }

    @Test
    public void testNews() {
        driver = new OperaDriver();
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login"))
                .sendKeys("User4");
        //Enter password
        driver.findElement(By.id("user_pass"))
                .sendKeys("user4");
        //Click 'Sign in using our secure server' button
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.id("menu-pages")).click();
        driver.get("http://localhost:8888/wp-admin/post-new.php?post_type=page");
        driver.findElement(By.id("title")).sendKeys("News!!! Alexmak");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("publish")).click();
        //driver.findElement(By.id("post-preview")).click();

    }

    @Test
    public void testNegativeTestSignIn() {
        driver = new OperaDriver();
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("User6");
        //Enter password
        driver.findElement(By.id("user_pass"))
                .sendKeys("user123");
        //Click 'Sign in using our secure server' button
        driver.findElement(By.id("wp-submit"))
                .click();
        driver.manage()
                .timeouts()
                .implicitlyWait(2, TimeUnit.SECONDS);
        assert (driver.findElement(By.name("loginform")).isDisplayed());

    }

    @Test
    public void testOpenHello() {
        driver = new OperaDriver();
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login"))
                .sendKeys("User3");
        //Enter password
        driver.findElement(By.id("user_pass"))
                .sendKeys("user3");
        //Click 'Sign in using our secure server' button
        driver.findElement(By.id("wp-submit"))
                .click();
        driver.manage()
                .timeouts()
                .implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("wp-admin-bar-site-name"))
                .click();

    }

    @Test
    public void testWriteComment() {
        driver = new OperaDriver();
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login"))
                .sendKeys("User5");
        //Enter password
        driver.findElement(By.id("user_pass"))
                .sendKeys("user5");
        //Click 'Sign in using our secure server' button
        driver.findElement(By.id("wp-submit"))
                .click();
        driver.findElement(By.id("wp-admin-bar-site-name"))
                .click();
        driver.get("http://localhost:8888/?p=94");
        driver.findElement(By.id("comment")).sendKeys("You can much worked!!!");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void testNegativeWriteComment() {
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login"))
                .sendKeys("User2");
        //Enter password
        driver.findElement(By.id("user_pass"))
                .sendKeys("user2");
        //Click 'Sign in using our secure server' button
        driver.findElement(By.id("wp-submit"))
                .click();
        driver.findElement(By.id("wp-admin-bar-site-name"))
                .click();
        driver.get("http://localhost:8888/?p=94");
        driver.findElement(By.id("comment")).sendKeys(" ");
        driver.findElement(By.id("submit")).click();
        driver.manage()
                .timeouts()
                .implicitlyWait(2, TimeUnit.SECONDS);
        assert (driver.findElement(By.id("error-page")).isDisplayed());
    }


    @AfterClass
    public void delUser() {
        driver.quit();
    }


}


