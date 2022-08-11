package com.tau.steps;

import com.tau.base.BaseUtil;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class Steps extends BaseUtil {

    private final BaseUtil baseUtil;

    public Steps(BaseUtil baseUtil){
        this.baseUtil = baseUtil;
    }

    private WebDriver driver;

    @Before()
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credentials(String username, String password, String userFullName) {

        baseUtil.userFullName = userFullName;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_overview_page() {

        String actualUserFullName = driver.findElement(By.className("smallText")).getText();

        System.out.println(baseUtil.userFullName);

        assertTrue(actualUserFullName, actualUserFullName.contains(baseUtil.userFullName));

        driver.findElement(By.linkText("Log Out")).click();
    }

    @After()
    public void quitBrowser(){
        driver.quit();
    }
}