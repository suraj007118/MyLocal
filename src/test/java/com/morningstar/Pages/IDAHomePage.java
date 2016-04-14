package com.morningstar.Pages;

import com.morningstar.Framework.Page;
import com.morningstar.Framework.PageElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by NBhavas on 4/4/2016.
 */
public class IDAHomePage extends Page {
    WebDriver driver;
    private static Logger log = Logger.getLogger(IDAHomePage.class.getName());


    public IDAHomePage(WebDriver driver) {
        super(driver, IDAHomePage.class.getSimpleName(),log);
        this.driver = driver;
    }

    public void waitForPageToLoad(WebDriver driver) {
        //TODO: Wait For The Element
        //this.scenario = scenario;
    }
    public static IDAHomePage getInstance(WebDriver driver) {
        IDAHomePage idaHomePage = PageFactory.initElements(driver, IDAHomePage.class);
        idaHomePage.waitForPageToLoad(driver);
        return idaHomePage;
    }

    /*************
     * Page Elements
     ****************/

    private PageElement link(String linkText) {
        return new PageElement(By.linkText(linkText), "Getting link text as "+linkText);
    }



    /*************
     * Services
     *********************/
    public void lauchURL(String url)    {
        getUrl(url);
    }
    public void clickOnLink(String linkText) {
        click(link(linkText));
    }

    public void verifyCurrentPage(String expURL,String currentURL)
    {
        assertEquals(expURL, currentURL);
    }

}
