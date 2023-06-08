create table tbtask(
	id int GENERATED ALWAYS AS IDENTITY primary key,
	text varchar(255) not null,
	category varchar(100) not null,
	is_completed numeric(1) default 0
);