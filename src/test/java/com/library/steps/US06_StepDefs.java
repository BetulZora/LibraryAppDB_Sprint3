package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US06_StepDefs {

    BookPage bookPage = new BookPage();

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        bookPage.addBook.click();

    }

    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        bookPage.bookName.sendKeys(bookName);

    }


    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String ISBN) {
        bookPage.isbn.sendKeys(ISBN);

    }


    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String Year) {
        bookPage.year.sendKeys(Year);

    }

    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String Author) {
        bookPage.author.sendKeys(Author);

    }

    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {
        bookPage.categoryDropdown.sendKeys(bookCategory);
        BrowserUtil.waitFor(2);

    }

    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
        bookPage.saveChanges.click();
        BrowserUtil.waitFor(2);

    }

    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String popUpMessage) {
        BrowserUtil.waitFor(2);
        bookPage.toastMessage.getText().equals(popUpMessage);
        BrowserUtil.waitFor(5);

    }

    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String bookName) {
        //TODO: finish this step
        DB_Util.createConnection();
        DB_Util.runQuery("select name,isbn,year,author\n" +
                "from books\n" +
                "where name like '%"+bookName+"%'");
        String actualBookName = DB_Util.getRowDataAsList(1).get(1);
        System.out.println("actualBookName = " + actualBookName);

    }
}
