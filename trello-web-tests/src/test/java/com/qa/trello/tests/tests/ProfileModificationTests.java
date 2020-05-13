package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {


    @Test
    public void testChangeProfile() throws InterruptedException {
        app.getProfile().takeScreenshot();
        app.getProfile().clickOnAvatar();
        app.getProfile().selectProfileAndVisibiliy();
        app.getProfile().goToAtlassianProfile();
        app.getProfile().initChangeProfilePhoto();
        app.getProfile().upLoadPhoto();
        app.getProfile().takeScreenshot();
    }


}
