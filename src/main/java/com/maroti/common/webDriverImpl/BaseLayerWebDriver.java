package com.maroti.common.webDriverImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/**
 * @Author : Maroti Pawar
 *
 */
public class BaseLayerWebDriver{

    public static WebDriver driver;

    public static WebDriver initialization(String name){
        if(name.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(name.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(name.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

}
