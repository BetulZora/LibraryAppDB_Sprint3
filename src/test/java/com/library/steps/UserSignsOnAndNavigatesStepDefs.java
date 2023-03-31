package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserSignsOnAndNavigatesStepDefs {

    /**
     * US02, 03, 04, 06, 07
     * type as string "librarian" or "student"
     */
    //@Given("the {string} on the home page")
    //public void the_on_the_home_page(String string) {

    //}

    LoginPage loginPage;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        loginPage = new LoginPage();
        loginPage.login(librarian);
    }


    /**
     * US03, 04, 06, 07
     * user type as string "librarian" or "student"
     */

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String string) {
        WebElement booksPage = Driver.getDriver().findElement(By.linkText("Books"));
        booksPage.click();
    }


}