package com.maroti.common.factory;

import com.maroti.common.webDriverImpl.AbstractWebDriver;
import org.openqa.selenium.WebDriver;
/**
 * @Author : Maroti Pawar
 *
 */
public class ChromeDriver extends AbstractWebDriver {
    public ChromeDriver(WebDriver driver) {
        super(driver);
    }

    public ChromeDriver() {
        this(new org.openqa.selenium.chrome.ChromeDriver());
    }
}
