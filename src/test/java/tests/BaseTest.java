package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    LoginPage loginPage;

    //create reference of object
    public static ExtentReports extentReports;
    public static ExtentTest test;
    public static ExtentSparkReporter sparkReporter;


    @BeforeMethod
    public void setUp()
    {
        //set up references
        String reportPath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
        sparkReporter=new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);

        //use test to add details to reporter
        extentReports=new ExtentReports();
        test=extentReports.createTest("verify user login");
        test.info("Navigating to home page");


        DriverManager.createDriver();
        ConfigReader.initProperties();
        loginPage=new LoginPage();
    }
    @AfterMethod
    public void cleanUp()
    {
        DriverManager.getDriver().quit();
        extentReports.attachReporter(sparkReporter);
        extentReports.flush();
    }
}
