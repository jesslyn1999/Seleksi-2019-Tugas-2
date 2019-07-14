CREATE TABLE IF NOT EXISTS `news_source` (
    `id` VARCHAR(255),
    `name` VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    PRIMARY KEY (name)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `news_article` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `source_name` VARCHAR(255),
    `author` VARCHAR(255),
    `title` VARCHAR(255),
    `description` VARCHAR(1000),
    `url` VARCHAR(1000),
    `url_to_image` VARCHAR(1000),
    `published_at` VARCHAR(1000),
    `content` VARCHAR(1000),
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (source_name) REFERENCES news_source(name) ON UPDATE CASCADE ON DELETE CASCADE
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE utf8mb4_unicode_ci;
