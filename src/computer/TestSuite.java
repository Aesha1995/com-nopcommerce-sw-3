package computer;

import browsertest.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
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
    @Test
    public void verifyProductArrangeInAlphabeticalOrder()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        clickOnElement(By.xpath("//h2[@class='title']//a[normalize-space()='Desktops']"));
        List<WebElement> beforeSelectElementList = driver.findElements(By.xpath("//div/h2[@class='product-title']"));

        List <String> beforeSelectElementList1 = new ArrayList<>();
        for (WebElement list :beforeSelectElementList) {
            beforeSelectElementList1.add(String.valueOf(list.getText()));

        }
        selectElements(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        List<WebElement> afterSelectElementList = driver.findElements(By.xpath("//h2[@class='product-title']"));

        List<String> afterSelectElementList1 = new ArrayList<>();
        for (WebElement list1:afterSelectElementList) {
            afterSelectElementList1.add(String.valueOf(list1.getText()));

        }

        Collections.sort(beforeSelectElementList1);
        // Collections.reverse(beforeSelectElementList1);

        Assert.assertEquals(beforeSelectElementList1,afterSelectElementList1);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        String expectedMessage = "Build your own computer";
        // Click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // Click on desktop tab
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        // Select Sort By position "Name: A to Z"
        selectDropDownElements(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");

        Thread.sleep(1000);
        // Click on "Add To Cart"
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        // Verify the Text "Build your own computer"
        compareElements(expectedMessage, actualMessage);
        Thread.sleep(1000);
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectDropDownElements(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        // .Select "8GB [+$60.00]" using Select class.
        selectDropDownElements(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        // Select HDD radio "400 GB [+$100.00]"
        selectRadioButton(By.xpath("//input[@id='product_attribute_3_7']"));
        // Select OS radio "Vista Premium [+$60.00]"
        selectRadioButton(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);
        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        selectCheckBox(By.xpath("//input[@id='product_attribute_5_10']"));
        selectCheckBox(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(1000);

        // Verify the price "$1,475.00"
        expectedMessage = "$1,475.00";
        actualMessage = getTextFromElement(By.xpath("//div[@class='product-price']//span"));
        compareElements(expectedMessage, actualMessage);
        // Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(1000);
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        expectedMessage = "The product has been added to your shopping cart";
        actualMessage = getTextFromElement(By.xpath("//div[@id='bar-notification']"));
        compareElements(expectedMessage, actualMessage);
        //
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(1000);

        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        mouseHoverAndClickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        // Verify the message "Shopping cart"
        expectedMessage = "Shopping cart";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        compareElements(expectedMessage, actualMessage);
        // Change the Qty to "2" and Click on "Update shopping cart"
        sendTextToElement(By.xpath("//input[contains(@id,'itemquantity')]"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        // Verify the Total"$2,950.00"
        expectedMessage = "$2,950.00";
        actualMessage = getTextFromElement(By.xpath("//span[@class='value-summary']//strong"));
        compareElements(expectedMessage, actualMessage);
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // Verify the Text “Welcome, Please Sign In!”
        expectedMessage = "Welcome, Please Sign In!";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        compareElements(expectedMessage, actualMessage);
        // Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        // Fill all registration details
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "primetesting@gmail.com");
        selectDropDownElements(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Mehsana");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Tintodan");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "382865");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9898989898");
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);
        // Click on Radio Button “Next Day Air($0.00)”
        selectRadioButton(By.xpath("//input[@id='shippingoption_1']"));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // Select Radio Button “Credit Card”
        selectRadioButton(By.xpath("//input[@id='paymentmethod_1']"));
        // Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);
        // Fill all the details
        selectDropDownElements(By.xpath("//select[@id='CreditCardType']"), "Master card");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Prime testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5573615091331588");
        selectDropDownElements(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectDropDownElements(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(1000);
        // Verify “Payment Method” is “Credit Card”
        expectedMessage = "Credit Card";
        actualMessage = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        compareElements(expectedMessage, expectedMessage);

        // Verify “Shipping Method” is “Next Day Air”
        expectedMessage = "Next Day Air";
        actualMessage = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        compareElements(expectedMessage, expectedMessage);

        // Verify Total is “$2,950.00”
        expectedMessage = "$2,950.00";
        actualMessage = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        compareElements(expectedMessage, expectedMessage);
        // Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        // Verify the Text “Thank You”
        expectedMessage = "Thank you";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        compareElements(expectedMessage, actualMessage);

        // Verify the message “Your order has been successfully processed!”
        expectedMessage = "Your order has been successfully processed!";
        actualMessage = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        compareElements(expectedMessage, actualMessage);
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // Verify the text “Welcome to our store”
        expectedMessage = "Welcome to our store";
        actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        compareElements(expectedMessage, actualMessage);


    }

}
