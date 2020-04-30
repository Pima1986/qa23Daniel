package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class modifyBoards extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (isOnBoardsPage()) {
            click(By.cssSelector("[href$=boards"));
        }
        if (getBoardsCount() == 0) {
            createBoard();
        }
    }


    @Test
    public void modifyTests() throws InterruptedException {
        openRandomPersonalBoard();
        initAddList();
        fillNameOfList();
        addCard();
        createByTemplate();
        typeTemplates();
        addTemplate();
        tempalteForCards();
        returnHomePage();


    }


}
