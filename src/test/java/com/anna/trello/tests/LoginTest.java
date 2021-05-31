package com.anna.trello.tests;

import com.anna.trello.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @BeforeMethod
    public void preconditions(){
        if(app.getUser().isAvatarPresent()){
            app.getUser().logout();
            app.goToURL("https://trello.com");
        }
    }

    @Test
    public void testLoginAtlassian() throws InterruptedException {
        logger.info("Start Test login Atlassian");
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User()
                .setEmail("aniapog@mail.ru")
                .setPassword("TrelloAnnaPo"));
        app.getUser().confirmLogin();

        Assert.assertTrue(app.getUser().isAvatarPresent(), "Avatar isn't present - user not logged in");
        //Assert.assertEquals(wd.findElement(By.cssSelector("[data-test-id$='header-member-menu-button']")).getAttribute("title"), "Anna (anna56118081)");
        logger.info("Stop Test login Atlassian");
    }

    @Test
    public void negativeTestLogin() throws InterruptedException {
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User().setEmail("rochman.elena@gmail.com").setPassword("12345.cOm"));
        app.getUser().confirmLogin();

    }

    @Test
    public void negativeTestLoginWithoutPassword(){
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User().setEmail("aniapog@mail.ru"));
        app.getUser().confirmLogin();

    }
}
