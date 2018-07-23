-- DROP DATABASE IF EXISTS `xy_db`;
-- CREATE DATABASE IF NOT EXISTS `xy_db`;
-- USE `xy_db`;

DROP TABLE IF EXISTS `xy_db`.`order_detail`,
					 `xy_db`.`order`,
                     `xy_db`.`client`,
                     `xy_db`.`product`,
					 `xy_db`.`category`;


CREATE  TABLE IF NOT EXISTS `xy_db`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `status` BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) 
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE IF NOT EXISTS `xy_db`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(30) NOT NULL ,
  `status` BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) 
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE IF NOT EXISTS `xy_db`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(500) NULL ,
  `price` decimal(10, 2) NOT NULL,
  `status` BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`), 
  CONSTRAINT `fk_product_category` 
	FOREIGN KEY (`category_id` )
    REFERENCES `xy_db`.`category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE IF NOT EXISTS `xy_db`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `client_id` INT NOT NULL ,
  `order_date` DATETIME NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_order_client` 
	FOREIGN KEY (`client_id` )
    REFERENCES `xy_db`.`client` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE IF NOT EXISTS `xy_db`.`order_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL ,
  `product_id` INT NOT NULL ,
  `quantity` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_order_detail_order`
    FOREIGN KEY (`order_id` )
    REFERENCES `xy_db`.`order` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_product`
    FOREIGN KEY (`product_id` )
    REFERENCES `xy_db`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- USE `xy_db`;