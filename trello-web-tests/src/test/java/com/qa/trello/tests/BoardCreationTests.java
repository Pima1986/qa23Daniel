package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {


    @Test
    public void testBoardCreation() {
        initBoardCreation();
        fillBoardForm();
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        click(By.name("house"));

    }
}
