insert into usertable values ('C0002', '��^�܂��Ђ�', 'password', 'test', 'test', 'masahiro.oroku@gmail.com',0);
insert into usertable values ('rrrr2', '��^�܂���', 'password', 'test', 'test', 'masahiro.oroku2@gmail.com',0);
insert into usertable values ('rrrr', '��^�܂���', 'password', 'test', 'test', 'masahiro.oroku2@gmail.com',0);
insert into usertable values ('1111', '��^�܂�', 'password', 'test', 'test', 'masahiro.oroku3@gmail.com',0);
insert into usertable values ('aaaa', '��^', 'password', 'test', 'test', 'masahiro.oroku4@gmail.com',0);

insert into grouptable values ('JAVAJAVA���h','url','�����ō��h�����Ă��܂�',0);
insert into grouptable values ('JAVAJAVA���h2','url','����2�ō��h�����Ă��܂�',0);
insert into grouptable values ('JAVAJAVA���h3','url','����3�ō��h�����Ă��܂�',1);

insert into post values ('00001','aaaa','00001',1,'1800','2000',0,'');
insert into post values ('00002','1111','00002',1,'1800','2000',0,'');
insert into post values ('00003','rrrr','00002',1,'1900','2100',0,'');

insert into matching values ('00001','1900',1,0);
insert into matching values ('00002','1930',0,1);
insert into matching values ('00003','1930',0,1);

insert into usergroup values ('00001','C0002','JAVAJAVA���h',0);
insert into usergroup values ('00002','rrrr','JAVAJAVA���h2',1);
insert into usergroup values ('00003','rrrr','JAVAJAVA���h3',1);

commit;
