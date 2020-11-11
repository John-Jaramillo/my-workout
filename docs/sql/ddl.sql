CREATE TABLE IF NOT EXISTS `Exercise`
(
    `exercise_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`        TEXT                              NOT NULL,
    `description` TEXT                              NOT NULL
);

CREATE TABLE IF NOT EXISTS `ExerciseMuscle`
(
    `exercise_muscle_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `exercise_id`        INTEGER                           NOT NULL,
    `muscle_id`          INTEGER                           NOT NULL,
    `primary`            INTEGER                           NOT NULL,
    FOREIGN KEY (`exercise_id`) REFERENCES `Exercise` (`exercise_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`muscle_id`) REFERENCES `Muscle` (`muscle_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_ExerciseMuscle_exercise_id` ON `ExerciseMuscle` (`exercise_id`);

CREATE INDEX IF NOT EXISTS `index_ExerciseMuscle_muscle_id` ON `ExerciseMuscle` (`muscle_id`);

CREATE TABLE IF NOT EXISTS `Muscle`
(
    `muscle_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL,
    `area`      INTEGER                           NOT NULL
);

CREATE INDEX IF NOT EXISTS `index_Muscle_area` ON `Muscle` (`area`);

CREATE TABLE IF NOT EXISTS `Progress`
(
    `progress_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`     INTEGER                           NOT NULL,
    `exercise_id` INTEGER                           NOT NULL,
    `date`        INTEGER,
    `set`         INTEGER                           NOT NULL,
    `repititions` INTEGER                           NOT NULL,
    `weight`      INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`exercise_id`) REFERENCES `Exercise` (`exercise_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Progress_user_id` ON `Progress` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_Progress_exercise_id` ON `Progress` (`exercise_id`);

CREATE INDEX IF NOT EXISTS `index_Progress_date` ON `Progress` (`date`);

CREATE TABLE IF NOT EXISTS `Routine`
(
    `routine_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`     INTEGER                           NOT NULL,
    `exercise_id` INTEGER                           NOT NULL,
    `day`         INTEGER                           NOT NULL,
    `order`       INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`exercise_id`) REFERENCES `Exercise` (`exercise_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Routine_user_id` ON `Routine` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_Routine_exercise_id` ON `Routine` (`exercise_id`);

CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL,
    `oauth_key` TEXT                              NOT NULL,
    `height`    INTEGER
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_User_oauth_key` ON `User` (`oauth_key`);

CREATE TABLE IF NOT EXISTS `Weight`
(
    `weight_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`   INTEGER                           NOT NULL,
    `weight`    INTEGER                           NOT NULL,
    `date`      INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Weight_user_id` ON `Weight` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_Weight_date` ON `Weight` (`date`);
