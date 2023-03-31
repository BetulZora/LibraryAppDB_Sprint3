package com.library.pages;

import com.library.utility.DB_Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class BorrowedBooksPage extends BasePage{


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;

    @FindBy(xpath = "//h2[@id='borrowed_books']")
    public WebElement borrowedBooksNumber;

}
