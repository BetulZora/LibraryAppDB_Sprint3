package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_StepDefs_VS {
    List<String> actualListOfColumns;

    @When("Execute query to get all columns VS")
    public void execute_query_to_get_all_columns_vs() {
        DB_Util.runQuery("select * from users");
        actualListOfColumns = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualUserCount = " + actualListOfColumns);
    }
    @Then("verify the below columns are listed in result VS")
    public void verify_the_below_columns_are_listed_in_result_vs(List<String> expectedListOfColumns) {
        System.out.println("expectedListOfColumns = " + expectedListOfColumns);
        Assert.assertEquals(expectedListOfColumns, actualListOfColumns);
    }
}
