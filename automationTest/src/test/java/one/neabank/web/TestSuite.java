package one.neabank.web;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestSuite extends WebDriverSettings {

    @Test
    public void pageOpen() {
        Common startPage = PageFactory.initElements(driver, Common.class);
        startPage.open();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("NEOBANK для бізнесу"));
    }

    @Test
    public void mobileNumber() {
        Common startPage = PageFactory.initElements(driver, Common.class);
        startPage.open();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formAuthLogin")));
        WebElement form = driver.findElement(By.id("formAuthLogin"));
        form.findElement(By.id("login")).sendKeys("+380636901699");
    }

    @Test
    public void buttonClick() throws InterruptedException {
        Common startPage = PageFactory.initElements(driver, Common.class);
        startPage.open();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formAuthLogin")));
        WebElement form = driver.findElement(By.id("formAuthLogin"));
        form.findElement(By.id("login")).sendKeys("+380636901699");
        form.findElement(By.id("btnNext")).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formAuthQr")));
        WebElement novalidateForm = driver.findElement(By.id("formAuthQr"));
        String message = novalidateForm.findElement(By.className("auth-form-title")).getText();
        Assert.assertTrue(message.equals("Відкриття бізнес-рахунку можливе тільки через додаток NEOBANK для бізнесу"));
    }
    @Test
    public void pageSize() {
        driver.manage().window().maximize();
        Common startPage = PageFactory.initElements(driver, Common.class);
        startPage.open();
    }
}