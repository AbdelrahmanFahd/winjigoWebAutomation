package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By course = By.id("btnMyCoursesList");

    public void clickOnCourseButton() {
        driver.findElement(course).click();
    }

}
