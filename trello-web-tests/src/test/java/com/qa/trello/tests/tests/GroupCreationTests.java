package com.qa.trello.tests.tests;

import com.qa.trello.tests.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation(){
        app.getGroup().initGroupCreation();
        app.getGroup().fillGroupForm(new GroupData()
                .withName("New QA group ")
                .withType("//div[@id='react-select-2-option-3']//li[@class='_38pq5NbRWAG39y']")
                .withDescriptions("Generate random String of given size in Java" +
                        "Given a size as n, The task is to generate a random alphanumeric String of this size."));
        app.getGroup().click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
        app.getGroup().inviteGroupLater();
        app.getGroup().returnHomePage();

    }


}
