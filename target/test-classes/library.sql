
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

SELECT * FROM book_borrow;

SELECT name
FROM book_categories;

SELECT * FROM books;

select * from book_categories;

SELECT * FROM book_borrow;



select book_id, count(*) as popular_book_number
from book_borrow
group by book_id
order by popular_book_number desc;

select book_id, count(*) as borrowed_times
from book_borrow
group by book_id
order by borrowed_times desc
limit 1;

SELECT id,book_category_id, book_id, bb.book_id
FROM books JOIN book_borrow bb
on books.id = bb.book_id;

SELECT * FROM books
WHERE name LIKE '%Self Confidence%';

SELECT * FROM books
WHERE name LIKE '%Self Confidence%';

select name,isbn,year,author
from books
where name like '%Clean Code%';

SELECT * FROM book_borrow

select count(*) from book_borrow
where is_returned=0;

