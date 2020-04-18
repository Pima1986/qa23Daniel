package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BoardCreationTests {
    WebDriver wd;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");


    }

    @Test
    public void testBoardCreation() {


        //1. initLogin
        initLogin();

        //2. fillLoginFormAtlassian
        fillLoginFormAtlassian("daniel.pimshteyn@gmail.com", "Qwerty12345");

        //3. confirmLogin
        confirmLogin();

        //4. initBoardCreation
        initBoardCreation();

        //5. fill board form
        fillBoardForm();

        //6. confirm board creation
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        //7. return to home page
        click(By.name("house"));

    }

    private void initBoardCreation() {
        click(By.cssSelector("[name='add']"));
        wait.until(presenceOfElementLocated(By.
                xpath("//div[@class='atlaskit-portal-container']//li[1]//button[1]"))).click();
    }

    private void fillBoardForm() {
        int random = (int)(Math.random() * 50 + 1);
        wait.until(presenceOfElementLocated(By.
                cssSelector("[data-test-id='create-board-title-input']"))).
                sendKeys("New Board from Home"+random);
    }

    private void confirmLogin() {
        //wait.until(presenceOfElementLocated(By.id("login-submit"))).click();
        click(By.id("login-submit"));
    }

    private void fillLoginFormAtlassian(String userEmail, String password) {
        type(By.name("user"), userEmail);
        click(By.cssSelector("[value='Log in with Atlassian']"));
        type(By.id("password"), password);
    }

    private void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

   /* @AfterMethod
    public void tearDown() {
        wd.quit();
    }*/


}
