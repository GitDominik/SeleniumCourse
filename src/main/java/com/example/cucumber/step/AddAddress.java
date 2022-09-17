package com.example.cucumber.step;

import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAddress implements En {
    private WebDriver webDriver;

    public AddAddress() {
        Given("I navigate to {string}", (String url) -> {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.get(url);
        });
        When("user click sign-in button on menu", () -> {
            webDriver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        });
        When("user enter email {string}", (String email) -> {
            WebElement element = webDriver.findElement(By.name("email"));
            element.sendKeys(email);

        });
        When("user enter password {string}", (String password) -> {
            WebElement element1 = webDriver.findElement(By.name("password"));
            element1.sendKeys(password);
        });
        When("user click sign-in on the login page", () -> {
            WebElement element2 = webDriver.findElement(By.id("submit-login"));
            element2.click();
        });
        When("user click address tile while logged in", () -> {
            WebElement addressElement = webDriver.findElement(By.id("addresses-link"));
            addressElement.click();

        });
        When("user click create new address tile while logged in", () -> {
            WebElement createAddress = webDriver.findElement(By.xpath("//div[@class='addresses-footer']/a"));
            createAddress.click();

        });
        When("user fill address form using values: alias {string}, address {string}, postalCode {string}, city {string}, phone {string},", (String alias, String address, String postalCode, String city, String phone) -> {
            WebElement alias2 = webDriver.findElement(By.cssSelector("input[name='alias']"));
            alias2.sendKeys(alias);
            WebElement address2 = webDriver.findElement(By.cssSelector("input[name='address1']"));
            address2.sendKeys(address);
            WebElement postalCode2 = webDriver.findElement(By.cssSelector("input[name='postcode']"));
            postalCode2.sendKeys(postalCode);
            WebElement city2 = webDriver.findElement(By.cssSelector("input[name='city']"));
            city2.sendKeys(city);
            WebElement phone2 = webDriver.findElement(By.cssSelector("input[name='phone']"));
            phone2.sendKeys(phone);

        });
        When("click save button on address form", () -> {
            WebElement saveButton = webDriver.findElement(By.cssSelector(".js-address-form button"));
            saveButton.click();
        });
        Then("check the address data using values: alias {string}, address {string}, postalCode {string}, city {string}, phone {string},", (String alias, String address, String postalCode, String country, String phone) -> {
            WebElement alias3 = webDriver.findElement(By.xpath("(//div[@class='address-body']/h4)"));
            Assertions.assertEquals(alias, alias3.getText());
            WebElement address3 = webDriver.findElement(By.xpath("//div[@class='address-body']/address"));
            Assertions.assertTrue(address3.getText().contains(address));
            WebElement postalCode3 = webDriver.findElement(By.xpath("//div[@class='address-body']/address"));
            Assertions.assertTrue(postalCode3.getText().contains(postalCode));
            WebElement country3 = webDriver.findElement(By.xpath("//div[@class='address-body']/address"));
            Assertions.assertTrue(country3.getText().contains(country));
            WebElement phone3 = webDriver.findElement(By.xpath("//div[@class='address-body']/address"));
            Assertions.assertTrue(phone3.getText().contains(phone));
        });
    }
}
