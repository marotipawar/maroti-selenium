package com.maroti.common.webDriverImpl;

import com.maroti.common.webDriver.MyWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * @Author : Maroti Pawar
 *
 */
public abstract class AbstractWebDriver implements MyWebDriver {


    private WebDriver driver;
    private JavascriptExecutor javascript;
    private Actions actions;
    private Alert alert;
    private boolean isFolderExist;
    private TakesScreenshot screenshot;

    public AbstractWebDriver(WebDriver driver) {
        this.driver = driver;
        javascript = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        screenshot = (TakesScreenshot) driver;
        isFolderExist = new File("screenshots").mkdir();
    }

    @Override
    public void javaScriptSendKeys(WebElement element, String value) {
        javascript.executeScript("arguments[0].value='" + value + "'", element);
    }

    @Override
    public void javaScriptClick(WebElement element) {
        javascript.executeScript("arguments[0].click();", element);
    }

    @Override
    public void actionsClick(WebElement element) {
        actions.click(element).build().perform();
    }

    @Override
    public void actionSendKeys(WebElement element, String value) {
        actions.sendKeys(element, value).build().perform();
    }

    @Override
    public void switchFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    @Override
    public void switchFrame(int id) {
        driver.switchTo().frame(id);
    }

    @Override
    public void switchFrame(String name) {
        driver.switchTo().frame(name);
    }

    @Override
    public void navigateWindow(String id) {
        driver.switchTo().window(id);
    }

    @Override
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    @Override
    public void alertOk() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void alertCancel() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Override
    public void alertSendKeys(String value) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    @Override
    public String alertCaptureText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    @Override
    public void isExitsClick(WebElement element) {
        if (element.isEnabled() && element.isDisplayed())
            element.click();
    }

    @Override
    public void isExitsSendKeys(WebElement element, String value) {
        if (element.isDisplayed() && element.isEnabled())
            element.sendKeys(value);
    }

    @Override
    public boolean getScreenShotAs(String fileName) throws IOException {
        File file = new File("screenshots");

        if (file.exists()) {
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("screenshots", fileName));
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void visiblityExplicitWait(int second, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Override
    public void clickableExplicitWait(int second, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    @Override
    public void implicitWaite(int second) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    @Override
    public void goTo(String url) {
        driver.get(url);
    }

    @Override
    public WebDriver getCurrentDriverInstance() {
        return this.driver;
    }

    @Override
    public void maximize() {
        driver.manage().window().maximize();
    }

    @Override
    public void minimize() {
        driver.manage().window().minimize();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quite() {
        driver.quit();
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
}
