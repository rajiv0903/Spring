
insert into users(username, password, enabled) 
values ('rajiv', 'secret', true);

select * from users;

insert into authorities (username, authority)
values ('rajiv', 'ROLE_USER');

insert into authorities (username, authority)
values ('rajiv', 'ROLE_ADMIN');

select * from authorities;


insert into users(username, password, enabled) 
values ('tithi', 'secret', true);

select * from users;

insert into authorities (username, authority)
values ('tithi', 'ROLE_ADMIN');

insert into authorities (username, authority)
values ('tithi', 'ROLE_USER');

select * from authorities;

update users set password ='5ebe2294ecd0e0f08eab7690d2a6ee69' where
 username in ('rajiv', 'tithi');
 
update users set password ='$2a$10$zoCGp/t7tZ1aXb7xAmuLW.3Nxl99H8IBP0/i2t.z.u5KkYZ6ykTp2' where
 username in ('rajiv', 'tithi');
 
insert into users(username, password, enabled) 
values ('bubai', '$2a$10$zoCGp/t7tZ1aXb7xAmuLW.3Nxl99H8IBP0/i2t.z.u5KkYZ6ykTp2', true);

select * from users;

insert into authorities (username, authority)
values ('bubai', 'ROLE_BAD');

#Permission 
insert into permissions (username, target, permission)
values ('rajiv', 'com.practice.spring.springmvcsecurity.model.Goal', 'createGoal');

select * from permissions;

delete from permissions where username='rajiv';