package com.maroti.common.factory;

import com.maroti.common.webDriverImpl.AbstractWebDriver;
import org.openqa.selenium.WebDriver;
/**
 * @Author : Maroti Pawar
 *
 */
public class EdgeDriver extends AbstractWebDriver  {
    public EdgeDriver(WebDriver driver) {
        super(driver);
    }

    public EdgeDriver() {
        this(new org.openqa.selenium.edge.EdgeDriver());
    }
}
