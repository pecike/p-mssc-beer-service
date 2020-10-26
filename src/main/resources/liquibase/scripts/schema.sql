--liquibase formatted sql
--changeset Peter Cirbes:0

CREATE TABLE `beer` (
  `id` char(36) NOT NULL,
  `beer_name` varchar(255) DEFAULT NULL,
  `beer_style` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `min_on_hand` int(11) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `quantity_to_brew` int(11) DEFAULT NULL,
  `upc` bigint(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_p9mb364xktkjqmprmg89u2etr` (`upc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8