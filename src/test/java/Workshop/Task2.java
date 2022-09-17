package Workshop;

import com.beust.ah.A;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Task2 {

    private static WebDriver driver;

    public static void main(String[] args) throws IOException {

        //ustawianie Chrome drivera w klasie "task1"
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // ustawienia timeouts i maksymalizacja okna
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();

        //otwieranie strony "my store"
        driver.get("https://mystore-testlab.coderslab.pl/");

        //logowanie się na profil klienta adresem email i hasłem
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        WebElement element = driver.findElement(By.name("email"));
        element.click();
        element.sendKeys("doejohn@gmail.com");
        WebElement element1 = driver.findElement(By.name("password"));
        element1.click();
        element1.sendKeys("Johndoe100%");
        WebElement element2 = driver.findElement(By.id("submit-login"));
        element2.click();

        //wybieranie produktu
        WebElement element3 = driver.findElement(By.id("_desktop_logo"));
        element3.click();
        WebElement element4 = driver.findElement(By.cssSelector("img[alt='Brown bear printed sweater']"));
        element4.click();

        //wybieranie rozmiaru M
        WebElement element5 = driver.findElement(By.id("group_1"));
        element5.click();
        Select select = new Select(element5);
        select.selectByIndex(1);

        //wybieranie ilości
        WebElement element6 = driver.findElement(By.id("quantity_wanted"));
        element6.clear();
        element6.sendKeys("5");

        // dodawanie produktu do koszyka
        WebElement element7 = driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary"));
        element7.click();
        WebElement element8 = driver.findElement(By.cssSelector(".cart-content-btn .btn-primary"));
        element8.click();

        //przejście do kup i zapłać
        WebElement element9 = driver.findElement(By.cssSelector(".cart-detailed-actions .btn-primary"));
        element9.click();
        WebElement element10 = driver.findElement(By.cssSelector("button[name='confirm-addresses']"));
        element10.click();

        //wybranie formy płatności - pay by check
        WebElement element11 = driver.findElement(By.cssSelector("section#checkout-payment-step > .h3.step-title"));
        element11.click();
        WebElement element12 = driver.findElement(By.cssSelector("div:nth-of-type(1) > .payment-option > label > span"));
        element12.click();
        WebElement element13 = driver.findElement(By.cssSelector("input#conditions_to_approve\\[terms-and-conditions\\]"));
        element13.click();
        WebElement element14 = driver.findElement(By.cssSelector(".btn.btn-primary.center-block"));
        element14.click();

        //robienie screenshota
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Dominik\\IdeaProjects\\SeleniumCourse\\src\\main\\resources\\screenshots\\order.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Your product has been bought successfully");
    }
}


