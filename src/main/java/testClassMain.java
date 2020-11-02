
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
public class testClassMain {
    @Test
    public void siteHeaderIsOnHomePage() {
        WebDriver browser;
        System.setProperty("webdriver.chrome.driver", "/Users/marisol.colon/Downloads/chromedriver 2");
        browser = new ChromeDriver();
        browser.get("http://google.com");
        browser.close();
    }
}
