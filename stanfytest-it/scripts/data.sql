INSERT INTO candidate (id, firstname, lastname) VALUES (1, 'John', 'Travolta');
INSERT INTO candidate (id, firstname, lastname) VALUES (2, 'Brad', 'Pitt');
INSERT INTO candidate (id, firstname, lastname) VALUES (3, 'Leonardo', 'DiCaprio');

INSERT INTO skill (id, name) VALUES (1, 'html');
INSERT INTO skill (id, name) VALUES (2, 'css');
INSERT INTO skill (id, name) VALUES (3, 'javascript');
INSERT INTO skill (id, name) VALUES (4, 'java');
INSERT INTO skill (id, name) VALUES (5, 'android');
INSERT INTO skill (id, name) VALUES (6, 'spring');

INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (1, 1, 1);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (2, 1, 2);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (3, 1, 3);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (4, 2, 1);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (5, 2, 2);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (6, 2, 3);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (7, 2, 4);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (8, 2, 5);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (9, 3, 5);
INSERT INTO candidate_skill (id, candidate_id, skill_id) VALUES (10, 3, 6);