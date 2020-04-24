package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardCreationTests extends TestBase {


    @Test
    public void testBoardCreation() throws InterruptedException {
        int before = getBoardsCount();
        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        returnHomePage();
        int after = getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);
        //assertEquals(before+1, after);


    }
}
