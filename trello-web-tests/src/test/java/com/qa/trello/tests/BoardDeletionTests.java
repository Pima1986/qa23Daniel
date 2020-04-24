package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (getBoardsCount() == 0) {
            createBoard();
        }
    }

    @Test
    public void TestDeletion() {
        int before = getBoardsCount();
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletionInMeu();
        confirmCloseBoard();
        permanentlyDeleteBoard();
        confirmDeleteBoard();
        returnHomePage();
        int after = getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);
        assertEquals(after, before-1);
    }


}
