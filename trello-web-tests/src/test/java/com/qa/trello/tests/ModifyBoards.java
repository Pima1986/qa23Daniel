package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModifyBoards extends TestBase {
 /*   @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.isOnBoardsPage()) {
            app.click(By.cssSelector("[href$=boards]"));
        }
        if (app.getBoardsCount() == 0) {
            app.createBoard();
        }
    }*/


    @Test
    public void ModifyTests() throws InterruptedException {
        Thread.sleep(2000);
        app.openRandomPersonalBoard();
        app.initAddList();
        app.fillNameOfList();
        app.addCard();
        app.createByTemplate();
        app.typeTemplates();
        app.addTemplate();
        app.tempalteForCards();
        app.returnHomePage();


    }


}
