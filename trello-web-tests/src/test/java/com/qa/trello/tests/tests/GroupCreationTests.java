package com.qa.trello.tests.tests;

import com.qa.trello.tests.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File(
                        "src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData()
                    .withName(split[0])
                    .withType(split[1])
                    .withDescriptions(split[2])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData groupData) throws InterruptedException {
        Thread.sleep(2000);
        app.getGroup().initGroupCreation();
        app.getGroup().fillGroupForm(groupData);
        app.getGroup().click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
        app.getGroup().inviteGroupLater();
        app.getGroup().returnHomePage();

    }


}
