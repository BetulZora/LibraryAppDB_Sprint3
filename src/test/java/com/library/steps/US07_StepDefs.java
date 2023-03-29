package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US07_StepDefs {

    BookPage bookPage = new BookPage();

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        BrowserUtil.waitFor(2);
/*        bookPage.borrowBook("Self Confidence").click();
        BrowserUtil.waitFor(5);*/
        BrowserUtil.waitForClickablility(bookPage.borrowBook("Self Confidence"), 15);
        //TODO: Borrow book in not clickable
    }
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String BorrowingBooksPage) {


    }

    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }

}
