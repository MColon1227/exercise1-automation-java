/*
1.Go to apple.com.mx
2.Go to Mac.
3.User Assert for the following text:
  Velocidad para llevar a todas partes.
4.Click on the search bar.
5.Search for iPhone SE.
6.Validate Page Title. It should be: "iPhone SE - Apple (MX)".
7.Validate all these options are available and enabled:
 */


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class testClass {
    @Test
    public void site_header_is_on_home_page() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/marisol.colon/Downloads/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.apple.com.mx/");
        sleep(2000);

        driver.findElement(By.xpath("//nav[@id='ac-globalnav']//ul[@class='ac-gn-list']//a[@href='/mx/mac/']")).click();
        sleep(2000);

        String ExpectedMSG = "Velocidad para llevar a todas partes.";
        String ActualMSG = driver.findElement(By.xpath("/html//main[@id='main']/section[2]//p[.='Velocidad para llevar a todas partes.']")).getText();
        System.out.println("Actual message: "+ ActualMSG);
        try {
            assertEquals(ExpectedMSG,ActualMSG);
        }
        catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }

        WebElement searchButton = driver.findElement(By.xpath("/html//a[@id='ac-gn-link-search']"));
        searchButton.click();
        sleep(2000);

        WebElement searchAction = driver.findElement(By.id("ac-gn-searchform-input"));
        sleep(2000);
        searchAction.sendKeys("iPhoneSE");
        searchAction.submit();

        String pageTitle = driver.getTitle();
        System.out.println("The actual title is: " + pageTitle);
        Assert.assertEquals("iPhoneSE - Apple (MX)", pageTitle);
        System.out.println("Assert equals passed.");
        sleep(2000);

        WebElement clickTiltle = driver.findElement(By.xpath("/html//div[@id='exploreCurated']/div[@class='as-explore-product position-1']/div[@class='as-product-description']/h2[@class='as-productname as-util-relatedlink']"));
        clickTiltle.click();
        sleep(2000);

        WebElement description = driver.findElement(By.xpath("/html//nav[@id='ac-localnav']/div[@class='ac-ln-wrapper']//ul[@class='ac-ln-menu-items']//span[@role='link']"));
        WebElement whyChange = driver.findElement(By.xpath("/html//nav[@id='ac-localnav']/div[@class='ac-ln-wrapper']//ul[@class='ac-ln-menu-items']//a[@href='/mx/iphone-se/why-upgrade/']"));
        WebElement specifications = driver.findElement(By.xpath("/html//nav[@id='ac-localnav']/div[@class='ac-ln-wrapper']//ul[@class='ac-ln-menu-items']//a[@href='/mx/iphone-se/specs/']"));
        WebElement buy = driver.findElement(By.xpath("/html//nav[@id='ac-localnav']/div[@class='ac-ln-wrapper']//a[@href='/mx/shop/goto/buy_iphone/iphone_se']"));

        Assert.assertTrue(description.isEnabled());
        Assert.assertTrue(whyChange.isEnabled());
        Assert.assertTrue(specifications.isEnabled());
        Assert.assertTrue(buy.isEnabled());

        System.out.println("Elements are Enable – Assert passed");
        driver.close();
    }
}

