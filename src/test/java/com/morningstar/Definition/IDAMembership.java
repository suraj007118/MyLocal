package com.morningstar.Definition;

import com.morningstar.Framework.WebDriverService;
import com.morningstar.Pages.IDAHomePage;
import com.morningstar.Pages.IDAMembershipPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by NBhavas on 4/5/2016.
 */
public class IDAMembership {
    WebDriver driver;
    IDAHomePage idaHomePage;
    IDAMembershipPage idaMembershipPage;

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
        getWebDriverInstance("chrome");
        idaHomePage = IDAHomePage.getInstance(this.driver);
        idaMembershipPage = idaMembershipPage.getInstance(this.driver);
    }

    @AfterTest
    public void end() {
        if (driver != null)
            driver.quit();
        /*System.out.println("Scenario Name :"+scenario.getName());
        System.out.println("Scenario Status :"+scenario.getStatus());*/
    }

   @Test(priority = 1)
    public void OnlineRegistration() throws Throwable {
        idaHomePage.clickOnLink("Online Registration");
        idaMembershipPage = idaMembershipPage.getInstance(this.driver);
        idaMembershipPage.basicChecks();
    }
   @Test(priority = 2)
    public void Userdetails() throws Throwable {
       idaMembershipPage.createProfile();
    }
    @Test(priority = 0)
    public void launchedIDASite() throws Throwable {
        idaHomePage.lauchURL("http://www.ida.org.in");
        idaHomePage.clickOnLink("Membership");
        idaHomePage.verifyCurrentPage("http://www.ida.org.in/master.htm?ProgramId=3&url=Affiliatemembershipdetails/membershiphome.htm&catid=0",this.driver.getCurrentUrl());
    }




}
