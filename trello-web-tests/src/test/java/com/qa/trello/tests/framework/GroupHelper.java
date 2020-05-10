package com.qa.trello.tests.framework;

import com.qa.trello.tests.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {
    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void fillGroupForm(GroupData groupData) {
        typeGroupName(groupData.getName());
        click(By.cssSelector(".css-3gw83x"));
        typeOfGroup(groupData.getType());
        descriptions(groupData.getDescriptions());

        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));


    }

    private void descriptions(String text) {
        text = "Generate random String of given size in Java" +
                "Given a size as n, The task is to generate a random alphanumeric String of this size.";
        waitForElementAndType(By.cssSelector("._15aIJYNKhrO4vB"), text);
    }

    private void typeOfGroup(String type) {
        click(By.xpath("//div[@id='react-select-2-option-3']//li[@class='_38pq5NbRWAG39y']"));
    }

    private void typeGroupName(String text) {
        int random = (int) (Math.random() * 50 + 1);
        waitForElementAndType(By
                .cssSelector("[data-test-id='header-create-team-name-input']"), "New QA group " + random);
    }

    public void inviteGroupLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }

    public void initGroupCreation() {
        waitForElementAndClick(By.cssSelector("[name='add']"));
        waitForElementAndClick(By.
                xpath("//li[2]//button[1]//p[1]"));
    }


    public void openSettings() {
        click(By.xpath("//li[@class='pgEbaAFZBA0N5R']//li[4]//a[1]//span[2]"));
    }

    public void openFirstGroup() {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));

    }

    public void changeProfileOfGroup() {
        click(By.xpath("//span[@class='css-j8fq0c']"));
    }


    public void reNameGroup() {
        int random = (int) (Math.random() * 100 + 1);
        wd.findElement(By.xpath("//input[@id='displayName']")).click();
        wd.findElement(By.xpath("//input[@id='displayName']")).clear();
        type(By.xpath("//input[@id='displayName']"), "Changed name " + random);
        type(By.xpath("//textarea[@id='desc']"), "New Description for changed field from home " + random);
        click(By.cssSelector("[type='submit']"));

    }

    public void deleteGroup() {
        wd.findElement(By.cssSelector(".quiet-button")).click();
        wd.findElement(By.cssSelector(".js-confirm")).click();

    }

    public void returnToBoardsPageUrl(String username) {
        wd.navigate().to("https://trello.com/" + username + "/boards");
    }
}
