package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenLoginJira {

    WebDriver  wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.get("http://jira.tel-ran.net/");
    }

    @Test
    public void testLogin() throws InterruptedException {
wd.get("http://jira.tel-ran.net/");
click(By.name("aui-nav-link login-link"));
        click(By.id("login-form-username"));
        wd.findElement(By.name("os_username")).clear();
        wd.findElement(By.name("os_username")).sendKeys("Daniel");
       Thread.sleep(40000);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}
