BEGIN;

CREATE TABLE IF NOT EXISTS project(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name TEXT NOT NULL,
    area_m2 INT,
    location_id INT
);

DELETE FROM project;

INSERT INTO project (id, name, area_m2, location_id ) VALUES
('1', 'Contabilidad', 24, null),
('2', 'Digital', 100, null),
('3', 'DevOps', 5, 2);



COMMIT;