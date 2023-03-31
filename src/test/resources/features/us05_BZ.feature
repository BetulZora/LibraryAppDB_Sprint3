@B28G5-158
Feature: As a data consumer, I want to know genre of books are being borrowed the most
  @B28G5-159 @db
  Scenario: US05AC01_BZ verify the common book genre that’s being borrowed
    Given Establish the database connection BZ
    When I execute query to find most popular book genre BZ
    Then verify "Fantasy" is the most popular book genre. BZ