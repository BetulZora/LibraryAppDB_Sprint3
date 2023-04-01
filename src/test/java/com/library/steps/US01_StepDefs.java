package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class US01_StepDefs {

    // declare user count variable here so you can use it in all methods
    String actualUserCount;

    @When("Execute query to get all IDs from users VN")
    public void execute_query_to_get_all_i_ds_from_users_vn() {

        DB_Util.runQuery("select count(id) from users");
        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);

    }
    @Then("verify all users has unique ID VN")
    public void verify_all_users_has_unique_id_vn() {

        DB_Util.runQuery("select count(distinct id) from users");
        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);

        Assert.assertEquals(expectedUserCount, actualUserCount);

    }


    // declare List of columns here so you can use it in other methods
    List<String> actualListOfColumns;
    @When("Execute query to get all columns VN")
    public void execute_query_to_get_all_columns_vn() {

        DB_Util.runQuery("select * from users");
        actualListOfColumns = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualUserCount = " + actualListOfColumns);

    }
    @Then("verify the below columns are listed in result VN")
    public void verify_the_below_columns_are_listed_in_result_vn(List<String> expectedListOfColumns) {

        System.out.println("expectedListOfColumns = " + expectedListOfColumns);
        Assert.assertEquals(expectedListOfColumns, actualListOfColumns);

    }


}
