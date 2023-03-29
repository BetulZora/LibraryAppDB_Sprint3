package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class US01_StepDefs {
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        DB_Util.createConnection();
        //String allColumnsQuery = "select * from users";
        DB_Util.runQuery("select * from users");

    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedColumnNames) throws SQLException {
        System.out.println("expectedColumnNames = " + expectedColumnNames);


        ResultSet rs = DB_Util.runQuery("select * from users");
        ResultSetMetaData rsMetaData = rs.getMetaData();


        List<String> actualColumnNames = null;
        for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
            actualColumnNames = DB_Util.getAllColumnNamesAsList();
        }
        Assert.assertEquals(expectedColumnNames, actualColumnNames);
        System.out.println("actualColumnNames = " + actualColumnNames);

        DB_Util.destroy();
    }
}
