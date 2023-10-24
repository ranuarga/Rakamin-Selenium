package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User open the \"Checkout: Overview\" page and cart already filled")
    public void userOpenTheCheckoutOverviewPageAndCartAlreadyFilled() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        String pageLogin = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(pageLogin, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String pageProductsTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(pageProductsTitle, "Products");

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String itemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(itemName, "Sauce Labs Backpack");

        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        String pageYourInformationTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(pageYourInformationTitle, "Checkout: Your Information");

        driver.findElement(By.id("first-name")).sendKeys("Ranu");
        driver.findElement(By.id("last-name")).sendKeys("Arga");
        driver.findElement(By.id("postal-code")).sendKeys("60294");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        String pageOverviewTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(pageOverviewTitle, "Checkout: Overview");
    }

    @When("User click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }


    @Then("Redirect to Checkout: Complete! page")
    public void redirectToCheckoutCompletePage() {
        String pageTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(pageTitle, "Checkout: Complete!");
        driver.close();
    }
}
