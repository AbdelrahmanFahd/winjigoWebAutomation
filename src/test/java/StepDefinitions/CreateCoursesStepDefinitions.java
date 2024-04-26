package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CoursePage;
import pages.HomePage;
import pages.LoginPage;

public class CreateCoursesStepDefinitions {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    CoursePage coursePage;
    String courseName;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        coursePage = new CoursePage(driver);
    }

    @Given("^User Navigate to \"(.*)\"$")
    public void goToWINJIGOWebsite(String url) {
        driver.get(url);
    }

    @Given("^User Enter \"(.*)\" and \"(.*)\"$")
    public void enterEmailAndPassword(String email, String password) {
        loginPage.enterCredentials(email, password);
    }

    @And("Go to Courses Page")
    public void GoToCoursesPage() {
        homePage.clickOnCourseButton();
    }

    @When("^User Click on Add Course Button And Enter \"(.*)\" as the name, \"(.*)\" Grade and \"(.*)\" as a Teacher of the course$")
    public void addCourse(String courseName, String grade, String teacherName) throws InterruptedException {
        this.courseName = courseName;
        coursePage.clickOnAddCourseButton();
        coursePage.enterCourseInfo(courseName, grade, teacherName);
    }

    @Then("Course Title should be displayed in courses List")
    public void assertCourseTitleDisplayed() throws InterruptedException {
        homePage.clickOnCourseButton();
        coursePage.searchForCoursePage(courseName);
        Assert.assertEquals("The course failed to added", courseName, coursePage.getResultCourseName());

    }

    @After
    public void TireDown() {
        driver.quit();
    }
}
