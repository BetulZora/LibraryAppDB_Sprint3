
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

select book_id, planned_return_date, returned_date, is_returned from book_borrow;

select book_id from book_borrow where is_returned=0;

select * from book_categories;
select book_category_id from books where id=912;

select bc.name, count(*) from book_borrow bb inner join books b on b.id = bb.book_id
                                             inner join book_categories bc on b.book_category_id = bc.id
group by bc.name
order by count(*) desc ;


-- Query for most popular book catergory

select name from book_categories where id
 = (select book_category_id from books where books.id
 = (select book_id from (select book_id, count(*)
from book_borrow group by book_id order by 2 desc limit 1) popularBook));

