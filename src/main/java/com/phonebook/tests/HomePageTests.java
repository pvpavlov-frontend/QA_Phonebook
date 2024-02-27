package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests extends com.phonebook.tests.TestBase {
    WebDriver webDriver;
    @BeforeMethod
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.get("https://telranedu.web.app/home");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod(enabled = true)
    public void tearDown(){
        webDriver.quit();
    }
    @Test
    public void isHomeComponentPresentTest() {
        //System.out.println("Home Component is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }

}
