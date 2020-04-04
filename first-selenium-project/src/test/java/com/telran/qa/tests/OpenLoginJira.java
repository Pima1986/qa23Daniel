package com.telran.qa.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenLoginJira {

    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // wd.get("http://jira.tel-ran.net/");
        wd.navigate().to("http://jira.tel-ran.net/secure/Dashboard.jspa");
    }

    @Test
    public void testLogin() throws InterruptedException {
        type(By.name("os_username"), "Daniel");
        type(By.name("os_password"), "chjfhhjkjb");

        //type2(By.name("os_password"), "chjfhhjkjb");

        click(By.id("login"));

        Thread.sleep(40000);
        
        Assert.assertTrue(isElementPresent(By.id("usernameerror")));
        String errorMessage = wd.findElement(By.id("usernameerror")).getText();

        Assert.assertEquals(errorMessage, "Sorry, your username and password are incorrect - please try again.");
    }

//    private void type2(By locator, String text) {
//        click(locator);
//        wd.findElement(locator).clear();
//        wd.findElement(locator).sendKeys(text);
//    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }


    private void click(By locator) {
        wd.findElement(locator).click();
    }


    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    @AfterClass
    public void tearDown() {
        // wd.quit();
    }
}
