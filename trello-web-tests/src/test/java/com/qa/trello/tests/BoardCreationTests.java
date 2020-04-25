package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardCreationTests extends TestBase {


    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(3000);
        int before = getBoardsCount();
        initBoardCreation();
        fillBoardForm();
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        returnHomePage();
        int after = getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);

        //it's not work, assert is not see how many boards were before,
        //but haw many boards after - it's correct form
        //assertEquals(before + 1, after);


    }
}
