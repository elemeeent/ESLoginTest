package ru.comita.esshop.utils;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

/**
 * Class, produced to make imported reports from test to Allure report
 *
 */

public class TextReportForAllure extends ExitCodeListener {
    protected CustomReport report = new CustomReport();

    public TextReportForAllure(){
    }

    public void onTestStart(ITestResult result) {
        this.report.start();
    }

    public void onTestFailure(ITestResult result) {
        this.report.finish(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        this.report.finish(result.getName());
    }

}
