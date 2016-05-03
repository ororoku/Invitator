DROP TABLE usertable CASCADE CONSTRAINTS;
DROP TABLE grouptable CASCADE CONSTRAINTS;
DROP TABLE post CASCADE CONSTRAINTS;
DROP TABLE matching CASCADE CONSTRAINTS;
DROP TABLE usergroup CASCADE CONSTRAINTS;

commit;

create table usertable(
	user_id nchar(20),
	user_name nvarchar2(20),
	password nvarchar2(20),
	user_image nvarchar2(40),
	description nvarchar2(40),
	address nvarchar2(40),
	is_delete number(1),
	constraint pk_user primary key( user_id )
);

create table grouptable(
	group_name nvarchar2(20) ,
	group_image nvarchar2(40),
	description nvarchar2(40),
	is_delete number(1),
	constraint pk_group primary key( group_name )
);

create table post(
	post_id number(8),
	user_id nchar(20),
	matching_id number(8),
	purpose number(1),
	time_start number(4),
	time_end number(4),
	is_delete number(1),
	create_time DATE DEFAULT SYSDATE,
	constraint pk_post primary key( post_id )
);

create table matching(
	matching_id number(8),
	go_time number(4),
	purpose number(1),
	is_closed number(1),
	constraint pk_matching primary key( matching_id )
);

create table usergroup(
	user_group_id number(8),
	user_id nchar(20),
	group_name nvarchar2(20),
	is_ignore number(1),
	constraint pk_usergroup primary key( user_group_id )
);

