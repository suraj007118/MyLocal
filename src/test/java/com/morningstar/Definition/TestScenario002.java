package com.morningstar.Definition;

import com.morningstar.Framework.WebDriverService;
import com.morningstar.Pages.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by NBhavas on 4/29/2016.
 */
public class TestScenario002 {
    WebDriver driver;
    GoogleHomePage googleHomePage;

    public WebDriver getWebDriverInstance(String browser) {
        try {
            this.driver = new WebDriverService().getWebDriverInstance(browser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.driver;
    }

    @BeforeTest
    public void Setup() {
        getWebDriverInstance("Firefox");
        driver.get("https://www.google.co.in");
        driver.manage().window().maximize();
        googleHomePage = new GoogleHomePage (this.driver);
        googleHomePage = new GoogleHomePage (driver);
    }

    @AfterTest
    public void end() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void testing() {
        googleHomePage.search();
        try {
            Thread.sleep(500);
        }  catch (InterruptedException e) {
        }

    }
    //@Test
  //  public void testing002() {
     //   googleHomePage.test();
   // }
}
