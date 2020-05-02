package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletion extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(5000);
        if (app.getBoard().isOnBoardsPage()) {
            app.getBoard().click(By.cssSelector("[href$=boards"));
        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void groupDeletion() throws InterruptedException {
        Thread.sleep(5000);
        app.getGroup().openFirstGroup();
        app.getGroup().openSettings();
        app.getGroup().deleteGroup();
        app.getGroup().returnHomePage();
    }
}
