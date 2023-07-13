# Selenium-common-operations project can contains following interface and classes:

# Interface :
              It is contain only one Interface.
              
             # Name : MyWebDriver Interface

# Classes :
        #Abstract classes :
        
               - AbstractWebDriver class
        
        #Concrete classes :
               
               - ConcreteWebDriver class
        
        #Singleton classes :
        
               - SingletonWebDriver class

        # Base Layer :

                -BaseLayerWebDriver class

# factory classes :
    # ChromeDriver class.
    # FirefoxDriver class.
    # EdgeDriver class.

    
# MyWebDriver Interface

- MyWebDriver interface containing browser specifice operation method.
- It is use to implemented classes can perform operation on web element.
- It is customiz same as WebDriver interface.
- We can easilly implement on our class and use specific functionality.

# How to add selenium-common-operations Dependency in your project following step :

    # Copy bellow Repository and paste in your pom.xml file
    
```
<repositories>
  <repository>
    <id>maroti-releases</id>
    <url>https://packagecloud.io/maroti/releases/maven2</url>
    <releases>
      <enabled>true</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
```

# Add Dependency in pom.xml
```
<dependency>
  <groupId>com.maroti</groupId>
  <artifactId>selenium-common-operations</artifactId>
  <version>1.0.0</version>
</dependency>
```
# Using ChromeDriver factory class :

```
 public static void main(String[] args) {

        MyWebDriver driver = new ChromeDriver();
        driver.goTo("https://www.google.com");
        driver.maximize();
        driver.implicitWaite(30);
    }
```
# Using ConcreteWebDriver class
```

        MyWebDriver driver = new ConcreteWebDriver(new ChromeDriver());
        driver.goTo("https://www.google.com");
        driver.maximize();
        driver.implicitWaite(40);
```
# Using SingletonWebDriver class

```
  MyWebDriver driver=SingletonWebDriver.getInstance(new ChromeDriver());
        driver.goTo("https://www.google.com");
        driver.maximize();
        driver.implicitWaite(10);
```

# Using BaseLayerWebDrvier class
```
package com.maroti.common;

import com.maroti.common.webDriverImpl.BaseLayerWebDriver;

public class Login extends BaseLayerWebDriver {

    public static void main(String[] args) {

        initialization("chrome");

    }
}

```

# MyWebDriver Interface :
```
package com.maroti.common.webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
/**
 * @Author : Maroti Pawar
 *
 */
public interface MyWebDriver extends WebDriver{

    void javaScriptSendKeys(WebElement element, String value);
    void javaScriptClick(WebElement element);
    void actionsClick(WebElement element);
    void actionSendKeys(WebElement element, String value);
    void switchFrame(WebElement element);
    void switchFrame(int id);
    void switchFrame(String name);
    void navigateWindow(String id);
    void navigateTo(String url);
    void alertOk();
    void alertCancel();
    void alertSendKeys(String value);
    String alertCaptureText();
    void isExitsClick(WebElement element);
    void isExitsSendKeys(WebElement element, String value);
    boolean getScreenShotAs(String fileName) throws IOException;
    void visiblityExplicitWait(int second, By by);
    void clickableExplicitWait(int second, By by);
    void implicitWaite(int second);
    void goTo(String url);
    WebDriver getCurrentDriverInstance();
    void maximize();
    void minimize();
    void close();
    void quite();
}
```
