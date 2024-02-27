package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {

    //precondition
    @BeforeMethod
    public void precondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "manuel@gm.com");
        //enter password
        type(By.name("password"), "Manuel1234$");
        //click on the Login button
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest() {
        //click on Add lick
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"),"Adam");
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"),"Karl");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"),"1234567890");
        //enter email
        type(By.cssSelector("input:nth-child(4)"),"adam@gm.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"),"Berlin");
        //enter description
        type(By.cssSelector("input:nth-child(6)"),"goalkeeper");
        //click on the Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //assert Contact is added by text
        Assert.assertTrue(isContactCreatedByText("Adam"));
    }

    @AfterMethod
    public void postCondition() {
        //click on the card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on the Remove button
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

}
