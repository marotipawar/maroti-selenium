package com.maroti.common.factory;

import com.maroti.common.webDriverImpl.AbstractWebDriver;
import org.openqa.selenium.WebDriver;
/**
 * @Author : Maroti Pawar
 *
 */
public class FirefoxDriver extends AbstractWebDriver {
    public FirefoxDriver(WebDriver driver) {
        super(driver);
    }

    public FirefoxDriver() {
        this(new org.openqa.selenium.firefox.FirefoxDriver());
    }
}
