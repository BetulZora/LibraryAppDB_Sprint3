@B28G5-158
Feature: Default

	#Scenario: verify the common book genre that’s being borrowed
	#    Given Establish the database connection
	#    When I execute query to find most popular book genre
	#    Then verify "Fantasy" is the most popular book genre.
	#
	#
	#select name from book_categories where id
	# = (select book_category_id from books where books.id
	# = (select book_id from (select book_id, count(*)
	#from book_borrow group by book_id order by 2 desc limit 1) popularBook));
	@B28G5-159 @db
	Scenario: US05AC01_BZ verify the common book genre that’s being borrowed
		Given Establish the database connection BZ
		    When I execute query to find most popular book genre BZ
		    Then verify "Fantasy" is the most popular book genre. BZ