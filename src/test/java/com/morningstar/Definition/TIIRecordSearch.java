package com.morningstar.Definition;

        import com.morningstar.Framework.WebDriverService;
        import com.morningstar.Pages.IDAHomePage;
        import com.morningstar.Pages.TIIPage;
        import org.openqa.selenium.WebDriver;
        import org.testng.annotations.AfterSuite;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

/**
 * Created by NBhavas on 4/4/2016.
 */
public class TIIRecordSearch {

    WebDriver driver;
    IDAHomePage idaHomePage;
    TIIPage tiiPage;

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
        tiiPage = TIIPage.getInstance(this.driver);
    }

    @AfterTest
    public void end() {
        if (driver != null)
            driver.quit();
        /*System.out.println("Scenario Name :"+scenario.getName());
        System.out.println("Scenario Status :"+scenario.getStatus());*/
    }

    @Test(priority = 0)
    public void launchedIDASite() throws Throwable {
        String linkText="Directories";
        String expURL="http://www.ida.org.in/master.htm?ProgramId=11&url=Search/dentistdirectory.aspx&catid=0";
        idaHomePage.lauchURL("http://www.ida.org.in");
        idaHomePage.clickOnLink(linkText);
        idaHomePage.verifyCurrentPage(expURL, this.driver.getCurrentUrl());
    }

    @Test(priority = 1)
    public void click_on_link() throws Throwable {
        String linkText="TII Centers";
        idaHomePage.clickOnLink(linkText);
    }

    @Test(priority = 2)
    public void fillInfo() throws Throwable {
        String rbText="TII Centre";String stateText="Uttarakhand";String cityText="Nainital";String areaText="Kashipur";String prefNameText="Richa Bhalla";
        tiiPage.fillsearchCriteria(rbText, stateText, cityText, areaText, prefNameText);
    }

}
