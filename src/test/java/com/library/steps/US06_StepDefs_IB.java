package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.Map;

public class US06_StepDefs_IB {

    BookPage bookPage = new BookPage();

    @And("the user navigates  to {string} page IB")
    public void theUserNavigatesToPage(String moduleName) {
        bookPage.navigateModule(moduleName);
        BrowserUtil.waitFor(1);
    }
    @When("the librarian click to add book IB")
    public void theLibrarianClickToAddBook() {
        bookPage.addBook.click();
    }

    @And("the librarian enter book name {string} IB")
    public void theLibrarianEnterBookName(String bookName) {
        bookPage.bookName.sendKeys(bookName);
    }

    @When("the librarian enter ISBN {string} IB")
    public void theLibrarianEnterISBN(String isbn) {
        bookPage.isbn.sendKeys(isbn);
    }

    @And("the librarian enter year {string} IB")
    public void theLibrarianEnterYear(String bookYear) {
        bookPage.year.sendKeys(bookYear);
    }

    @When("the librarian enter author {string} IB")
    public void theLibrarianEnterAuthor(String bookAuthor) {
        bookPage.author.sendKeys(bookAuthor);
    }

    @And("the librarian choose the book category {string} IB")
    public void theLibrarianChooseTheBookCategory(String category) {
        BrowserUtil.selectOptionDropdown( bookPage.categoryDropdown,category);
    }

    @And("the librarian click to save changes IB")
    public void theLibrarianClickToSaveChanges() {
        bookPage.saveChanges.click();
    }

    @Then("verify {string} message is displayed IB")
    public void verifyMessageIsDisplayed(String arg0 ) {
        Assert.assertTrue(bookPage.toastMessage.isDisplayed());

    }

    @And("verify {string} information must match with DB IB")
    public void verifyInformationMustMatchWithDB(String expectedBookName) {
        String query = "SELECT name, author, isbn from books\n" +
                "where name = '"+expectedBookName+"'";

        DB_Util.runQuery(query);

        Map<String, String> rawMap = DB_Util.getRowMap(1);

        String actualBookName = rawMap.get("name");

        Assert.assertEquals(expectedBookName, actualBookName);

    }

}
