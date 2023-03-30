
-- US 01
select count(id) from users; --
-- 1855

select count(distinct id) from users;
-- 1855


-- RESULT --> MANUALLY IT IS PASSED


-- US 02
select * from users;



-- US 03
select count(*) from book_borrow
where is_returned=0;

-- US 05
-- Query for most popular book category
select name from book_categories where id
 = (select book_category_id from books where books.id
 = (select book_id from (select book_id, count(*)
from book_borrow group by book_id order by 2 desc limit 1) popularBook));

