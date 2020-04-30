package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardDeletionTests extends TestBase {

/*    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
       Thread.sleep(2000);
        if (app.isOnBoardsPage()) {
            app.click(By.cssSelector("[href$=boards"));
        }
        if (app.getBoardsCount() == 0) {
            app.createBoard();
        }
    }*/

    @Test
    public void TestDeletion() throws InterruptedException {
        Thread.sleep(2000);
       /* int before = app.getBoardsCount();*/
        app.openFirstPersonalBoard();
        app.clickMoreButton();
        app.initBoardDeletionInMeu();
        app.confirmCloseBoard();
        app.permanentlyDeleteBoard();
        app.confirmDeleteBoard();
        app.returnHomePage();
       /* int after = app.getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);
        assertEquals(after, before - 1);*/
    }


}
