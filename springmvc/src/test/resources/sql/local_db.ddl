create table `USER` (
	`id` int(11) primary key auto_increment,
	`name` varchar(255) not null,
	`address` varchar(255) not null,
	`age` int(11) not null,
	`gender` varchar(255),
	`status` varchar(5),
	`create_ts` datetime,
	`create_userid` int(11),
	`update_ts` datetime,
	`update_userid` int(11)
);