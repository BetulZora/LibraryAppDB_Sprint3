@B28G5-169
Feature: Default

	Background:
		#@B28G5-148
		  Given the "librarian" on the home page
		 
		
	@B28G5-168 @ui @db
	Scenario: US04AC01_VN verify book information with DB
		And the user navigates to "Books" page VN
		When the user searches for "Clean Code" book VN
		And the user clicks edit book button VN
		Then book information must match the Database VN