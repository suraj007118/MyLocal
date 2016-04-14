package com.morningstar.Pages;

import com.morningstar.Framework.Page;
import com.morningstar.Framework.PageElement;
import com.morningstar.Framework.WaitType;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by NBhavas on 4/6/2016.
 */
public class IDAMembershipPage extends Page {
    WebDriver driver;
    IDAHomePage idaHomePage;
    private static Logger log = Logger.getLogger(IDAMembershipPage.class.getName());


    public IDAMembershipPage(WebDriver driver) {
        super(driver, IDAMembershipPage.class.getSimpleName(), log);
        this.driver = driver;
    }

    public void waitForPageToLoad(WebDriver driver) {
        //TODO: Wait For The Element
        //this.scenario = scenario;
    }

    public static IDAMembershipPage getInstance(WebDriver driver) {
        IDAMembershipPage idaMembershipPage = PageFactory.initElements(driver, IDAMembershipPage.class);
        idaMembershipPage.waitForPageToLoad(driver);
        return idaMembershipPage;
    }

    /*************
     * Page Elements
     ****************/

    private PageElement dinningPlusChkBox() {
        return new PageElement(By.id("chkdinningflag"), "Getting Check Box Add Dinning plus");
    }

    private PageElement nextButton() {
        return new PageElement(By.xpath(".//a[contains(text(),'Next')]"), "Getting Next Button");
    }
    private PageElement forEnquiryButton() {
        return new PageElement(By.xpath(".//a[contains(text(),'For')]"), "Getting ForEnquiry Button");
    }
    private PageElement titleComboBox() {
        return new PageElement(By.id("cmbTitle"), "Getting Title ComboBox");
    }
    private PageElement genderComboBox() {
        return new PageElement(By.id("cmbGender"), "Getting Gender ComboBox");
    }
    private PageElement bloodGroupComboBox() {
        return new PageElement(By.id("cmbBloodGroup"), "Getting BloodGroup ComboBox");
    }
    private PageElement countryComboBox() {
        return new PageElement(By.id("cmbCountry"), "Getting Country ComboBox",true, WaitType.WAITFORELEMENTTOBEDISPLAYED,10);
    }
    private PageElement stateComboBox() {
        return new PageElement(By.id("cmbState"), "Getting State ComboBox",true, WaitType.WAITFORELEMENTTOBEDISPLAYED,10);
    }
    private PageElement cityComboBox() {
        return new PageElement(By.id("cmbCity"), "Getting City ComboBox",true, WaitType.WAITFORELEMENTTOBEDISPLAYED,10);
    }
    private PageElement uGQualificationComboBox() {
        return new PageElement(By.id("cmbUGQuali"), "Getting UGQualification ComboBox");
    }
    private PageElement uGUniversityComboBox() {
        return new PageElement(By.id("cmbUG_Univ"), "Getting UGUniversity ComboBox");
    }
    private PageElement uGCollegeComboBox() {
        return new PageElement(By.id("cmbUG_College"), "Getting UGCollege ComboBox");
    }
    private PageElement pGQualificationComboBox() {
        return new PageElement(By.id("cmbPG_Quali"), "Getting PGQualification ComboBox",true, WaitType.WAITFORELEMENTTOBEDISPLAYED,10);
    }
    private PageElement specificationComboBox() {
        return new PageElement(By.id("cmbSpec"), "Getting Specification ComboBox");
    }
    private PageElement pGUniversityComboBox() {
        return new PageElement(By.id("cmbPG_Univ"), "Getting PGUniversity ComboBox");
    }
    private PageElement pGCollegeComboBox() {
        return new PageElement(By.id("cmbPG_College"), "Getting PGCollege ComboBox");
    }
    private PageElement sDCComboBox() {
        return new PageElement(By.id("cmbSDC"), "Getting SDC ComboBox");
    }

    private PageElement firstNameTextBox() {
        return new PageElement(By.id("txtFName"), "Getting First Name TextBox");
    }
    private PageElement middleNameTextBox() {
        return new PageElement(By.id("txtMName"), "Getting Middle Name TextBox");
    }
    private PageElement lastNameTextBox() {
        return new PageElement(By.id("txtLName"), "Getting Last Name TextBox");
    }
    private PageElement prefNameTextBox() {
        return new PageElement(By.id("txtPName"), "Getting Pref Name TextBox");
    }
    private PageElement dOBTextBox() {
        return new PageElement(By.id("txtDOB"), "Getting DOB  TextBox");
    }
    private PageElement add1TextBox() {
        return new PageElement(By.id("txtAdd1"), "Getting Add1 TextBox");
    }
    private PageElement add2TextBox() {
        return new PageElement(By.id("txtAdd2"), "Getting Add2 TextBox");
    }
    private PageElement areaTextBox() {
        return new PageElement(By.id("txtArea"), "Getting Area TextBox");
    }
    private PageElement pinTextBox() {
        return new PageElement(By.id("txtPin"), "Getting Pin TextBox");
    }
    private PageElement tel1TextBox() {
        return new PageElement(By.id("txtTel1"), "Getting Tel1 TextBox");
    }
    private PageElement faxTextBox() {
        return new PageElement(By.id("txtFax"), "Getting Fax TextBox");
    }
    private PageElement mobileTextBox() {
        return new PageElement(By.id("txtMobile1"), "Getting Mobile TextBox");
    }
    private PageElement emailTextBox() {
        return new PageElement(By.id("txtEmail1"), "Getting Email TextBox");
    }
    private PageElement regnoTextBox() {
        return new PageElement(By.id("txtRegNo"), "Getting Regno TextBox");
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
    public void basicChecks(){
        switchTab();
        click(dinningPlusChkBox());
        click(nextButton());
    }
    public void createProfile() {
        //switchTab();
        selectValueFromList(titleComboBox(),"Mr.");
        clearAndSendKeys(firstNameTextBox(),"Vijay");
        clearAndSendKeys(middleNameTextBox(),"R");
        clearAndSendKeys(lastNameTextBox(),"Kothawade");
        clearAndSendKeys(prefNameTextBox()," Viju Master");
        //   Need to do later clearAndSendKeys(dOBTextBox(),"01-12-1984");
        selectValueFromList(genderComboBox(),"Male");
        selectValueFromList(bloodGroupComboBox(),"O+");
        clearAndSendKeys(add1TextBox(),"Om Palace");
        clearAndSendKeys(add2TextBox(),"Dombivali east");
        selectValueFromList(countryComboBox(),"India");
        wait(3);
        selectValueFromList(stateComboBox(),"Maharashtra");
        wait(3);
        selectValueFromList(cityComboBox(),"Mumbai");
        clearAndSendKeys(areaTextBox(),"Amchi Mumbai");
        clearAndSendKeys(pinTextBox(),"421001");
        clearAndSendKeys(tel1TextBox(),"022-8754736");
        clearAndSendKeys(faxTextBox(),"FAX On This");
        selectValueFromList(uGQualificationComboBox(),"B.D.S.");
        selectValueFromList(uGUniversityComboBox(),"Madras University");
        selectValueFromList(uGCollegeComboBox(),"Pacific Dental College");
        selectValueFromList(pGQualificationComboBox(),"M.D.S.");
        wait(3);
        selectValueFromList(specificationComboBox(),"Pediatric Dentistry");
        selectValueFromList(pGUniversityComboBox(),"Calcutta University");
        selectValueFromList(pGCollegeComboBox(),"Manubhai Patel Dental College");
        clearAndSendKeys(mobileTextBox(),"6543874576");
        clearAndSendKeys(emailTextBox(),"info@ida.com");
        selectValueFromList(sDCComboBox(),"Himachal Pradesh State Dental Council");
        clearAndSendKeys(regnoTextBox(),"A-123");
        wait(2);
        click(forEnquiryButton());
        wait(2);
    }
}
