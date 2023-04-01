package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05_BZ_StepDefs {

    @Given("Establish the database connection BZ")
    public void establish_the_database_connection_bz() {
        // this step is completed in the Hooks

    }

    String mostPopularBookCategory;
    @When("I execute query to find most popular book genre BZ")
    public void i_execute_query_to_find_most_popular_book_genre_bz() {
        String query="select name from book_categories where id\n" +
                " = (select book_category_id from books where books.id\n" +
                " = (select book_id from (select book_id, count(*)\n" +
                "from book_borrow group by book_id order by 2 desc limit 1) popularBook))"; // 1855
        DB_Util.runQuery(query);

        mostPopularBookCategory = DB_Util.getFirstRowFirstColumn();
        System.out.println("mostPopularBookCategory = " + mostPopularBookCategory);


    }
    @Then("verify {string} is the most popular book genre. BZ")
    public void verify_is_the_most_popular_book_genre_bz(String expectedCategory) {
        System.out.println("mostPopularBookCategory = " + mostPopularBookCategory);
        System.out.println("expectedCategory = " + expectedCategory);
        Assert.assertEquals(expectedCategory,mostPopularBookCategory);

    }

}
