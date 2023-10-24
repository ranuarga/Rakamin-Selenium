package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User open the login page")
    public void userOpenTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        String pageLogin = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(pageLogin, "Swag Labs");
    }

    @And("User input standard_user username")
    public void userInputStandard_userUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input valid password")
    public void userInputValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User authenticated and redirected to Products page")
    public void userAuthenticatedAndRedirectedToProductsPage() {
        String pageTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(pageTitle, "Products");
        driver.close();
    }

    @And("User input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("wrong_sauce");
    }

    @Then("Wrong credential message appear")
    public void wrongCredentialMessageAppear() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}