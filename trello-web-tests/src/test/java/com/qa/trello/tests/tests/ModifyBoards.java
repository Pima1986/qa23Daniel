package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModifyBoards extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.getBoard().isOnBoardsPage()) {
            app.getBoard().click(By.cssSelector("[href$=boards]"));
        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }


    @Test
    public void ModifyTests() throws InterruptedException {
        Thread.sleep(2000);
        app.getBoard().openRandomPersonalBoard();
        app.getBoard().initAddList();
        app.getBoard().fillNameOfList();
        app.getBoard().addCard();
        app.getBoard().createByTemplate();
        app.getBoard().typeTemplates();
        app.getBoard().addTemplate();
        app.getBoard().templateForCards();
        app.getBoard().returnHomePage();


    }


}
