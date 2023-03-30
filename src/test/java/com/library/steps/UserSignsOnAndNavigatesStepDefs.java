package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSignsOnAndNavigatesStepDefs {

    /**
     * US02, 03, 04, 06, 07
     *type as string "librarian" or "student"
     */
    LoginPage loginPage = new LoginPage();

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        loginPage.login(librarian);

    }

    /**
     * US03, 04, 06, 07
     * user type as string "librarian" or "student"
     */
    // BasePage basePage = new BasePage();



}


