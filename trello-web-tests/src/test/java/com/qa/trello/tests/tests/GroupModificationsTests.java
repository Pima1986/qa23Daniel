package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

public class GroupModificationsTests extends TestBase {
    @Test
    public void TestGroupModifications(){
        app.getGroup().openGroupSettings();
        app.getGroup().changeGroupName();
    }
}
