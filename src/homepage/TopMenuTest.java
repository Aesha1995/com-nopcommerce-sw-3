package homepage;

import browsertest.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void openLink()
    {
        openBrowser(baseUrl);
    }
    @After
    public void closeLink()
    {
        closeBrowser();
    }
    public void selectMenu(String menu)
    {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='"+menu+"']"));
    }
    @Test
    public void verifyPageNavigation()
    {
        String menuName = "Computers";
        String expectedMsg = "Computers";
        selectMenu(menuName);
        String actualMsg = getTextFromElement(By.xpath("//h1[text()='Computers']"));
        compareElements(expectedMsg,actualMsg);
    }
}
