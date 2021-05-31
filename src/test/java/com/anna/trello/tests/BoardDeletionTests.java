package com.anna.trello.tests;

import com.anna.trello.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!app.getUser().isAvatarPresent()){
            app.getUser().clickLoginButton();
            app.getUser().fillLoginForm(new User().setEmail("aniapog@mail.ru")
                    .setPassword("TrelloAnnaPo"));
            app.getUser().confirmLogin();
        }
        if(!app.getBoard().isTheBoard()){
            app.getBoard().createBoard();
        }
    }
    @Test
    public void testBoardDeletion(){
        int count = app.getBoard().getBoardsCount();
        while (count >1) {
            app.getBoard().openFirstBoard();
            app.getBoard().openMenu();
            app.getBoard().openExtendedMenu();
            app.getBoard().deleteBoard();
            app.getHeader().goHome();
            count = app.getBoard().getBoardsCount();
        }
    }
}
