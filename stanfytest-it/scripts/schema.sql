CREATE TABLE candidate
(
  id INTEGER NOT NULL,
  firstname VARCHAR(50),
  lastname VARCHAR(50)
);
CREATE SEQUENCE candidate_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE candidate_skill
(
  id INTEGER NOT NULL,
  candidate_id INTEGER,
  skill_id INTEGER
);
CREATE SEQUENCE candidate_skill_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE skill
(
  id INTEGER NOT NULL,
  name VARCHAR(50)
);
CREATE SEQUENCE skill_id_seq START WITH 1 INCREMENT BY 1;