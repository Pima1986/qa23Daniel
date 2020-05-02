package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws InterruptedException {

        app.getGroup().initGroupCreation();
        app.getGroup().fillGroupForm();
        app.getGroup().click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
        app.getGroup().inviteGroupLater();
        app.getGroup().returnHomePage();

    }


}
