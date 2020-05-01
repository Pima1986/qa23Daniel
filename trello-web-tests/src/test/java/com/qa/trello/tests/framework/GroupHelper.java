package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {
    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void fillGroupForm() {
        int random = (int) (Math.random() * 50 + 1);
        waitForElementAndType(By
                .cssSelector("[data-test-id='header-create-team-name-input']"), "New QA group" + random);

        click(By.cssSelector(".css-3gw83x"));
        click(By.xpath("//div[@id='react-select-2-option-3']//li[@class='_38pq5NbRWAG39y']"));
        waitForElementAndType(By.cssSelector("._15aIJYNKhrO4vB"), "Generate random String of given size in Java" +
                "Given a size as n, The task is to generate a random alphanumeric String of this size." );

        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));


    }

    public void inviteGroupLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }
    public void initGroupCreation() {
        click(By.cssSelector("[name='add']"));
        waitForElementAndClick(By.
                xpath("//li[2]//button[1]//p[1]"));
    }

    public void openGroupSettings() {
        openFirstGroup();
        openSettings();
    }

    public void openSettings() {
    }

    public void openFirstGroup() {
    }

    public void changeGroupName() {
    }
}
