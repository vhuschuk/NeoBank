package one.neabank.web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Common {
  private WebDriver driver;
  private WebDriverWait wait;

    public Common(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://web.neobank.one/");
    }
}
