package browsertest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest{
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    public void compareElements(String first,String second)
    {
        Assert.assertEquals(first,second);
    }
    public void selectElements(By by,String text)
    {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectDropDownElements(By by,String text)
    {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void mouseHoverOnElement(By by)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        //actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    //This method will mouse hover on the element and then click the element
    public void mouseHoverAndClickOnElement(By by)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    public void selectRadioButton(By by) {
        driver.findElement(by).click();
    }
    public void selectCheckBox(By by) {

        WebElement checkBox = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox);
        actions.perform();
        if (checkBox.isSelected()) {

        } else {
            checkBox.click();
        }
    }
}
