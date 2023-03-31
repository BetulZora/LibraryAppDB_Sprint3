package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;


public class US03_BZ_StepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();

    @Given("the {string} on the home page BZ")
    public void the_on_the_home_page_bz(String user) {
        loginPage.login(user);

    }

    @When("the user navigates to {string} page BZ")
    public void the_user_navigates_to_page_bz(String module) {
        dashBoardPage.navigateModule(module);

    }

    @When("the user clicks book categories BZ")
    public void the_user_clicks_book_categories_bz() {
        System.out.println("Dropdown categories are identified in the next step");

    }

    @Then("verify book categories must match book_categories table from db BZ")
    public void verify_book_categories_must_match_book_categories_table_from_db_bz() {
        List<String> actualBookCategories = bookPage.verifyCategoryDropdown();
        String query="select name from book_categories";
        DB_Util.runQuery(query);
        List<String> expectedBookCategories = DB_Util.getColumnDataAsList("name");
        System.out.println("expectedBookCategories = " + expectedBookCategories);

        // MAKE ASSERTIONS
        Assert.assertEquals(expectedBookCategories,actualBookCategories);

    }
}
