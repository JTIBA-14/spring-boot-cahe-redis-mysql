-- liquibase formatted sql

-- changeset JTibaduisa:1
create table projects(
	id int primary key auto_increment not null,
    name varchar(150) not null,
    priority tinyint(1) not null,
    description text null,
    deliverydate date not null
);

INSERT INTO projects(id, name, priority, description, deliverydate) VALUES
( 1, "Redis", 1, "Ejemplo de descripción de Redis", "2020-08-28"),
( 2, "Elasticsearch", 2, "Ejemplo de descripción de Elasticsearch", "2020-09-01"),
( 3, "Grafana", 3, "Ejemplo de descripción de Grafana", "2020-09-28");
