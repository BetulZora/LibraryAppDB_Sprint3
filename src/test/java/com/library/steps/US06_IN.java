package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class US06_IN {

    BookPage bookPage = new BookPage();

    @When("the librarian click to add book_IN")
    public void the_librarian_click_to_add_book_in() {
        bookPage.addBook.click();
    }

    @When("the librarian enter book name {string}_IN")
    public void the_librarian_enter_book_name__in(String name) {
        bookPage.bookName.sendKeys(name);
    }

    @When("the librarian enter ISBN {string}_IN")
    public void the_librarian_enter_isbn__in(String isbn) {
        bookPage.isbn.sendKeys(isbn);
    }

    @When("the librarian enter year {string}_IN")
    public void the_librarian_enter_year__in(String year) {
        bookPage.year.sendKeys(year);
    }

    @When("the librarian enter author {string}_IN")
    public void the_librarian_enter_author__in(String author) {
        bookPage.author.sendKeys(author);
    }

    @When("the librarian choose the book category {string}_IN")
    public void the_librarian_choose_the_book_category__in(String category) {
        BrowserUtil.selectOptionDropdown(bookPage.categoryDropdown, category);
    }

    @When("the librarian click to save changes_IN")
    public void the_librarian_click_to_save_changes_in() {
        bookPage.saveChanges.click();
    }

    @Then("verify {string} message is displayed_IN")
    public void verify_message_is_displayed_in(String string) {
        Assert.assertTrue(bookPage.toastMessage.isDisplayed());
    }

    @Then("verify {string} information must match with DB_IN")
    public void verify_information_must_match_with_db_in(String expectedBookName) {
        String query = "select name, author, isbn from books\n" +
                "where name= '"+expectedBookName+"'";

        DB_Util.runQuery(query);
        Map<String, String> rowMap = DB_Util.getRowMap(1);

        String actualBookName = rowMap.get("name");
        Assert.assertEquals(expectedBookName, actualBookName);

    }

}
