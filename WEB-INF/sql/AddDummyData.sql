insert into usertable values ('C0002', '大録まさひろ', 'password', 'test', 'test', 'masahiro.oroku@gmail.com',0);
insert into usertable values ('rrrr2', '大録まさひ', 'password', 'test', 'test', 'masahiro.oroku2@gmail.com',0);
insert into usertable values ('rrrr', '大録まさひ', 'password', 'test', 'test', 'masahiro.oroku2@gmail.com',0);
insert into usertable values ('1111', '大録まさ', 'password', 'test', 'test', 'masahiro.oroku3@gmail.com',0);
insert into usertable values ('aaaa', '大録', 'password', 'test', 'test', 'masahiro.oroku4@gmail.com',0);

insert into grouptable values ('JAVAJAVA合宿','url','幕張で合宿をしています',0);
insert into grouptable values ('JAVAJAVA合宿2','url','幕張2で合宿をしています',0);
insert into grouptable values ('JAVAJAVA合宿3','url','幕張3で合宿をしています',1);

insert into post values ('00001','aaaa','00001',1,'1800','2000',0,'');
insert into post values ('00002','1111','00002',1,'1800','2000',0,'');
insert into post values ('00003','rrrr','00002',1,'1900','2100',0,'');

insert into matching values ('00001','1900',1,0);
insert into matching values ('00002','1930',0,1);
insert into matching values ('00003','1930',0,1);

insert into usergroup values ('00001','C0002','JAVAJAVA合宿',0);
insert into usergroup values ('00002','rrrr','JAVAJAVA合宿2',1);
insert into usergroup values ('00003','rrrr','JAVAJAVA合宿3',1);

commit;
