package com.qa.trello.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    protected  ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        app.init();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        app.stop();
    }


}
