package ru.comita.esshop.utils;

import com.codeborne.selenide.ex.ErrorMessages;
import com.codeborne.selenide.ex.UIAssertionError;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.ITestResult;

import java.util.logging.Logger;

/**
 * By utils class method calls:
 * UtilClass.takeScreenshot()
 * that needed to be created with @Attachment annotation in Utils Class
 * like:
    @Attachment()
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
 }
  * this screenshot will be attached to Allure-report;
 */

public class ScreenShotForAllure extends ScreenShooter {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    public static boolean captureSuccessfulTests;

    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        TestUtils.takeScreenshot();
    }

    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        if(!(result.getThrowable() instanceof UIAssertionError)) {
            this.log.info(ErrorMessages.screenshot());
        }
        TestUtils.takeScreenshot();
    }

    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        if(captureSuccessfulTests) {
            this.log.info(ErrorMessages.screenshot());
        }
        TestUtils.takeScreenshot();
    }
}
