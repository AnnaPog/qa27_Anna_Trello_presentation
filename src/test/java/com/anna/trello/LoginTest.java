package com.anna.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void testLoginAtlassian(){
        clickLoginButton();
        fillLoginForm(new User()
                .setEmail("aniapog@mail.ru")
                .setPassword("TrelloAnnaPo"));
        confirmLogin();

        Assert.assertTrue(wd.findElements(By.cssSelector("[data-test-id$='header-member-menu-button']")).size()>0);
        Assert.assertEquals(wd.findElement(By.cssSelector("[data-test-id$='header-member-menu-button']")).getAttribute("title"), "Anna (anna56118081)");
    }

    @Test
    public void negativeTestLoginWithoutPassword(){
        clickLoginButton();
        fillLoginForm(new User().setEmail("aniapog@mail.ru"));
        confirmLogin();

    }
}
