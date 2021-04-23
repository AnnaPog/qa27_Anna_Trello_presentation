package com.anna.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    //_______________________________________________________

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

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void clickLoginButton() {
        wd.findElement(By.cssSelector("[href='/login']")).click();
    }

}
