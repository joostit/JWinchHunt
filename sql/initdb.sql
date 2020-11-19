create database db_jwinchhunt; -- Creates the new database
create user 'winchhuntappuser'@'%' identified by 'TheWinchHuntDevPassWord'; -- Creates the user
grant all on db_jwinchhunt.* to 'winchhuntappuser'@'%'; -- Gives all privileges to the new user on the newly created database
