package com.morningstar.Pages;

import com.morningstar.Framework.Page;
import com.morningstar.Framework.PageElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sanit Thale on 3/21/2016 12:39 PM.
 */
public class GoogleHomePage extends Page {

    WebDriver driver;
    private static Logger log = Logger.getLogger(GoogleHomePage.class.getName());


    public GoogleHomePage(WebDriver driver) {
        super(driver, GoogleHomePage.class.getSimpleName(),log);
        this.driver = driver;
    }

    public void waitForPageToLoad(WebDriver driver) {
        //TODO: Wait For The Element
       // this.scenario = scenario;
    }

    public static GoogleHomePage getInstance(WebDriver driver) {
        GoogleHomePage googleHomePage = PageFactory.initElements(driver, GoogleHomePage.class);
        googleHomePage.waitForPageToLoad(driver);
        return googleHomePage;
    }

    /*************
     * Page Elements
     ****************/

    private PageElement searchTextBox() {
        return new PageElement(By.xpath("//input[@title='Search']"), "Search Text Box");
    }


    /*************
     * Services
     *********************/
    public void search() {
        clearAndSendKeys(searchTextBox(), "Selenium HQ");
        /*log.info("google search completed");
        scenario.write("google search completed");*/
    }
}
