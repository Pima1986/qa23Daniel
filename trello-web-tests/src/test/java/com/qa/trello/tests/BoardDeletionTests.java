package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @Test
    public void TestDeletion(){
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletionInMeu();
        confirmCloseBoard();
        permanentlyDeleteBoard();
        confirmDeleteBoard();
        returnHomePage();
    }

    public void returnHomePage() {
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
        click(By.xpath("//*[@class='boards-page-board-section-list']/../..//li"));

    }
}
