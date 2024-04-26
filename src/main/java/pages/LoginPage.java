package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("Email");
    By password = By.id("inputPassword");
    By loginButton = By.id("btnLogin");

    public void enterCredentials(String email, String password) {
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginButton).click();

    }
}
