package com.anna.trello.tests;

import com.anna.trello.model.Board;
import com.anna.trello.model.User;
import com.anna.trello.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BoardCreationsTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> boards() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new Board()
                    .setBoardName(split[0])
                    .setVisibility(split[0])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @BeforeMethod
    public void preconditions() {
        if(!app.getUser().isAvatarPresent()){
            app.getUser().clickLoginButton();
            app.getUser().fillLoginForm(new User().setEmail("aniapog@mail.ru")
            .setPassword("TrelloAnnaPo"));
            //fillLoginForm(new User("aniapog@mail.ru", "TrelloAnnaPo"));
            app.getUser().confirmLogin();
        }

        if(!app.getHeader().buttonPlusPresent()){
            app.getHeader().goHome();
        }

    }

    @Test
    public void testBoardCreation() {
        app.getBoard().initBoardCreationFromBoardsdList();
        app.getBoard().fillBoardCreationForm(new Board().setBoardName("board" + System.currentTimeMillis()).setVisibility( "PublicIcon"));
        //app.getBoard().selectBoardVisibility("DownIcon");
        // wd.findElement(By.xpath("//*[@class = 'voB8NatlbuEme5 _21upOlzpUQJcdT gkv95EhjCrfcEU']")).click();

        if(app.getBoard().popUpConfirmPublic()){
            app.getBoard().confirmPublic();
        }
        app.getBoard().submitBoardCreationForm();
    }

    @Test(dataProvider =  "boards")
    public void testBoardCreationDataProvider(Board board) {
        app.getBoard().initBoardCreationFromBoardsdList();
        app.getBoard().fillBoardCreationForm(board);

        app.getBoard().submitBoardCreationForm();
    }



//    @Test
//    public void testBoardCreation1() {
//        app.initBoardCreationFromHeader();
//        app.click(By.xpath("//input[@data-test-id='create-board-title-input']"));
//        app.wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).clear();
//        app.wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).sendKeys("newBoard");
//
//        app.click(By.xpath("//button[@class='_1Lkx3EjS3wCrs7 voB8NatlbuEme5 _3JfnLi33JtGtIk']"));
//        app.click(By.xpath("//*[@aria-label='PublicIcon']"));
//        app.click(By.xpath("//button[@class='voB8NatlbuEme5 _21upOlzpUQJcdT gkv95EhjCrfcEU']"));
//        app.click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
//
//
//    }
}

