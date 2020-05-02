package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HelperBase {
    WebDriver wd;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waitForElementAndClick(By locator){
        new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }
    public void click(By locator) {
        new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        //no need line 30, can be deleted
        /*wd.findElement(locator).click();*/

    }

    public void returnHomePage() throws InterruptedException {
        click(By.name("house"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void waitForElementAndType(By locator, String text ){
        new WebDriverWait(wd,20).until(presenceOfElementLocated(locator)).
                sendKeys(text);

    }
}
