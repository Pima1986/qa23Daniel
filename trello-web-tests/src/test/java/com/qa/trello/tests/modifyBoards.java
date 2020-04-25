package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class modifyBoards extends TestBase {


    @Test
    public void modifyTests() {
        openRandomPersonalBoard();
        initAddList();
        fillNameOfList();
        addCard();
        //editCardIt();
        createByTemplate();
        typeTemplates();
        //returnHomePage();


    }

    /* public void editCardIt() {
        click(By.cssSelector("[class='icon-sm icon-template-card dark-background-hover']"));

    }*/


}
