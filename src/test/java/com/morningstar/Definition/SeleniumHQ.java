package com.morningstar.Definition;/*
package com.morningstar.Definition;

import com.morningstar.Exceptions.UnsucessfulServiceException;
import com.morningstar.Framework.WebDriverService;
import com.morningstar.Pages.GoogleHomePage;
import com.morningstar.Pages.SeleniumHomePage;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

*/
/**
 * Created by Sanit Thale on 3/15/2016.
 *//*

public class SeleniumHQ {
    WebDriver driver;
    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void end() {
        if (driver != null)
            driver.quit();
        */
/*System.out.println("Scenario Name :"+scenario.getName());
        System.out.println("Scenario Status :"+scenario.getStatus());*//*

    }

    @Given("^Launch Selenium HQ$")
    public void launch_Selenium_HQ() throws Throwable {
        driver = new WebDriverService().getWebDriverInstance();
        driver.get("http://www.seleniumhq.org");
    }


    @Given("^Launch Google Search$")
    public void launch_Google_Search() throws Throwable {
        driver = new WebDriverService().getWebDriverInstance();
        driver.get("http://www.google.com");
    }


    @Then("^Download Selenium Latest Version$")
    public void download_Selenium_Latest_Version() throws Throwable {
        SeleniumHomePage seleniumHomePage = SeleniumHomePage.getInstance(driver, scenario);
        seleniumHomePage.downloadSelenium();
    }


    @Then("^Search for Selenium$")
    public void search_for_Selenium() throws Throwable {
        GoogleHomePage.getInstance(driver, scenario).search();
    }

    @Then("^Verify Search is Working$")
    public void verify_Search_is_Working() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new UnsucessfulServiceException();
    }
}
*/
