
Feature: As a data consumer, I want to know genre of books are being borrowed the most
@wip @ui @db
  Scenario: verify the the common book genre that’s being borrowed BZ
    Given Establish the database connection BZ
    When I execute query to find most popular book genre BZ
    Then verify "Fantasy" is the most popular book genre. BZ