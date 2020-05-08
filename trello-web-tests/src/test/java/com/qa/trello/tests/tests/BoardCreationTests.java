package com.qa.trello.tests.tests;

import com.qa.trello.tests.model.BoardData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(2000);
        if (app.getBoard().isOnBoardsPage()) {
            app.getBoard().click(By.cssSelector("[href$=boards"));
        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }

    /*@DataProvider
    public Iterator<Object[]> validBoards() throws IOException, IOException {
        List<Object> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/boards.csv")));
        String line = reader.readLine();

        while (line != null) {
            line = line.readLine();
            String[] split = line.split(";");
            list.add(new Object[]{new BoardData().withName(split[0]).withName(split[1])});
            reader.readLine();
        }

        return list.iterator();
    }*/

    //Simple data provider
    @DataProvider
    Iterator<Object[]> validBoardEasy() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"hhhhh"});
        list.add(new Object[]{"1111111"});
        list.add(new Object[]{"dfghjkl;trehwjklfdfoklmsd,cx"});
        return list.iterator();
    }

    @Test(dataProvider = "validBoardEasy")
    public void testBoardCreation(String boardName) throws InterruptedException {
        Thread.sleep(3000);
        BoardData board = new BoardData().withName(boardName);
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(board);
        app.getBoard().click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        app.getBoard().returnHomePage();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);
        assertEquals(before + 1, after);


    }


    @Test
    public void testBoardCreationOLD() throws InterruptedException {
        Thread.sleep(3000);
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(new BoardData()
                .withName("New Board from Home "));
        app.getBoard().click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        app.getBoard().returnHomePage();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + "  now: " + after);
        assertEquals(before + 1, after);


    }

}
