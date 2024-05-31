show tables;

select * from jpa_customer;
select * from jpa_order;

drop table jpa_user;

select * from jpa_user;

insert into jpa_user (email, name) VALUES ('hong@example.com', '홍길동');
insert into jpa_user (email, name) VALUES ('kim@example.com', '김철수');
insert into jpa_user (email, name) VALUES ('lee@example.com', '이영희');
insert into jpa_user (email, name) VALUES ('park@example.com', '박민수');
insert into jpa_user (email, name) VALUES ('choi@example.com', '최지현');
insert into jpa_user (email, name) VALUES ('jung@example.com', '정수현');
