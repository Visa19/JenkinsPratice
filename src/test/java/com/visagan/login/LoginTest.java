package com.visagan.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selanium_Google Drive\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test
    public void validLogin() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement name = driver.findElement(By.name("username"));  
        name.sendKeys("student");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Password123");

        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();

        // Validation: Check for "Log out" button to confirm login success
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button should be visible after login.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
