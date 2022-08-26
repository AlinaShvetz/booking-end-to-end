package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    public static WebDriver addbrowser (String browser) {
       if (browser.equalsIgnoreCase("chrome")){System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nexus\\Desktop\\AutomationTestingProject\\Software\\chromedriver.exe");
       return new ChromeDriver();
       }
       else {
           System.setProperty("webdriver.gecko.driver","C:\\Users\\Nexus\\Desktop\\AutomationTestingProject\\Software\\geckodriver.exe");
           return new FirefoxDriver();
       }
   }

}
