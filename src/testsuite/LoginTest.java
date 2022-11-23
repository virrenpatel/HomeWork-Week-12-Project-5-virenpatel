package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully () {
        // Find log in link and click on login link
        clickOnElement(By.linkText("Sign In"));

        // This is from requirement
        String expectedMessage= "Welcome Back!";

        // Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='page__heading']"));

        // Validate actual and expected message
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void verifyErrorMessageWithInvalidCredentials(){
        //Click on 'Login' link
        clickOnElement(By.linkText("Sign In"));

        //Enter Invalid user name
        sendTextToElement(By.id("user[email]"),"test1234@gmail.com");

        //Enter Invalid Password
        sendTextToElement(By.name("user[password]"),"Password123");

        //Click on login button
        clickOnElement(By.xpath("//input[@type='submit']"));

        getTextFromElement(By.xpath("//li[@class='form-error__list-item']"));

        // This is from requirement
        String expectedMessage= "Invalid email or password.";

        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//li[@class='form-error__list-item']"));

        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
