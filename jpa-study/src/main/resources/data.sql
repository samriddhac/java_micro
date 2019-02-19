insert into course(id,name,date_created,date_updated) 
values(10001, 'JPA Part 1', sysdate(), sysdate());
insert into course(id,name,date_created,date_updated) 
values(10002, 'JPA Part 2', sysdate(), sysdate());
insert into course(id,name,date_created,date_updated) 
values(10003, 'JPA Part 3', sysdate(), sysdate());
insert into course(id,name,date_created,date_updated) 
values(10004, 'JPA Part 4', sysdate(), sysdate());
insert into course(id,name,date_created,date_updated) 
values(10005, 'JPA Part 5', sysdate(), sysdate());
insert into course(id,name,date_created,date_updated) 
values(10006, 'JPA Part 6', sysdate(), sysdate());

insert into passport(id,number) 
values(30001, 'A12345');
insert into passport(id,number) 
values(30002, 'A12346');
insert into passport(id,number) 
values(30003, 'A12347');
insert into passport(id,number) 
values(30004, 'A12348');
insert into passport(id,number) 
values(30005, 'A12349');
insert into passport(id,number) 
values(30006, 'A12341');


insert into student(id,name,date_created,date_updated, passport_id) 
values(20001, 'Sam', sysdate(), sysdate(), 30001);
insert into student(id,name,date_created,date_updated, passport_id) 
values(20002, 'Ram', sysdate(), sysdate(), 30002);
insert into student(id,name,date_created,date_updated, passport_id) 
values(20003, 'John', sysdate(), sysdate(), 30003);
insert into student(id,name,date_created,date_updated, passport_id) 
values(20004, 'Mark', sysdate(), sysdate(), 30004);
insert into student(id,name,date_created,date_updated, passport_id) 
values(20005, 'Robin', sysdate(), sysdate(), 30005);
insert into student(id,name,date_created,date_updated, passport_id) 
values(20006, 'Stuart', sysdate(), sysdate(), 30006);

insert into review(id,rating,description,date_created,date_updated, course_id) 
values(40001, '5', 'Great', sysdate(), sysdate(), 10003);
insert into review(id,rating,description,date_created,date_updated, course_id) 
values(40002, '5', 'Great', sysdate(), sysdate(), 10003);
insert into review(id,rating,description,date_created,date_updated, course_id) 
values(40003, '5', 'Great', sysdate(), sysdate(), 10003);
insert into review(id,rating,description,date_created,date_updated, course_id) 
values(40004, '5', 'Great', sysdate(), sysdate(), 10004);
insert into review(id,rating,description,date_created,date_updated, course_id) 
values(40005, '5', 'Great', sysdate(), sysdate(), 10004);
insert into review(id,rating,description,date_created,date_updated, course_id) 
values(40006, '5', 'Great', sysdate(), sysdate(), 10004);