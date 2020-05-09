package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase {
    public ProfileHelper(WebDriver wd) {
        super(wd);
    }


    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void selectProfileAndVisibiliy() {
        waitForElementAndClick(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianProfile() {
        String trello = wd.getWindowHandle();
        System.out.println(trello);
        click(By.cssSelector("a[href$='manage-profile']"));

        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
//no selenium on Atlassian page
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);

    }

    public void initChangeProfilePhoto() {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"));
        //prosto navodim na element, no ne klikaem
        new Actions(wd).moveToElement(avatar).perform();
        click(By.cssSelector("[data-test-selector='trigger-avatar-picker']"));
    }

    public void upLoadPhoto() throws InterruptedException {
        attachFile(By.cssSelector("button [id='image-input']"),
                new File("C:\\Users\\Daniel\\Documents\\GitHub\\qa23Daniel\\trello-web-tests\\src\\test\\resources\\NY2019.png"));
        Thread.sleep(2000);
        click(By.xpath("//*[contains(text(), 'Загрузить')]"));

        returnHomePage();
    }

    public void attachFile(By locator, File file) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
}
