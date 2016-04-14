package com.morningstar.Definition;

import com.morningstar.Framework.WebDriverService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

/**
 * Created by NBhavas on 4/6/2016.
 */
public class StepDefinitionHandler {
    static WebDriver driver;
    public StepDefinitionHandler() {
    }

   /* public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
*/
    public static WebDriver getWebDriverInstance(String browser) {
        try {
            driver = new WebDriverService().getWebDriverInstance(browser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

   @BeforeTest
    public void before() throws Exception {
        getWebDriverInstance("chrome");
        driver.manage().window().maximize();
    }

    /*@AfterTest
    public void end() {
        if (driver != null)
            driver.quit();
        //System.out.println("Scenario Name :" + scenario.getName());
        //System.out.println("Scenario Status :" + scenario.getStatus());
    }*/

}
