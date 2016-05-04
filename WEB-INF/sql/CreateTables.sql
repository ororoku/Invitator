DROP TABLE usertable CASCADE CONSTRAINTS;
DROP TABLE grouptable CASCADE CONSTRAINTS;
DROP TABLE post CASCADE CONSTRAINTS;
DROP TABLE matching CASCADE CONSTRAINTS;
DROP TABLE usergroup CASCADE CONSTRAINTS;

DROP SEQUENCE seq_post_id;
DROP SEQUENCE seq_matching_id;
DROP SEQUENCE seq_user_group_id;

commit;

create table usertable(
	user_id nchar(20),
	user_name nvarchar2(20),
	password nvarchar2(20),
	user_image nvarchar2(40),
	description nvarchar2(40),
	address nvarchar2(40),
	is_delete number(1),
	constraint pk_user primary key( user_id ),
	constraint ck_userflag CHECK (is_delete IN ('1', '0'))
);

create table grouptable(
	group_name nvarchar2(20) ,
	group_image nvarchar2(40),
	description nvarchar2(40),
	is_delete number(1),
	constraint pk_group primary key( group_name ),
	constraint ck_groupflag CHECK (is_delete IN ('1', '0'))
);

create table post(
	post_id nchar(5),
	user_id nchar(20),
	matching_id nchar(5),
	purpose number(1),
	time_start nchar(4),
	time_end nchar(4),
	is_delete number(1),
	create_time DATE DEFAULT SYSDATE,
	constraint pk_post primary key( post_id ),
	constraint ck_postflag CHECK (is_delete IN ('1', '0'))
);

create table matching(
	matching_id nchar(5),
	go_time nchar(4),
	purpose number(1),
	is_closed number(1),
	constraint pk_matching primary key( matching_id ),
	constraint ck_closedflag CHECK (is_closed IN ('1', '0'))
);

create table usergroup(
	user_group_id nchar(5),
	user_id nchar(20),
	group_name nvarchar2(20),
	is_ignore number(1),
	constraint pk_usergroup primary key( user_group_id ),
	constraint ck_ignoreflag CHECK (is_ignore IN ('1', '0'))
);

CREATE SEQUENCE seq_post_id
START with 4
INCREMENT BY 1
MINVALUE 4
MAXVALUE 99999
NOCYCLE
CACHE 10;

CREATE SEQUENCE seq_matching_id
START with 4
INCREMENT BY 1
MINVALUE 4
MAXVALUE 99999
NOCYCLE
CACHE 10;

CREATE SEQUENCE seq_user_group_id
START with 4
INCREMENT BY 1
MINVALUE 4
MAXVALUE 99999
NOCYCLE
CACHE 10;

commit;
