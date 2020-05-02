package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

public class GroupModificationsTests extends TestBase {
    @Test
    public void TestGroupModifications() throws InterruptedException {
        Thread.sleep(5000);
        app.getGroup().openFirstGroup();
        app.getGroup().openSettings();
        app.getGroup().changeProfileOfGroup();
        app.getGroup().reNameGroup();
        app.getGroup().returnToBoardsPageUrl("danielpimshteyn");

    }
}
