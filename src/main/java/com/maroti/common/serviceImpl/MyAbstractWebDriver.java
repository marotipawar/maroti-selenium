package com.maroti.common.serviceImpl;

import com.maroti.common.sevices.MyWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class MyAbstractWebDriver implements MyWebDriver {


    private WebDriver driver;
    private JavascriptExecutor javascript;
    private Actions actions;
    private Alert alert;
    private boolean isFolderExist;
    private TakesScreenshot screenshot;

    public MyAbstractWebDriver(WebDriver driver) {
        this.driver = driver;
        javascript = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        alert = driver.switchTo().alert();
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
        alert.accept();
    }

    @Override
    public void alertCancel() {
        alert.dismiss();
    }

    @Override
    public void alertSendKeys(String value) {
        alert.sendKeys(value);
    }

    @Override
    public String alertCaptureText() {
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
        if (isFolderExist) {
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
}
