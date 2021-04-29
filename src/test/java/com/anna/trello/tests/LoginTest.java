package com.anna.trello.tests;

import com.anna.trello.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLoginAtlassian(){
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User()
                .setEmail("aniapog@mail.ru")
                .setPassword("TrelloAnnaPo"));
        app.getUser().confirmLogin();

        Assert.assertTrue(app.getUser().isAvatarPresent());
        //Assert.assertEquals(wd.findElement(By.cssSelector("[data-test-id$='header-member-menu-button']")).getAttribute("title"), "Anna (anna56118081)");
    }

    @Test
    public void negativeTestLoginWithoutPassword(){
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User().setEmail("aniapog@mail.ru"));
        app.getUser().confirmLogin();

    }
}
