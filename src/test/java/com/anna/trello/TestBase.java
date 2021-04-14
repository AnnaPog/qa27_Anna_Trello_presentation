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

    public void fillLoginForm() {
        wd.findElement(By.cssSelector("#user")).click();
        wd.findElement(By.cssSelector("#user")).clear();
        wd.findElement(By.cssSelector("#user")).sendKeys("aniapog@mail.ru");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wd.findElement(By.cssSelector("#login")).click();

        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("TrelloAnnaPo");

    }

    public void clickLoginButton() {
        wd.findElement(By.cssSelector("[href='/login']")).click();
    }

}