package com.company.Exp;

import com.company.Conversion;
import com.company.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browsertype = "ffx";
    String siteTested = "https://www.booking.com/";
    String room = "1";

@Given("The user opens the browser navigates to the Booking site")

public void The_user_navigates_to_the_Booking_site (){
    driver = DriverFactory.addbrowser(browsertype);
    driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
    driver.get(siteTested);
}
    @When("Chooses Destination: {} and picks dates")
   public void The_user_chooses_a_destination (String destination) {
   WebElement element = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
   element.sendKeys(destination);
   driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div")).click();
   driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[1]")).click();
   driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[3]/span")).click();
   driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")).click();

       System.out.println("Test is executing");
}

@And  ("He accesses a property from the list")
        public void clicks_on_a_property_from_the_list (){
        WebElement elem = driver.findElement(By.cssSelector("#search_results_table > div:nth-child(2) > div > div > div > div.d4924c9e74 > div:nth-child(3) > div.d20f4628d0 > div.b978843432 > div > div.a1b3f50dcd.b2fe1a41c3.a7c67ebfe5.d19ba76520.d14b211b4f > div.b1e6dd8416 > div > div:nth-child(1) > div > h3 > a"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
        elem.click();
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        subWindowHandler = null;
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        System.out.println("Still executing ");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String hotelname = driver.findElement(By.className("pp-header__title")).getText();

        System.out.println("Booked property: " + hotelname);
}
@And("Selects Room and clicks Reserve")
    public void choose_a_room ()
{WebElement elem12 = driver.findElement(By.id("hp_book_now_button"));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem12);
    elem12.submit();
    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    WebElement numberofRooms = driver.findElement(By.className("bui-form__control"));
    new Select(numberofRooms).selectByValue(room);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div[2]/section/div/header/div/div[2]/button/span")).click();

    }

@Then("The reservation page with the final price and hidden price Warning\\(if applicable) are displayed")
public void price_calculation (){
    WebElement price = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/aside/div/div[1]/div/section/div/div[2]/div/div/div/div[1]/div/div[2]"));
    String priceString = price.getText();
    System.out.println("Initial price" + priceString);

    WebElement hiddenprice = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/aside/div/div[1]/div/section/div/div[3]/div"));
    String hiddentext = hiddenprice.getText();


    Conversion convert = new Conversion();
    convert.conversion(hiddentext,priceString);
    System.out.println(hiddentext);

    }


//    @After()
//    public void teardown (){
//    driver.quit();
//    }



}
