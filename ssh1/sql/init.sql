drop table t_user; 
create table t_user(
	t_id int not null auto_increment,
	t_name varchar(100),
	t_age int,
	t_address varchar(200), 
	primary key(t_id)
)