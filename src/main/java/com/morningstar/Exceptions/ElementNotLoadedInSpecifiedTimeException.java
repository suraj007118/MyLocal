package com.morningstar.Exceptions;

/**
 * Created by Sanit Thale on 3/28/2016 11:29 AM.
 */
public class ElementNotLoadedInSpecifiedTimeException extends RuntimeException {

    public ElementNotLoadedInSpecifiedTimeException(String element,
                                                    String timeout) {
        super(
                "Element "
                        + element
                        + " was not loaded in specified timeout of "
                        + timeout
                        + " seconds kindly refer attached screenshot for more clearification");
    }

    public ElementNotLoadedInSpecifiedTimeException(String element,
                                                    String timeout, Exception cause) {
        super(
                "Element "
                        + element
                        + " was not loaded in specified timeout of "
                        + timeout
                        + " seconds kindly refer attached screenshot for more clearification",
                cause);
    }

    public ElementNotLoadedInSpecifiedTimeException(String element,
                                                    int timeout, Exception cause) {
        super(
                "Element "
                        + element
                        + " was not loaded in specified timeout of "
                        + timeout
                        + " seconds kindly refer attached screenshot for more clearification",
                cause);
    }

    public ElementNotLoadedInSpecifiedTimeException() {
        super("Element not loaded in specified timeout");
    }

}