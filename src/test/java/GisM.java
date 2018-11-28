import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class GisM {


    WebDriver driver = new ChromeDriver();

    @Test

    public void Open() {
        driver.get("http://gismeteo.ua");
        List<WebElement> div = driver.findElements(By.xpath("//div"));
        System.out.println("div count = " + div.size());
        List<WebElement> divH2 = driver.findElements(By.xpath("//div[@class='h2']"));
        System.out.println("div with 'h2' class: " + divH2.size());
        List<WebElement> spans = driver.findElements(By.xpath("//div[@id='weather-news']//span"));
        for (WebElement element : spans) {
            String news = element.getText();
            System.out.println("News: " + news);
        }
        String lastElement = driver.findElement(By.xpath("//div[@id='weather-news']//li[last()]//span")).getText();
        System.out.println("Title of the last news: " + lastElement);
        List<WebElement> elWithText = driver.findElements(By.xpath("//*[text()='Киев']"));
        System.out.println("Kiev appears " + elWithText.size() + " times");
        String nextCity = driver.findElement(By.xpath("//div[@id='cities-teaser']//li[contains(.,'Киев')]/following-sibling::li")).getText();
        System.out.println("Next City after Kiev is: " + nextCity);
        List<WebElement> elMenu = driver.findElements(By.xpath("//div[@id='menu']/ul/li/a"));
        for (WebElement element : elMenu) {
            String menu = element.getAttribute("href");
            System.out.println("Menu links: " + menu);
        }
        driver.findElement(By.xpath("//div[@class='section higher']/div/span[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='group first']//a")).click();
        WebElement ThreeDays = driver.findElement(By.xpath("//div[@class='wtabs wrap']"));
        System.out.println("Element for 3 days: " + ThreeDays);

        driver.findElement(By.xpath("//div[@id='tab_wdaily2']")).click();
        WebElement currentDay = driver.findElement(By.xpath("//div[@id='tab_wdaily1']"));
        System.out.println("Current day element: " + currentDay);
        WebElement day = driver.findElement(By.xpath("//tbody[@id='tbwdaily3']/tr[contains(.,'Облачно')]"));
        //boolean day = driver.findElement(By.xpath("//tbody[@id='tbwdaily1']/tr[contains(.,'Малооблачно')]")).isDisplayed();
        if (day.isDisplayed()) {
            System.out.println("Сегодня Облачно!");
        } else if (!day.isDisplayed()) {
            driver.findElement(By.xpath("//div[@id='tab_wdaily2']")).click();

            WebElement day2 = driver.findElement(By.xpath("//tbody[@id='tbwdaily3']/tr[contains(.,'Облачно')]"));

            if (day2.isDisplayed()) {
                System.out.println("Завтра Облачно!");
            } else if (!day2.isDisplayed()) {
                driver.findElement(By.xpath("//div[@id='tab_wdaily3']")).click();
                WebElement day3 = driver.findElement(By.xpath("//tbody[@id='tbwdaily3']/tr[contains(.,'Облачно')]"));
                if (day3.isDisplayed()) {
                    System.out.println("Послезавтра Облачно!");
                }

            }

        }
        String temp = driver.findElement(By.xpath("//tbody[@id='tbwdaily3']/tr/td[3]/span[@class='value m_temp c']")).getText();
        System.out.println("Температура когда облачно: "+temp);
        driver.close();


    }
}
