package com.anna.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationsTests extends TestBase{

    @BeforeMethod
    public void preconditions(){
        clickLoginButton();
        fillLoginForm();
        confirmLogin();
    }

    @Test
    public void testBoardCreation(){
        initBoardCreationFromFordList();
        wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).click();
        wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).clear();
        wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).sendKeys("board");

        wd.findElement(By.xpath("//*[@aria-label='DownIcon']/../..")).click();
        wd.findElement(By.xpath("//*[@aria-label='PublicIcon']/../..")).click();
       // wd.findElement(By.xpath("//*[@class = 'voB8NatlbuEme5 _21upOlzpUQJcdT gkv95EhjCrfcEU']")).click();
        wd.findElement(By.cssSelector("._21upOlzpUQJcdT.gkv95EhjCrfcEU")).click();
        wd.findElement(By.cssSelector("[data-test-id='create-board-submit-button']")).click();
    }

    @Test
    public void testBoardCreation1(){
        initBoardCreationFromHeader();
        wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).click();
        wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).clear();
        wd.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).sendKeys("newBoard");

        wd.findElement(By.xpath("//button[@class='_1Lkx3EjS3wCrs7 voB8NatlbuEme5 _3JfnLi33JtGtIk']")).click();
        wd.findElement(By.xpath("//*[@aria-label='PublicIcon']")).click();
        wd.findElement(By.xpath("//button[@class='voB8NatlbuEme5 _21upOlzpUQJcdT gkv95EhjCrfcEU']")).click();
        wd.findElement(By.xpath("//button[@data-test-id='create-board-submit-button']")).click();



    }

    private void initBoardCreationFromHeader() {
       // wd.findElement(By.xpath("//div[@class='TMI28E0KnYSK9p'][1]")).click();
        wd.findElement(By.xpath("//button[@data-test-id='header-create-menu-button']")).click();
        wd.findElement(By.xpath("//button[@data-test-id='header-create-board-button']")).click();


    }

    public void initBoardCreationFromFordList() {
        wd.findElement(By.xpath("//*[@data-test-id='create-board-tile']")).click();
    }
}
