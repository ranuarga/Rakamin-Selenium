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

public class Cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User open the Products page")
    public void userOpenTheProductsPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        String pageLogin = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(pageLogin, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String pageTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(pageTitle, "Products");
    }

    @And("User click Add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @When("User click Shopping Cart button")
    public void userClickShoppingCartButton() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("Item is in Your Cart page")
    public void itemIsInYourCartPage() {
        String itemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(itemName, "Sauce Labs Backpack");
        driver.close();
    }
}
