import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class SetUp {


    public static WebDriver driver;
    private static Wait<WebDriver> wait;


    public static void setupTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-plugins-discovery");
        chromeOptions.addArguments("--start-maximized");
        DesiredCapabilities dcap = new DesiredCapabilities();
//        dcap.setCapability("pageLoadStrategy", "none");
//        dcap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        driver = new ChromeDriver(dcap);
        driver = new ChromeDriver(chromeOptions);
        navigate("https://www.airbaltic.com/en-UA/index");
        wait = new FluentWait<>(driver).withMessage("Element was not found").withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
    }

    public static void sendKeysOneByOne(By by, String keys, int delay) {
        untilElementVisible(by).clear();
        for (char key : keys.toCharArray()) {
            if (delay > 0) {
                suspend(delay);
            }
            untilElementVisible(by).sendKeys(String.valueOf(key));
        }
    }

    public static void sendKeysOneByOne(By by, String keys) {
        int delay = 100;
        sendKeysOneByOne(by, keys, delay);
    }


    public static WebElement untilElementVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean untilElementNotVisible(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    static WebElement untilElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void suspend(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void navigate(String url) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        try {
            driver.navigate().to(url);
        } catch (TimeoutException e) {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        }
    }

    public static void pageSwitch() {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        try {
            driver.findElement(By.tagName("body"));
        } catch (TimeoutException e) {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }

    }
}
