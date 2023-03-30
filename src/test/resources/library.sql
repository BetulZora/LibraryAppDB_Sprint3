
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


-- US 06
select * from books;

select b.name, author, bc.name from books b inner join
    book_categories bc on b.book_category_id = bc.id
where b.name = 'Clean code';

 SELECT name, author, isbn from books
where name = 'Head First Java';
