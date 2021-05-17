package com.anna.trello.framework;

import com.anna.trello.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBoardCreationForm(Board board) {
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), board.withBoardName());

        selectBoardVisibility(board.withVisibility());
    }

    public void selectBoardVisibility(String visibility) {
        click(By.xpath("//*[@aria-label='DownIcon']/../.."));
        click(By.xpath("//*[@aria-label='" +visibility+ "']/../.."));
    }

    public void initBoardCreationFromHeader() {
        // wd.findElement(By.xpath("//div[@class='TMI28E0KnYSK9p'][1]")).click();
        wd.findElement(By.xpath("//button[@data-test-id='header-create-menu-button']")).click();
        wd.findElement(By.xpath("//button[@data-test-id='header-create-board-button']")).click();
    }

    public void submitBoardCreationForm() {
        click(By.cssSelector("._21upOlzpUQJcdT.gkv95EhjCrfcEU"));
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void initBoardCreationFromBoardsdList() {
        click(By.xpath("//*[@data-test-id='create-board-tile']"));
    }
}
