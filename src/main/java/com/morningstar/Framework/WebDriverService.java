package com.morningstar.Framework;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sanit Thale on 3/15/2016.
 */
public class WebDriverService {
    WebDriver driver;

    public WebDriverService() {

    }

    public WebDriverService(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriverInstance(String browser) throws Exception {
        DesiredCapabilities capabilities = null;

        try {
            switch (browser) {
                case "Firefox":
                 //   capabilities = DesiredCapabilities.firefox();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                 //   capabilities = DesiredCapabilities.chrome();
                    System.setProperty("webdriver.chrome.driver","C:\\Users\\skelkar\\Selenium\\driverpath\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "ie":
                //    capabilities = DesiredCapabilities.internetExplorer();
                    System.setProperty("webdriver.chrome.driver","C:\\Users\\skelkar\\Selenium\\driverpath\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
            }
         //   this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }// catch (MalformedURLException e) {
        catch (Exception e) {
            e.printStackTrace();
        }

        if (driver == null)
            throw new WebDriverException();
        return driver;
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    public WebElement waitForElementToBeDisplayed(final WebElement element,
                                                  int timeOutPeriod) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    if (element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {

                    return null;
                }
            }

        });
    }

    public WebElement waitForElementToBeDisplayed(final By by, int timeOutPeriod) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(by);
                    if (element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeClickable(final By by, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(by);
                    if (element.isEnabled() && element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBePresent(final By by, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    System.out.println(by.toString());
                    return driver.findElement(by);
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeClickable(final WebElement element,
                                                  int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {

                    if (element.isEnabled() && element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBePopulatedWithText(final By element,
                                                          int timeOutPeriod, final String text) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement webElement = driver.findElement(element);
                    if (webElement.getText().trim().equalsIgnoreCase(text))
                        return webElement;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeEnabled(final WebElement element,
                                                int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    if (element.isEnabled())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeEnabled(final By by, int timeOutPeriod) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(by);
                    System.out.println();
                    if (element.isEnabled())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForOptionToBePopulatedInList(
            final WebElement dropDownList, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    List<WebElement> options = dropDownList.findElements(By
                            .tagName("option"));
                    if (options.size() > 1) {
                        return dropDownList;
                    } else
                        return null;

                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }

            }

        });


    }
}