CREATE TABLE IF NOT EXISTS cfg_routine (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"name" text not null CHECK(typeof("name") = "text" AND length("name") <= 30),
	"creation_dtm" datetime not null,
	"modification_dtm" datetime not null,
	"description" text CHECK(typeof("description") = "text" AND length("description") <= 2000)
);

CREATE TABLE IF NOT EXISTS cfg_exercise (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"name" text not null CHECK(typeof("name") = "text" AND length("name") <= 30),
	"description" text CHECK(typeof("description") = "text" AND length("description") <= 2000)
);

CREATE TABLE IF NOT EXISTS cfg_set (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"routine_id" INTEGER NOT NULL,
	"order" INTEGER NOT NULL CHECK("order" > 0), 
	"reps" INTEGER NOT NULL CHECK("reps" > 0),
	FOREIGN KEY("routine_id") REFERENCES cfg_routine("id")
);

CREATE TABLE IF NOT EXISTS cfg_subset (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"set_id" INTEGER NOT NULL,
	"order" INTEGER NOT NULL CHECK("order" > 0),
	FOREIGN KEY("set_id") REFERENCES cfg_set("id")
);

CREATE TABLE IF NOT EXISTS cfg_set_exercise (
	"set_id" INTEGER NOT NULL,
	"exercise_id" INTEGER NOT NULL,
	FOREIGN KEY("set_id") REFERENCES cfg_set("id"),
	FOREIGN KEY("exercise_id") REFERENCES cfg_exercise("id"),
	PRIMARY KEY("set_id", "exercise_id")
);

CREATE TABLE IF NOT EXISTS cfg_subset_exercise (
	"subset_id" INTEGER NOT NULL,
	"exercise_id" INTEGER NOT NULL,
	FOREIGN KEY("subset_id") REFERENCES cfg_subset("id"),
	FOREIGN KEY("exercise_id") REFERENCES cfg_exercise("id"),
	PRIMARY KEY("subset_id", "exercise_id")
);

CREATE TABLE IF NOT EXISTS cfg_set_exercise_rep (
	"exercise_id" INTEGER NOT NULL,
	"set_id" INTEGER NOT NULL,
	"order" INTEGER NOT NULL CHECK("order" > 0),
	"count" INTEGER NOT NULL CHECK("count" > 0),
	FOREIGN KEY("exercise_id", "set_id") REFERENCES cfg_set_exercise("exercise_id", "set_id"),
	PRIMARY KEY("set_id", "exercise_id", "order")
);

CREATE TABLE IF NOT EXISTS cfg_subset_exercise_rep (
	"exercise_id" INTEGER NOT NULL,
	"subset_id" INTEGER NOT NULL,
	"order" INTEGER NOT NULL CHECK("order" > 0),
	"count" INTEGER NOT NULL CHECK("count" > 0),
	FOREIGN KEY("exercise_id", "subset_id") REFERENCES cfg_subset_exercise("exercise_id", "subset_id"),
	PRIMARY KEY("exercise_id", "subset_id", "order")
);
