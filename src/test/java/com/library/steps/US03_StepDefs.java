package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_StepDefs {

    BasePage basePage = new BasePage();
    BookPage bookPage = new BookPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String page) {
        basePage.navigateModule(page);
        BrowserUtil.waitFor(3);

    }


    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {

        List<String> actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0); //remove the first option which is ALL

    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        List<String> actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0); //remove the first option which is ALL
        System.out.println("actualCategoryList = " + actualCategoryList);

        DB_Util.createConnection();
        DB_Util.runQuery("SELECT name FROM book_categories");
        List<String> expectedCategoryList = DB_Util.getColumnDataAsList(1);
        System.out.println("expectedCategoryList = " + expectedCategoryList);
        Assert.assertEquals(expectedCategoryList, actualCategoryList);
        DB_Util.destroy();

    }

}
