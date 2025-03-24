package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private static final Duration timeout = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }
    public void openPage(String url) {
        driver.get(url);
    }

    public WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void writeTextBox(String locator, String text) {
        find(locator).sendKeys(text);
    }

    public void clickElement(String locator) {
        find(locator).click();
    }
}
