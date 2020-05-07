package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreation() {
        waitForElementAndClick(By.cssSelector("[name='add']"));
        waitForElementAndClick(By.xpath("//div[@class='atlaskit-portal-container']//li[1]//button[1]"));

    }

    public void fillBoardForm() {
        int random = (int) (Math.random() * 100 + 1);
        new WebDriverWait(wd, 20).until(presenceOfElementLocated(By.
                cssSelector("[data-test-id='create-board-title-input']"))).
                sendKeys("New Board from Home " + random);
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        click(By.xpath("//li[1]/button[@class = '_2jR0BZMM5cBReR']"));


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
        // openMenu();
        WebElement moreButton = new WebDriverWait(wd, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-open-more")));
        if (!moreButton.isDisplayed()) {
            wd.findElement(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar")).click();
        }
        wd.findElement(By.cssSelector(".js-open-more")).click();

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
        waitForElementAndClick(By.cssSelector("[data-test-id='create-board-submit-button']"));
        //click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        returnHomePage();
    }

    public void createByTemplate() {
        waitForElementAndClick(By.cssSelector("[class='icon-sm icon-template-card dark-background-hover']"));
        //click(By.cssSelector("[class='icon-sm icon-template-card dark-background-hover']"));
        waitForElementAndClick(By.cssSelector(".css-t5emrf"));


    }

    public void addCard() {
        waitForElementAndClick(By.cssSelector(".js-save-edit"));
        //click(By.cssSelector(".js-save-edit"));
    }

    public void fillNameOfList() throws InterruptedException {

        int random = (int) (Math.random() * 100 + 1);
        waitForElementAndType(By.cssSelector("[name='name']"),
                "New adding to list " + random);
        /*type(By.cssSelector("[name='name']"),
                "New adding to list " + random);*/
    }

    public void initAddList() {
        click(By.xpath("//a[@class='open-add-list js-open-add-list']"));

    }

    public void openRandomPersonalBoard() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementAndClick(By.
                xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void typeTemplates() {
        Random rand = new Random();
        new WebDriverWait(wd, 20).until(presenceOfElementLocated(By.cssSelector("._3730WlziYhHDQa"))).
                sendKeys("Templates " + rand);


    }

    public void addTemplate() {
        click(By.cssSelector(".css-j8fq0c"));
    }

    public void templateForCards() {
        new WebDriverWait(wd, 20).until(presenceOfElementLocated(By.cssSelector(".js-new-comment-input"))).
                sendKeys("Some special comment for this action");
        click(By.cssSelector(".js-add-comment"));
        click(By.cssSelector(".js-close-window"));
    }

    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }
}
