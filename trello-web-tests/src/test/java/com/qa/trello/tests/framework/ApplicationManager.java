package com.qa.trello.tests.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    GroupHelper group;
    SessionHelper session;
    private WebDriverWait wait;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        session.login("daniel.pimshteyn@gmail.com", "Qwerty12345");

        board = new BoardHelper(wd);
        group = new GroupHelper(wd);

    }


    public void stop() throws InterruptedException {
        Thread.sleep(2000);
        wd.quit();
    }


    public BoardHelper getBoard() {
        return board;
    }

    public GroupHelper getGroup() {
        return group;
    }

    public SessionHelper getSession() {
        return session;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
