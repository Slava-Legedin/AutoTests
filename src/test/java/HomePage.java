import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends SetUp {

  //  private static WebDriver driver;

//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//
//    }


    public static WebElement buttonCloseCookie(){
        return driver.findElement(By.cssSelector(".cookie-alert button"));

    }

    public static WebElement fieldFromCity() {
        return driver.findElement(By.cssSelector(".origin input"));
    }

    public static WebElement selectAirport() {
        return driver.findElement(By.className("airport"));
    }
    //SetUp.untilElementClickable(By.className("airport")).click();
}
