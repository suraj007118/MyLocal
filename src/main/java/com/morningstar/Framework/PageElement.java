package com.morningstar.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Sanit Thale on 3/28/2016 11:25 AM.
 */
public class PageElement {
    private String elementName;
    private By by;
    private WebElement webElement;
    private WaitType waitType;
    private int timeOut;
    boolean isSlowLoadableComponent;

    public PageElement(By by, String elementName) {
        this.by = by;
        this.elementName = elementName;
    }

    public PageElement(By by, String elementName,
                       boolean isSlowLoadableComponent, WaitType waitType, int timeOut) {
        this.elementName = elementName;
        this.by = by;
        this.waitType = waitType;
        this.timeOut = timeOut;
        this.isSlowLoadableComponent = isSlowLoadableComponent;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WaitType getWaitType() {
        return waitType;
    }

    public void setWaitType(WaitType waitType) {
        this.waitType = waitType;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public boolean isSlowLoadableComponent() {
        return isSlowLoadableComponent;
    }

    public void setSlowLoadableComponent(boolean isSlowLoadableComponent) {
        this.isSlowLoadableComponent = isSlowLoadableComponent;
    }
}
