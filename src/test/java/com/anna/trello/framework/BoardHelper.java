package com.anna.trello.framework;

import com.anna.trello.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

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
        if(isElementPresent(By.xpath("//button[@class='_3TTqkG5muwOzqZ _3Ik0JLsERwh6Ui _3HfJ71CiQ9nm2y']"))){
            click(By.xpath("//button[@class='_3TTqkG5muwOzqZ _3Ik0JLsERwh6Ui _3HfJ71CiQ9nm2y']"));
        }
        //click(By.cssSelector("._21upOlzpUQJcdT.gkv95EhjCrfcEU"));
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void initBoardCreationFromBoardsdList() {
        click(By.xpath("//*[@data-test-id='create-board-tile']"));
    }

    public boolean isTheBoard() {
        return isElementPresent(By.cssSelector(".boards-page-board-section-list-item"));
    }

    public void createBoard() {
        initBoardCreationFromBoardsdList();
        fillBoardCreationForm(new Board().setBoardName("board" + TimeUnit.SECONDS).setVisibility("PublicIcon"));
        submitBoardCreationForm();
    }

    public void openFirstBoard() {
        click(By.cssSelector(".boards-page-board-section-list-item"));

    }

    public void openMenu() {
        if(!isElementPresent(By.cssSelector(".js-open-more"))){
            click(By.cssSelector(".icon-back"));
        }
    }

    public void openExtendedMenu() {
        click(By.cssSelector(".js-open-more"));
    }

    public void deleteBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));

    }

    public int getBoardsCount() {
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item")).size()-1;
    }

    public boolean popUpConfirmPublic() {
        return isElementPresent(By.xpath("//button[@class='_3TTqkG5muwOzqZ 3cQ5itsQUVGg7o 3HfJ71CiQ9nm2y']"));
       // By.cssSelector("._3cQ5itsQUVGg7o._3HfJ71CiQ9nm2y");
    }

    public void confirmPublic() {
        click(By.xpath("//button[@class='_3TTqkG5muwOzqZ 3cQ5itsQUVGg7o 3HfJ71CiQ9nm2y']"));
    }
}
