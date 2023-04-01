package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class US04_StepDefs {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    String bookName;

    @Given("the {string} on the home page MG")
    public void the_on_the_home_page_mg(String user) {
        loginPage.login(user);
    }
    @Given("the user navigates to {string} page MG")
    public void the_user_navigates_to_page_mg(String modouleName) {
        new DashBoardPage().navigateModule(modouleName);
    }
    @When("the user searches for {string} book MG")
    public void the_user_searches_for_book_mg(String bookName) {
        bookPage.search.sendKeys(bookName);
        this.bookName = bookName;
    }
    @When("the user clicks edit book button MG")
    public void the_user_clicks_edit_book_button_mg() {
        bookPage.editBook(bookName).click();
    }
    @Then("book information must match the Database MG")
    public void book_information_must_match_the_database_mg() {
        String actualBookName = bookPage.bookName.getAttribute("value");

        String actualAuthorName = bookPage.author.getAttribute("value");

        String actualISBN = bookPage.isbn.getAttribute("value");

        String actualYear = bookPage.year.getAttribute("value");

        String actualCategory = bookPage.categoryDropdown.getAttribute("value");

        String actualDescription= bookPage.description.getAttribute("value");

        String query = "select name, isbn, year, author,book_category_id,description from books where id = 3809";

        BrowserUtil.waitFor(3);

        DB_Util.runQuery(query);
        Map<String, String> bookInfo = DB_Util.getRowMap(1);

        String expectedBookName = bookInfo.get("name");
        String expectedAuthorName = bookInfo.get("author");
        String expectedISBN = bookInfo.get("isbn");
        String expectedYear = bookInfo.get("year");
        String expectedBookCategoryID = bookInfo.get("book_category_id");
        String expectedDescription = bookInfo.get("description");


        BrowserUtil.waitFor(3);

        Assert.assertEquals(actualBookName,expectedBookName);

        Assert.assertEquals(actualAuthorName,expectedAuthorName);

        Assert.assertEquals(actualISBN,expectedISBN);

        Assert.assertEquals(actualYear,expectedYear);

        Assert.assertEquals(expectedBookCategoryID,actualCategory);

        Assert.assertEquals(actualDescription,expectedDescription);




    }

}