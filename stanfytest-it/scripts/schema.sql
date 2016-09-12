CREATE TABLE candidate
(
  id INTEGER auto_increment,
  firstname VARCHAR(50),
  lastname VARCHAR(50)
);

CREATE TABLE candidate_skill
(
  id INTEGER auto_increment,
  candidate_id INTEGER,
  skill_id INTEGER
);

CREATE TABLE skill
(
  id INTEGER auto_increment,
  name VARCHAR(50)
);