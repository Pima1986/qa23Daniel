package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class modifyBoards extends TestBase {


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
