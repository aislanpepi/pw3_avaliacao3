alter table repair add active tinyint;

update repair set active = 1;