package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestBase {

    WebDriver wd;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws InterruptedException {
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

    public void fillLoginFormAtlassian(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        click(By.cssSelector("[value='Log in with Atlassian']"));
        Thread.sleep(5000);
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
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        wd.quit();
    }

    public void initBoardCreation() {
        click(By.cssSelector("[name='add']"));
        wait.until(presenceOfElementLocated(By.
                xpath("//div[@class='atlaskit-portal-container']//li[1]//button[1]"))).click();
    }

    public void fillBoardForm() {
        int random = (int) (Math.random() * 100 + 1);
        wait.until(presenceOfElementLocated(By.
                cssSelector("[data-test-id='create-board-title-input']"))).
                sendKeys("New Board from Home" + random);
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        click(By.xpath("//li[1]/button[@class = '_2jR0BZMM5cBReR']"));


    }

    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLoginFormAtlassian(email, password);
        confirmLogin();
    }

    public void returnHomePage() throws InterruptedException {
        Thread.sleep(10000);
        click(By.name("house"));
    }

    public void confirmDeleteBoard() {
        click(By.cssSelector(".js-confirm"));
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm"));
    }

    public void initBoardDeletionInMeu() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {
        click(By.cssSelector(".js-open-more"));

    }

    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));

    }

    public int getBoardsCount() {
        return wd.findElements(By.
                xpath("//*[@class='boards-page-board-section-list']/../..//li")).size() - 1;
    }

    public void createBoard() throws InterruptedException {
        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        returnHomePage();
    }


    public void createByTemplate() {
        click(By.cssSelector("[class='icon-sm icon-template-card dark-background-hover']"));
        wait.until(presenceOfElementLocated(By.cssSelector(".css-t5emrf"))).click();


    }

    protected void addCard() {
        click(By.cssSelector(".js-save-edit"));
    }

    public void fillNameOfList() throws InterruptedException {
        Thread.sleep(2000);
        int random = (int) (Math.random() * 100 + 1);
        type(By.cssSelector("[name='name']"),
                "New adding to list " + random);
    }

    public void initAddList() {
        click(By.xpath("//a[@class='open-add-list js-open-add-list']"));

    }

    public void openRandomPersonalBoard() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void typeTemplates() {
        Random rand = new Random();
        wait.until(presenceOfElementLocated(By.cssSelector("._3730WlziYhHDQa"))).
                sendKeys("Tempaltes " + rand);



    }

    public void addTemplate() {
        click(By.cssSelector(".css-j8fq0c"));
    }

    public void tempalteForCards() {
        wait.until(presenceOfElementLocated(By.cssSelector(".js-new-comment-input"))).
                sendKeys("Some special comment for this action");
        click(By.cssSelector(".js-add-comment"));
        click(By.cssSelector(".js-close-window"));
    }
}
