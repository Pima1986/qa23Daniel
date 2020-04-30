package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.initGroupCreation();
        app.fillGroupForm();
        app.click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
        app.inviteGroupLater();
        //click(By.name("house"));

    }




}
