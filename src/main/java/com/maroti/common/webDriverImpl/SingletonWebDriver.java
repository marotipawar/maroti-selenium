package com.maroti.common.webDriverImpl;

import com.maroti.common.webDriver.MyWebDriver;
import org.openqa.selenium.*;
/**
 * @Author : Maroti Pawar
 *
 */
public final class SingletonWebDriver extends AbstractWebDriver {

    private static SingletonWebDriver singletonWebDriver = null;

    public SingletonWebDriver(WebDriver driver) {
        super(driver);
    }


    public static MyWebDriver getInstance(WebDriver driver){
       if(singletonWebDriver == null){
           singletonWebDriver = new SingletonWebDriver(driver);
       }
        return singletonWebDriver;
    }

}
