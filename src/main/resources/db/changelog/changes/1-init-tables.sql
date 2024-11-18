--liquibase formatted sql
--changeset ihorshein:init-tables
CREATE TABLE todo (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) NULL,
  `due_date` DATETIME NOT NULL,
  `priority` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `created_date` TIMESTAMP NOT NULL,
  `updated_date` TIMESTAMP NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL DEFAULT 1,
  `is_delete` BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE task_history (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `todo_id` BIGINT UNSIGNED NOT NULL,
  `old_state` TEXT NULL,
  `new_state` TEXT NULL,
  `change_date` TIMESTAMP NOT NULL,
  `changed_by` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

 ALTER TABLE task_history
 ADD INDEX `fk_todo_id_idx` (`todo_id` ASC) VISIBLE;

 ALTER TABLE task_history
 ADD CONSTRAINT `fk_todo_id_idx`
   FOREIGN KEY (`todo_id`)
   REFERENCES todo (`id`)
   ON DELETE CASCADE
   ON UPDATE CASCADE;

--rollback DROP TABLE todo;
--rollback DROP TABLE task_history;
