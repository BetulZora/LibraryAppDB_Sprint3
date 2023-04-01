package com.library.steps;

import com.library.pages.*;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class BookStepDefsKA {
    LoginPage LoginPage;
    BookPage bookPage;
    BasePage basePage = new BasePage();
    String bookName;

    @Given("the {string} on the home page KA")
    public void the_on_the_home_page(String User) {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
        LoginPage=new LoginPage();
        LoginPage.login(User);
        BrowserUtil.waitFor(2);
    }
    @Given("the user navigates to {string} page KA")
    public void the_user_navigates_to_page(String module) {
//        bookPage = new BookPage();
//        bookPage.navigateModule(Module);
//        BrowserUtil.waitFor(2);
        basePage.navigateModule(module);
    }

    @When("the user clicks Borrow Book KA")
    public void the_user_clicks_borrow_book() {
        bookPage.isbnButton.click();
        BrowserUtil.waitFor(1);

        BrowserUtil.waitForClickablility(bookPage.borrowBook(bookName),5 ).click();
        BrowserUtil.waitFor(2);
    }
    @And("the user searches book name called {string}")
    public void theUserSearchesBookNameCalled(String Name) {
        bookName = Name;
        bookPage = new BookPage();
        bookPage.search.sendKeys(bookName);
BrowserUtil.waitFor(2);
    }
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String Borrowing) {
        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
        new DashBoardPage().navigateModule(Borrowing);
        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));
    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        String query = "select name from books b\n" +
                "join book_borrow bb on b.id = bb.book_id\n" +
                "join users u on bb.user_id = u.id\n" +
                "where name = '"+bookName+"' and full_name = 'Test Student 5'";

        DB_Util.runQuery(query);
        List<String> actualList = DB_Util.getColumnDataAsList(1);
        Assert.assertTrue(actualList.contains(bookName));

    }

}
