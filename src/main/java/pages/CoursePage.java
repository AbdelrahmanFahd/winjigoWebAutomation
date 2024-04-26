package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class CoursePage {
    WebDriver driver;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
    }

    By addCourseButton = By.id("btnListAddCourse");
    By courseName = By.id("txtCourseName");
    By year = By.id("courseGrade");
    By courseTeacherSelect = By.cssSelector("div[title=\"Course Teacher\"]");
    By courseTeacher = By.id("ui-select-choices-row-0-1");
    By createButton = By.id("btnSaveAsDraftCourse");
    By searchInput = By.id("txtCourseSearch");
    By ResultCourseName = By.id("lnkListCourseSelcted");

    public void clickOnAddCourseButton() {

        driver.findElement(addCourseButton).click();
    }

    public void enterCourseInfo(String course, String year, String teacherName)  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.year));
        WebElement select = driver.findElement(this.year);

        driver.findElement(courseName).sendKeys(course);
        Select yearSelect = new Select(select);
        yearSelect.selectByVisibleText(year);
        driver.findElement(courseTeacherSelect).click();
        driver.findElement(By.cssSelector("h5[title=\"" + teacherName + "\"]")).click();
        driver.findElement(createButton).click();
    }

    public void searchForCoursePage(String courseName) throws InterruptedException {
        driver.findElement(searchInput).sendKeys(courseName);
        sleep(1000);
        driver.findElement(searchInput).submit();
    }

    public String getResultCourseName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.ResultCourseName));

        return driver.findElement(ResultCourseName).getText();
    }
}
