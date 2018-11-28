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
            public void setUp()    {
        SetUp.setupTest();
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }

    @org.testng.annotations.Test
    public void test() {

//        String date = LocalDateTime.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
      //  HomePage home = new HomePage(driver);
        HomePage.buttonCloseCookie().click();
        HomePage.fieldFromCity().sendKeys("Kiev");
        HomePage.selectAirport().click();

   //     SetUp.untilElementClickable(By.cssSelector(".cookie-alert button")).click();
//        SetUp.sendKeysOneByOne(By.cssSelector(".origin input"), "Kiev");
//        SetUp.untilElementClickable(By.className("airport")).click();

/*        SetUp.sendKeysOneByOne(By.cssSelector(".destin input"), "Riga");
        SetUp.untilElementClickable(By.className("airport")).click();

        SetUp.untilElementClickable(By.xpath("//span[contains(text(), 'One-way')]")).click();

        SetUp.sendKeysOneByOne(By.name("flt_leaving_on"), date);
        SetUp.untilElementClickable(By.xpath("//label[contains(text(), 'Departure date')]")).click();

        if (SetUp.untilElementNotVisible(By.className("flyout-calendar"))) {
            SetUp.untilElementClickable(By.className("btn-search")).click();
        }
        SetUp.pageSwitch();
        SetUp.untilElementClickable(By.id("id_rad_0_0_0_EC")).click();
        //driver.findElement()
//        Assert.assertEquals(untilElementVisible(By.cssSelector("td.additional>a")).getText(), "BT403");
        Assert.assertEquals(SetUp.untilElementClickable(By.xpath(ForTest.date)).getText(),"BT403");
//        String num  =driver.findElement(By.cssSelector("table.fsel-table a")).getText();
//        System.out.println(num);
        Assert.assertEquals(SetUp.untilElementVisible(By.cssSelector("span.date")).getText(), ForTest.date);
        String dt = driver.findElement(By.cssSelector("span.date")).getText();
        System.out.println(dt);
        SetUp.untilElementVisible(By.cssSelector(".payment-method .jq-selectbox__trigger-arrow")).click();
        SetUp.untilElementClickable(By.xpath("//li[contains(text(), 'Debit/credit card')]")).click();
        SetUp.untilElementClickable(By.xpath("//button[@class='btn btn-next button-green' and contains(text(), 'Continue')]")).click();

        SetUp.pageSwitch();*/
    }



}