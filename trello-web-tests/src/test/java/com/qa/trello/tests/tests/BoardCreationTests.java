package com.qa.trello.tests.tests;

import com.qa.trello.tests.model.BoardData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(2000);
        if (app.getBoard().isOnBoardsPage()) {
            app.getBoard().click(By.cssSelector("[href$=boards"));
        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(3000);
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(new BoardData()
                .withName("New Board from Home "));
        app.getBoard().click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        app.getBoard().returnHomePage();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);
        assertEquals(before + 1, after);


    }
}
