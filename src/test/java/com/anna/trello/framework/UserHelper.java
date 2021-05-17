package com.anna.trello.framework;

import com.anna.trello.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmLogin() {
        wd.findElement(By.cssSelector("#login-submit")).click();
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#user"), user.getEmail());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        click(By.cssSelector("#login"));

        type(By.cssSelector("#password"), user.getPassword());

    }

    public void clickLoginButton() {
        wd.findElement(By.cssSelector("[href='/login']")).click();
    }

    public boolean isAvatarPresent() {
        return isElementPresent(By.cssSelector("[data-test-id$='header-member-menu-button']"));
    }

    public void logout() {
        click(By.xpath("/button[@data-test-id='header-member-menu-button']"));
        click(By.xpath("//div[@class='_1ArtKJZLTN_ljN px-0 pt-0']//li[8]"));
        click(By.xpath("//span[@class='css-t5emrf']"));
        //click on avatar
        //click logout
        //confirm logout
    }
}
