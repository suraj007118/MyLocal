package com.morningstar.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Sanit Thale on 3/15/2016.
 */
public class SeleniumHomePage {
    WebDriver driver;

    public SeleniumHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToLoad(WebDriver driver) {
        //this.scenario = scenario;
    }

    public static SeleniumHomePage getInstance(WebDriver driver) {
        SeleniumHomePage seleniumHomePage = PageFactory.initElements(driver, SeleniumHomePage.class);
        seleniumHomePage.waitForPageToLoad(driver);
        return seleniumHomePage;
    }

    public void downloadSelenium() {
        driver.findElement(By.xpath("//a[@title='Get Selenium']")).click();
        //scenario.write("download selenium completed");
    }


}
