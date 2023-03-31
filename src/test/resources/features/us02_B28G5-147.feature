@B28G5-147
Feature: Default


	@B28G5-146 @ui @db
	Scenario: US02 AC01 As a librarian, I want to know borrowed books number
		Given the "librarian" on the home page DB
		    When the librarian gets borrowed books number DB
		    Then borrowed books number information must match with DB DB