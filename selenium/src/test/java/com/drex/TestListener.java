package com.drex;

import com.drex.driver.factory.DriverManager;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        addBrowserInformationOnAllureReport();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // empty
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failTest(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.error(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // empty
    }

    @Override
    public void onStart(ITestContext context) {
        // empty
    }

    @Override
    public void onFinish(ITestContext context) {
        // empty
    }

    private void failTest(ITestResult iTestResult) {
        log.error(iTestResult.getTestClass().getName());
        log.error(iTestResult.getThrowable());

        takeScreenshotToAttachOnAllureReport();
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Browser information", type = "text/plain")
    public String addBrowserInformationOnAllureReport() {
        return DriverManager.getInfo();
    }


}
