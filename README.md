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

