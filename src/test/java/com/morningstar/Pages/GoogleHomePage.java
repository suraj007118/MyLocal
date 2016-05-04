package com.morningstar.Pages;

import com.morningstar.Framework.Page;
import com.morningstar.Exceptions.UnsucessfulServiceException;
import com.morningstar.Framework.PageElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.morningstar.Framework.WaitType.WAITFORELEMENTTOBECLICKABLE;

/**
 * Created by Sanit Thale on 3/21/2016 12:39 PM.
 */
public class GoogleHomePage extends Page {

    WebDriver driver;
    private static Logger log = Logger.getLogger(GoogleHomePage.class.getName());


    public GoogleHomePage(WebDriver driver) {
        super(driver, GoogleHomePage.class.getSimpleName(),log);
        this.driver = driver;
        waitForPageToLoad();
    }

    public void waitForPageToLoad() {
        //TODO: Wait For The Element
       if(!isElementDisplayed(continueBtn())){
         throw new Error("GoogleHomePage was not successfully loaded");
       }
       // this.scenario = scenario;
    }



 /*   public static GoogleHomePage getInstance(WebDriver driver) {
        GoogleHomePage googleHomePage = PageFactory.initElements(driver, GoogleHomePage.class);
       googleHomePage.waitForPageToLoad(driver);
        return googleHomePage;
    }*/

    /*************
     * Page Elements
     ****************/

    private PageElement searchTextBox() {
        return new PageElement(By.xpath("//input[@title='Search']"), "Search Text Box");
    }
    private PageElement searchButton() {
        return new PageElement(By.xpath("//input[@name='btnK']"), "Search Text Box");
    }
    private PageElement LocateThis() {
        return new PageElement(By.xpath("//div[contains(text(),'Advertise with us')]/parent::td"), "Search Text Box");
    }

private PageElement continueBtn(){
    return new PageElement (By.xpath(".//*[@id='continue']"),"Continue Btn",true,WAITFORELEMENTTOBECLICKABLE,5);
}
    /*************
     * Services
     *********************/

    public void search() {


        //highlightElement(driver.findElement(By.xpath("//input[@title='Search']")));
        //highlightElement((searchButton()));
        //clearAndSendKeys(searchTextBox(), "Selenium HQ");
        /*log.info("google search completed");
        scenario.write("google search completed");*/
       // bringElementInView(LocateThis());
      //  highlightElement(LocateThis());
       // verifyEquals(true,false,"ashgdshjgasdk");
       // verifyEquals(true,false,"1233");
       // verifyEquals(true,false,"ashgdshfsd3245jgasdk");
       // verifyEquals(true,false,"123sdfsdf");
      //  getAll();
    }
    public void selecthotel()
    {

        click(continueBtn());
    }
}
