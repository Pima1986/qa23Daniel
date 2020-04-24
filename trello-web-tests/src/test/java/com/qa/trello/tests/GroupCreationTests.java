package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        initGroupCreation();
        fillGroupForm();
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
        //click(By.name("house"));

    }


}
