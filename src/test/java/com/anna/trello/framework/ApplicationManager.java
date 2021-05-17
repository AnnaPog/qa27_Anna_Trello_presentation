package com.anna.trello.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;
    BoardHelper board;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {


        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }



        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        user = new UserHelper(wd);
        board = new BoardHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public String getCurrentURL() {
        return wd.getCurrentUrl();
    }

    public void goToURL(String url) {
        wd.get(url);
    }
}
