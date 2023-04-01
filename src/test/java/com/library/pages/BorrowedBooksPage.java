package com.library.pages;

import com.github.javafaker.Job;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class BorrowedBooksPage extends BasePage{


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;

    @FindBy(xpath = "//h2[@id='borrowed_books']")
    public WebElement borrowedBooksNumber;


    public void returnBook(String title){
        String locator = "//tr/td[text()='NOT RETURNED ']/" +
                "preceding-sibling::td[text()='" +title +"']" +
                "//preceding-sibling::a";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

}
