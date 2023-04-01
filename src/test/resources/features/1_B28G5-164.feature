@B28G5-167
Feature: Default

	Background:
		#@B28G5-164
		Given Establish the database connection
		

	@B28G5-165 @db
	Scenario: US01AC01_VN verify users has unique IDs
		When Execute query to get all IDs from users VN
		Then verify all users has unique ID VN


	@B28G5-166 @db
	Scenario: US01AC02_VN verify users table columns
		When Execute query to get all columns VN
		Then verify the below columns are listed in result VN
		
		      | id |
		      | full_name |
		      | email |
		      | password |
		      | user_group_id |
		      | image |
		      | extra_data |
		      | status |
		      | is_admin |
		      | start_date |
		      | end_date |
		      | address |
