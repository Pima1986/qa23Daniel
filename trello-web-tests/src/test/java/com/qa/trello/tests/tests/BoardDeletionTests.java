package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardDeletionTests extends TestBase {

  /*  @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
       Thread.sleep(2000);
        if (app.getBoard().isOnBoardsPage()) {
            app.getBoard().click(By.cssSelector("[href$=boards"));
        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }*/

    @Test
    public void TestDeletion() throws InterruptedException {
        Thread.sleep(2000);
       /* int before = app.getBoardsCount();*/
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletionInMeu();
        app.getBoard().confirmCloseBoard();
        app.getBoard().permanentlyDeleteBoard();
        app.getBoard().confirmDeleteBoard();
        app.getBoard().returnHomePage();
       /* int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);
        assertEquals(after, before - 1);*/
    }


}
