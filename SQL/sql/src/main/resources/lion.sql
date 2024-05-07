select current_user;

show tables;
drop table user_role;
drop table users;
drop table boards;
drop table roles;
## 문제 4: user, user_role, role, board 테이블을 제약 조건들을 적절히 이용해서 생성해 주세요.
drop table if exists users;
-- user table
create table users (
                       user_id int primary key auto_increment,
                       email varchar(255) not null,
                       name varchar(50) not null,
                       password varchar(500) not null,
                       regdate TIMESTAMP default (CURRENT_TIMESTAMP),
                       check (email like '%@%.%')
);

desc users;

-- user_role
drop table if exists user_role;

create table user_role (
                           user_role_id int primary key auto_increment,
                           user_id int,
                           role_id int,
                           foreign key (user_id) references users (user_id),
                           foreign key (role_id) references roles (role_id)
);

-- roles
drop table if exists roles;

create table roles (
                       role_id int primary key auto_increment,
                       role_name varchar(20)
);

-- board
drop table if exists boards;

create table boards (
                        board_id int primary key auto_increment,
                        title varchar(100) not null,
                        content text,
                        user_id int,
                        regdate TIMESTAMP default now(),
                        view_cnt int default 0,
                        foreign key (user_id) references users (user_id)
);

## 문제5 : 각 테이블에 적절한 샘플 데이터를 입력해 주세요.
insert into users(email,name,password) values ('user1@naver.com', 'user1', '1234');
insert into users(email,name,password) values ('user2@naver.com', 'user2', '5678');

insert into roles(role_name) values ('admin');
insert into roles(role_name) values ('member');

insert into user_role(user_id, role_id) values (1, 1); # 각각 'user1', 'admin' 해당
insert into user_role(user_id, role_id) values (2, 2); # 각각 'user2', 'member' 해당
insert into user_role(user_id, role_id) values (1,2); ## 각각 'user1', 'member' 해당

select * from users;
select * from roles;

select u.name, u.password, r.role_name ## 이 실행결과 밑에 사진으로 캡쳐해둠.!
from users u
    join user_role ur on (u.user_id = ur.user_id)
    join roles r on (ur.role_id = r.role_id);

insert into boards(title, content, user_id) values ('첫 게시글', '배고파..', 1);
insert into boards(title, content, user_id, view_cnt) values ('인기 게시글', '햅쌀와플 사진.jpg.. 존맛',2, 200);

select * from boards;

select u.name, b.title, b.content, b.view_cnt ## 역시 실행결과 사진 O
from users u
         join boards b on (u.user_id = b.user_id);