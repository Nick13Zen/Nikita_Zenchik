package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Zenchik Nikita.
 */
public class LoginPage {
        private static final String LOGIN_PAGE_URL = "http://localhost:8888/wp-login.php";
        private static final By USERNAME_INPUT = By.name("User1");
        private static final By PASSWORD_INPUT = By.name("user1");
        private static final By SIGN_IN_BUTTON = By.name("wp-submit");
        private WebDriver driver;
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }
        public automation.LoginPage open() {
            driver.get(LOGIN_PAGE_URL);
            return this;
        }
        public HomePage loginAs(String username, String password) {
            driver.findElement(USERNAME_INPUT)
                    .sendKeys(username);
            driver.findElement(PASSWORD_INPUT)
                    .sendKeys(password);
            driver.findElement(SIGN_IN_BUTTON)
                    .click();
            driver.findElement(By.id("wp-admin-bar-site-name")).findElement(By.className("ab-item")).click();
            WebElement element = driver.findElement(By.name("s"));
            element.sendKeys("Hello");
            element.submit();
            driver.findElement(By.xpath("//*http://localhost:8888/?p=1']")).click();
            WebElement relay = driver.findElement(By.xpath("//*[@value='http://localhost:8888/?p=1&replytocom=1#respond']"));
            driver.get("http://localhost:8888/?p=1&replytocom=1#respond");
            driver.findElement(By.xpath("//*[@value='comment'")).sendKeys("It's Okay");
            driver.findElement(By.name("submit"));
            return new HomePage(driver);
        }
    }

