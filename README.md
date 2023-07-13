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
  <artifactId>maroti-selenium</artifactId>
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
 https://github.com/marotipawar/selenium-common-operations/blob/main/src/main/java/com/maroti/common/webDriver/MyWebDriver.java
