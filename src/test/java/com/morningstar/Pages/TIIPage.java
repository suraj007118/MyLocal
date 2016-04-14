package com.morningstar.Pages;

import com.morningstar.Framework.Page;
import com.morningstar.Framework.PageElement;
import com.morningstar.Framework.WaitType;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by NBhavas on 4/5/2016.
 */
public class TIIPage extends Page {
    WebDriver driver;
    private static Logger log = Logger.getLogger(TIIPage.class.getName());


    public TIIPage(WebDriver driver) {
        super(driver, TIIPage.class.getSimpleName(), log);
        this.driver = driver;
    }

    public void waitForPageToLoad(WebDriver driver) {
        //TODO: Wait For The Element
        //this.scenario = scenario;
    }

    public static TIIPage getInstance(WebDriver driver) {
        TIIPage tiiPage = PageFactory.initElements(driver, TIIPage.class);
        tiiPage.waitForPageToLoad(driver);
        return tiiPage;
    }

    /*************
     * Page Elements
     ****************/

    private PageElement radioButton(String rbText) {
        return new PageElement(By.xpath(".//label[contains(text(),'" + rbText + "')]/preceding-sibling::input"), "Getting Radio Button with text" + rbText);
    }

    private PageElement stateDropDown() {
        return new PageElement(By.id("ddlState"), "Getting state DropDown");
    }

    private PageElement cityDropDown() {
        return new PageElement(By.id("ddlCity"), "Getting City DropDown");
    }

    private PageElement talukaDropDown() {
        return new PageElement(By.id("ddlTaluka"), "Getting Taluka DropDown");
    }

    private PageElement areaTextBox() {
        return new PageElement(By.id("CPH_txtArea"), "Getting Area TextBox");
    }

    private PageElement prefNameTextBox() {
        return new PageElement(By.id("CPH_txtname1"), "Getting Pref. Name TextBox");
    }

    private PageElement practiseNameTextBox() {
        return new PageElement(By.id("CPH_txtPractName"), "Getting Practise Name TextBox");
    }

    private PageElement searchButton() {
        return new PageElement(By.id("CPH_btnSearch"), "Getting Search Button");
    }

    private PageElement textFromTable(String txtname) {
        return new PageElement(By.xpath(".//td[contains(text(),'" + txtname + "')]"), "Getting Text from Table", true, WaitType.WAITFORELEMENTTOBEDISPLAYED, 10);
    }

    private PageElement takeAppoinmentButton() {
        return new PageElement(By.id("btn1"), "Getting Take Appoinment Button");
    }

    private PageElement firstNameTextBox() {
        return new PageElement(By.id("txtfirstname"), "Getting First Name TextBox");
    }

    private PageElement middleNameTextBox() {
        return new PageElement(By.id("txtmiddlename"), "Getting Getting Middle Name TextBox");
    }

    private PageElement lastNameTextBox() {
        return new PageElement(By.id("txtlastname"), "Getting Last Name TextBox");
    }

    private PageElement practiseAdd0TextBox() {
        return new PageElement(By.id("txtPracAdd_0"), "Getting practise Add0 TextBox");
    }

    private PageElement practiseAdd1TextBox() {
        return new PageElement(By.id("txtPracAdd_1"), "Getting practise Add1 TextBox");
    }

    private PageElement practiseAdd2TextBox() {
        return new PageElement(By.id("txtPracAdd_2"), "Getting practise Add2 TextBox");
    }

    private PageElement area1TextBox() {
        return new PageElement(By.id("txtArea1"), "Getting Area1 TextBox");
    }

    private PageElement pin1TextBox() {
        return new PageElement(By.id("txtPin1"), "Getting pin1 TextBox");
    }

    private PageElement telTextBox() {
        return new PageElement(By.id("txtTel10"), "Getting Tel TextBox");
    }

    private PageElement mobTextBox() {
        return new PageElement(By.id("txtMob1"), "Getting Mob TextBox");
    }

    private PageElement emailTextBox() {
        return new PageElement(By.id("txtEmail1"), "Getting Email TextBox");
    }

    private PageElement nextButton() {
        return new PageElement(By.id("form2_next"), "Getting next Button");
    }

    private PageElement prefAddRadioButton() {
        return new PageElement(By.id("chkPrefAdd"), "Getting Pref Add Radio Button");
    }

    private PageElement closeformButton() {
        return new PageElement(By.xpath("//div[text()='close']"), "Getting close icon",
                true, WaitType.WAITFORELEMENTTOBEDISPLAYED, 10);
    }

    private PageElement frameElement() {
        return new PageElement(By.id("ifrmApt"), "Getting Frame Element", true,
                WaitType.WAITFORELEMENTTOBEDISPLAYED, 10);
    }


    /*************
     * Services
     *********************/
    private static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }
    public void fillsearchCriteria(String rbText, String stateText, String cityText, String areaText, String prefNameText) {
        switchTab();
        click(radioButton(rbText));
        selectValueFromList(stateDropDown(), stateText);
        selectValueFromList(cityDropDown(), cityText);
        clearAndSendKeys(areaTextBox(), areaText);
        clearAndSendKeys(prefNameTextBox(), prefNameText);
        click(searchButton());
        wait(2);
        click(textFromTable(prefNameText));
        switchFrame(frameElement(), "ifrmApt");
        click(takeAppoinmentButton());
        switchFrame(frameElement(), "ifrmApt");
        clearAndSendKeys(firstNameTextBox(), "Vijay");
        clearAndSendKeys(middleNameTextBox(), "R");
        clearAndSendKeys(lastNameTextBox(), "Kothavade");
        wait(2);
        click(nextButton());
        click(prefAddRadioButton());
        clearAndSendKeys(practiseAdd0TextBox(), "Opera House");
        clearAndSendKeys(practiseAdd1TextBox(), "Sandhurst Bridge");
        clearAndSendKeys(practiseAdd2TextBox(), "Churni Road,Mumbai");
        clearAndSendKeys(area1TextBox(), "West");
        clearAndSendKeys(pin1TextBox(), "421001");
        clearAndSendKeys(telTextBox(), "022-2456789");
        clearAndSendKeys(mobTextBox(), "9876543210");
        clearAndSendKeys(emailTextBox(), "vijayk@ida.com");
        wait(2);
        driver.switchTo().defaultContent();
        click(closeformButton());
        wait(3);
    }
}
