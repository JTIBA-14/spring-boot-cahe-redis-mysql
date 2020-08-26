-- liquibase formatted sql

-- changeset JTibaduisa:1
create table location(
	id SERIAL primary KEY,
    name text not null,
    area_m2 int,
    location_id int,
    constraint fk1_location FOREIGN KEY (location_id) references location (id)
);
