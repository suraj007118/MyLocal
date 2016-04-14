package com.morningstar.Framework;

import com.morningstar.Exceptions.ElementNotLoadedInSpecifiedTimeException;
import com.morningstar.Exceptions.UnsucessfulServiceException;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

/**
 * Created by Sanit Thale on 3/28/2016 11:20 AM.
 */
public class Page {
    protected WebDriver driver;
    protected Logger logger;
    protected String className;
    protected Actions action;
    private FrameworkServices frameworkServices;
    WebDriverService webDriverWrapper;

    public Page(WebDriver driver, String className, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        this.className = className;
        this.frameworkServices = new FrameworkServices();
        this.webDriverWrapper = new WebDriverService(driver);
    }

    private WebElement waitForElementAndReturnElement(PageElement pageElement) {

        switch (pageElement.getWaitType()) {

            case WAITFORELEMENTTOBECLICKABLE:
                try {
                    return webDriverWrapper.waitForElementToBeClickable(
                            pageElement.getBy(), pageElement.getTimeOut());
                } catch (TimeoutException e) {
                    throw new ElementNotLoadedInSpecifiedTimeException(
                            pageElement.getElementName(), pageElement.getTimeOut(),
                            e);
                }

            case WAITFORELEMENTTOBEEENABLED:

                try {
                    return webDriverWrapper.waitForElementToBeEnabled(
                            pageElement.getBy(), pageElement.getTimeOut());
                } catch (TimeoutException e) {
                    throw new ElementNotLoadedInSpecifiedTimeException(
                            pageElement.getElementName(), pageElement.getTimeOut(),
                            e);
                }

            case WAITFORELEMENTTOBEDISPLAYED:

                try {
                    return webDriverWrapper.waitForElementToBeDisplayed(
                            pageElement.getBy(), pageElement.getTimeOut());
                } catch (TimeoutException e) {
                    throw new ElementNotLoadedInSpecifiedTimeException(
                            pageElement.getElementName(), pageElement.getTimeOut(),
                            e);
                }
            case WAITFORELEMENTTOBEPRESENT:
                try {
                    return webDriverWrapper.waitForElementToBePresent(
                            pageElement.getBy(), pageElement.getTimeOut());

                } catch (TimeoutException e) {
                    throw new ElementNotLoadedInSpecifiedTimeException(
                            pageElement.getElementName(), pageElement.getTimeOut(),
                            e);
                }

            default:
                return driver.findElement(pageElement.getBy());

        }

    }

    protected void click(PageElement pageElement) {
        try {
            getWebElement(pageElement).click();
            frameworkServices.logMessage(
                    "Clicked on " + pageElement.getElementName() + " on "
                            + className + " page", logger);
        } catch (Exception e) {
            frameworkServices.logErrorMessage("Failed To Click On "
                    + pageElement.getElementName() + " on " + className
                    + " page", logger);
            throw new UnsucessfulServiceException("Failed To Click On "
                    + pageElement.getElementName() + " on " + className
                    + " page", e);
        } finally {
            pageElement = null;
        }

    }
    protected void clickAction(PageElement pageElement) {
        try {
            action=new Actions(this.driver);
            action.click(getWebElement(pageElement)).build().perform();
            frameworkServices.logMessage(
                    "Clicked on " + pageElement.getElementName() + " on "
                            + className + " page", logger);
        } catch (Exception e) {
            frameworkServices.logErrorMessage("Failed To Click On "
                    + pageElement.getElementName() + " on " + className
                    + " page", logger);
            throw new UnsucessfulServiceException("Failed To Click On "
                    + pageElement.getElementName() + " on " + className
                    + " page", e);
        } finally {
            pageElement = null;
        }

    }

    protected void clearAndSendKeys(PageElement pageElement, String value) {
        try {
            WebElement webElement = getWebElement(pageElement);
            webElement.clear();
            webElement.sendKeys(value);
            frameworkServices.logMessage("Cleared and Set value: '" + value + "' in "
                    + pageElement.getElementName() + " on " + className
                    + " page", logger);
        } catch (Exception e) {
            frameworkServices.logMessage("Failed Cleared and Set value '"
                    + value + "' in " + pageElement.getElementName() + " on "
                    + className + " page", logger);
            throw new UnsucessfulServiceException(
                    "Failed Cleared and Set value '" + value + "' in "
                            + pageElement.getElementName() + " on " + className
                            + " page", e);
        } finally {
            pageElement = null;
        }
    }

    protected void sendKeys(PageElement pageElement, Keys key) {
        try {
            WebElement webElement = getWebElement(pageElement);
            webElement.sendKeys(key);
            frameworkServices.logMessage("Entered" + key + " key in "
                    + pageElement.getElementName() + " on " + className
                    + " page", logger);
        } catch (Exception e) {
            throw new UnsucessfulServiceException("Failed Entered" + key
                    + " key in " + pageElement.getElementName() + " on "
                    + className + " page", e);
        } finally {
            pageElement = null;
        }
    }

    protected void selectValueFromList(PageElement pageElement, String value) {
        try {
            WebElement webElement = getWebElement(pageElement);
            Select select = new Select(webElement);
            select.selectByVisibleText(value);
            frameworkServices.logMessage("Value:" + value + " Selected "
                    + pageElement.getElementName() + " on " + className
                    + " page", logger);
        } catch (Exception e) {
            frameworkServices.logMessage("Failed select value '" + value
                    + "' in " + pageElement.getElementName() + " on "
                    + className + " page", logger);
            // e.printStackTrace();
            throw new UnsucessfulServiceException("Failed select value '"
                    + value + "' in " + pageElement.getElementName() + " on "
                    + className + " page", e);
        } finally {
            pageElement = null;
        }
    }

    protected void getUrl(String url) {
        try {
            driver.get(url);
            frameworkServices.logMessage("Browsed " + url, logger);
        } catch (Exception e) {
            frameworkServices.logMessage("Not able to browse '" + url
                            + "', please check entered url or internet connectivity",
                    logger);
            throw new UnsucessfulServiceException("Not able to browse '" + url
                    + "', please check entered url or internet connectivity", e);
        }
    }

    protected void maximiseWindow() {
        try {
            driver.manage().window().maximize();
            frameworkServices.logMessage("Window maximized ", logger);
        } catch (Exception e) {
            frameworkServices.logMessage(
                    "Not able to maximized browser window", logger);
            throw new UnsucessfulServiceException();
        }
    }

    protected void bringElementInView(PageElement pageElement) {

        try {
            WebElement webElement = getWebElement(pageElement);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", webElement);

            frameworkServices.logMessage(
                    "Brought  " + pageElement.getElementName() + "  "
                            + " in the current browser view ", logger);

        } catch (Exception exception) {
            frameworkServices.logMessage("Not able bring element in view",
                    logger);
            throw new UnsucessfulServiceException();
        } finally {
            pageElement = null;
        }
    }

    protected void fireClickByJavascript(PageElement pageElement) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
                    getWebElement(pageElement));
            frameworkServices.logMessage(
                    "Clicked on: ' " + pageElement.getElementName() + " '",
                    logger);
        } catch (Exception exception) {
            frameworkServices.logMessage("Not able click element ", logger);
            throw new UnsucessfulServiceException();
        } finally {
            pageElement = null;
        }

    }

    protected boolean isElementDisplayed(PageElement pageElement) {

        boolean isElementDisplayed = false;

        try {
            WebElement webElement = getWebElement(pageElement);
            isElementDisplayed = webElement.isDisplayed();
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is Displayed ", logger);
        } catch (Exception e) {
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is not Displayed ", logger);

        } finally {
            pageElement = null;
        }
        return isElementDisplayed;

    }

    protected boolean isElementSelected(PageElement pageElement) {

        boolean isElementSelected = false;

        try {
            WebElement webElement = getWebElement(pageElement);
            isElementSelected = webElement.isSelected();
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is Selected ", logger);
        } catch (Exception e) {
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is not Selected ", logger);

        } finally {
            pageElement = null;
        }
        return isElementSelected;

    }

    protected boolean isElementPresent(PageElement pageElement) {
        boolean isElementDisplayed = false;
        try {
            getWebElement(pageElement);
            isElementDisplayed = true;
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is Present ", logger);
        } catch (Exception e) {
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is not Present ", logger);
        } finally {
            pageElement = null;
        }
        return isElementDisplayed;

    }

    protected boolean isElementEnabled(PageElement pageElement) {

        boolean isElementEnabled = false;

        try {
            WebElement webElement = getWebElement(pageElement);
            isElementEnabled = webElement.isEnabled();
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is Enabled ", logger);
        } catch (Exception e) {
            frameworkServices.logMessage(pageElement.getElementName()
                    + " is not Enabled ", logger);
        } finally {
            pageElement = null;
        }
        return isElementEnabled;

    }

    protected void check(PageElement pageElement) {
        try {
            WebElement webElement = getWebElement(pageElement);
            if (!webElement.isSelected()) {
                webElement.click();

            }

            frameworkServices.logMessage(
                    "Checked  " + pageElement.getElementName(), logger);
        } catch (Exception exception) {
            frameworkServices.logMessage("Not able check element ", logger);
            throw new UnsucessfulServiceException("Not able to check element ",
                    exception);
        } finally {
            pageElement = null;
        }
    }

    protected void unCheck(PageElement pageElement) {
        try {

            WebElement webElement = getWebElement(pageElement);
            if (webElement.isSelected())
                webElement.click();
            frameworkServices.logMessage(
                    "Unchecked  " + pageElement.getElementName(), logger);
        } catch (Exception exception) {
            frameworkServices.logMessage("Not able uncheck element ", logger);
            throw new UnsucessfulServiceException(
                    "Not able to uncheck element ", exception);

        } finally {
            pageElement = null;
        }
    }

    protected String getAttribute(PageElement pageElement, String attribute) {
        try {

            WebElement webElement = getWebElement(pageElement);
            String value = webElement.getAttribute(attribute);
            frameworkServices.logMessage(
                    "Fetched Text  " + pageElement.getElementName(), logger);
            return value;
        } catch (Exception exception) {
            frameworkServices.logMessage("Not able Fetched attribute ", logger);
            throw new UnsucessfulServiceException(
                    "Not able Fetched attribute ", exception);
        } finally {
            pageElement = null;
        }
    }

    protected String getText(PageElement pageElement) {
        try {

            WebElement webElement = getWebElement(pageElement);
            String value = webElement.getText();
            frameworkServices.logMessage(
                    "Fetched Text  " + pageElement.getElementName(), logger);
            return value;
        } catch (Exception exception) {
            frameworkServices.logMessage("Not able Fetched Text ", logger);
            throw new UnsucessfulServiceException("Not able Fetched Text ",
                    exception);
        } finally {
            pageElement = null;
        }
    }

    private WebElement getWebElement(PageElement pageElement) {
        if (pageElement.isSlowLoadableComponent()) {
            return waitForElementAndReturnElement(pageElement);
        } else
            return driver.findElement(pageElement.getBy());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void switchTab() {
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(
                driver.getWindowHandles());
        // newTab.remove(oldTab);
        driver.getWindowHandle();
        // change focus to new tab
        driver.switchTo().window(newTab.get(1));
        WebDriverService.wait(5);
    }
    public void switchFrame(PageElement pageElement, String frameName) {
        try {
            //String capture =pageElement.getWebElement().getText();
            getWebElement(pageElement);
            driver.switchTo().frame(frameName);
            frameworkServices.logMessage(
                    "Switch to " + pageElement.getElementName() + " on "
                            + className + " page", logger);
        } catch (Exception e) {
            frameworkServices.logErrorMessage("Failed To Switch "
                    + pageElement.getElementName() + " on " + className
                    + " page", logger);
            throw new UnsucessfulServiceException("Failed To Switch "
                    + pageElement.getElementName() + " on " + className
                    + " page", e);
        } finally {
            pageElement = null;
        }
    }

}
