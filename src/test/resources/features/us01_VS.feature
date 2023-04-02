@B28G5-173
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection
  @us01 @db @smoke @VS @B28G5-170
  Scenario: US01AC01_VS verify users has unique IDs
    When Execute query to get all IDs from users
    Then verify all users has unique ID

  @us01 @db @smoke @VS @B28G5-172
  Scenario: US01AC02_VS verify users table columns
    When Execute query to get all columns VS
    Then verify the below columns are listed in result VS

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |