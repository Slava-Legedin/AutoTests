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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Airbaltic {

    private WebDriver driver;
    private Wait<WebDriver> wait;


    @BeforeTest
    public void setupTest() {
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
        wait = new FluentWait<>(driver).withMessage("Element was not found").withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
    }

//    @AfterTest
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//
//        }
//    }

    @org.testng.annotations.Test
    public void test() {

        String date = LocalDateTime.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        navigate("https://www.airbaltic.com/");
        untilElementClickable(By.cssSelector(".cookie-alert button")).click();
        sendKeysOneByOne(By.cssSelector(".origin input"), "Kiev");
        untilElementClickable(By.className("airport")).click();

        sendKeysOneByOne(By.cssSelector(".destin input"), "Riga");
        untilElementClickable(By.className("airport")).click();

        untilElementClickable(By.xpath("//span[contains(text(), 'One-way')]")).click();

        sendKeysOneByOne(By.name("flt_leaving_on"), date);
        untilElementClickable(By.xpath("//label[contains(text(), 'Departure date')]")).click();

        if (untilElementNotVisible(By.className("flyout-calendar"))) {
            untilElementClickable(By.className("btn-search")).click();
        }
        pageSwitch();
        untilElementClickable(By.id("id_rad_0_0_0_EC")).click();
        //driver.findElement()
//        Assert.assertEquals(untilElementVisible(By.cssSelector("td.additional>a")).getText(), "BT403");
        Assert.assertEquals(untilElementClickable(By.xpath(ForTest.date)).getText(),"BT403");
//        String num  =driver.findElement(By.cssSelector("table.fsel-table a")).getText();
//        System.out.println(num);
        Assert.assertEquals(untilElementVisible(By.cssSelector("span.date")).getText(), ForTest.date);
        String dt = driver.findElement(By.cssSelector("span.date")).getText();
        System.out.println(dt);
        untilElementVisible(By.cssSelector(".payment-method .jq-selectbox__trigger-arrow")).click();
        untilElementClickable(By.xpath("//li[contains(text(), 'Debit/credit card')]")).click();
        untilElementClickable(By.xpath("//button[@class='btn btn-next button-green' and contains(text(), 'Continue')]")).click();

        pageSwitch();
    }



    public void sendKeysOneByOne(By by, String keys, int delay) {
        untilElementVisible(by).clear();
        for (char key : keys.toCharArray()) {
            if (delay > 0) {
                suspend(delay);
            }
            untilElementVisible(by).sendKeys(String.valueOf(key));
        }
    }

    public void sendKeysOneByOne(By by, String keys) {
        int delay = 100;
        sendKeysOneByOne(by, keys, delay);
    }


    private WebElement untilElementVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private boolean untilElementNotVisible(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement untilElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void suspend(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void navigate(String url) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        try {
            driver.navigate().to(url);
        } catch (TimeoutException e) {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        }
    }

    private void pageSwitch() {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        try {
            driver.findElement(By.tagName("body"));
        } catch (TimeoutException e) {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }

    }
}