import com.gargoylesoftware.htmlunit.javascript.host.intl.DateTimeFormat;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static javax.swing.UIManager.get;

public class ForTest {

public static     String date = LocalDateTime.now().plusDays(5).format(DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy").withLocale(Locale.ENGLISH));

    @Test
    public void test(){
//        By xp = By.xpath("//td/a[contains(@href, 'BT403')]");
        String date1 = LocalDateTime.now().plusDays(5).format(DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy").withLocale(Locale.ENGLISH));
        System.out.println(date1);
        //WeekFields wf = WeekFields.of(Locale.ENGLISH);
       // System.out.println(date);
         }
}
