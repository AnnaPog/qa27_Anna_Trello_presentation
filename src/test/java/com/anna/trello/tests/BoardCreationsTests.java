package com.anna.trello.tests;

import com.anna.trello.model.Board;
import com.anna.trello.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationsTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getUser().clickLoginButton();
        //fillLoginForm(new User("aniapog@mail.ru", "TrelloAnnaPo"));
        app.getUser().confirmLogin();
    }

    @Test
    public void testBoardCreation() {
        app.getBoard().initBoardCreationFromBoardsdList();
        app.getBoard().fillBoardCreationForm(new Board("board" + TimeUnit.SECONDS, "PublicIcon"));
        app.getBoard().selectBoardVisibility("DownIcon");
        // wd.findElement(By.xpath("//*[@class = 'voB8NatlbuEme5 _21upOlzpUQJcdT gkv95EhjCrfcEU']")).click();
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

