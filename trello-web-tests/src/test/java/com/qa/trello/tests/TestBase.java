package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestBase {

    WebDriver wd;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        login("daniel.pimshteyn@gmail.com", "Qwerty12345");


    }

    public void initGroupCreation() {
        click(By.cssSelector("[name='add']"));
        wait.until(presenceOfElementLocated(By.
                xpath("//li[2]//button[1]//p[1]"))).click();
    }

    public void fillGroupForm() {
        int random = (int) (Math.random() * 50 + 1);
        wait.until(presenceOfElementLocated(By.
                cssSelector("[data-test-id='header-create-team-name-input']"))).
                sendKeys("New QA group" + random);
        click(By.cssSelector(".css-3gw83x"));
        click(By.xpath("//div[@id='react-select-2-option-3']//li[@class='_38pq5NbRWAG39y']"));
        wait.until(presenceOfElementLocated(By.cssSelector("._15aIJYNKhrO4vB"))).
                sendKeys("Generate random String of given size in Java" +
                "Given a size as n, The task is to generate a random alphanumeric String of this size.");
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));


    }

    public void confirmLogin() {
        //wait.until(presenceOfElementLocated(By.id("login-submit"))).click();
        click(By.id("login-submit"));
    }

    public void fillLoginFormAtlassian(String userEmail, String password) {
        type(By.name("user"), userEmail);
        click(By.cssSelector("[value='Log in with Atlassian']"));
        type(By.id("password"), password);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void initBoardCreation() {
        click(By.cssSelector("[name='add']"));
        wait.until(presenceOfElementLocated(By.
                xpath("//div[@class='atlaskit-portal-container']//li[1]//button[1]"))).click();
    }

    public void fillBoardForm() {
        int random = (int) (Math.random() * 50 + 1);
        wait.until(presenceOfElementLocated(By.
                cssSelector("[data-test-id='create-board-title-input']"))).
                sendKeys("New Board from Home" + random);
    }

    public void login(String email, String password) {
        initLogin();
        fillLoginFormAtlassian(email, password);
        confirmLogin();
    }
}
