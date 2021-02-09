drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_id` int(11) NOT NULL AUTO_INCREMENT,
    `item_name` varchar(40) DEFAULT NULL,
    `item_value` DOUBLE(11,2) ,
    PRIMARY KEY(`item_id`) 
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `customer_id` INT(11) NOT NULL,
    `order_id` int(11) NOT NULL AUTO_INCREMENT,
    
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`customer_id`) REFERENCES customers(`id`) on delete cascade
);

CREATE TABLE IF NOT EXISTS `ims`.`ordersitems` (
    `order_id` INT(11) NOT NULL,
    `item_id` int(11) NOT NULL,
    `quantity` int(40) DEFAULT NULL,
    Foreign Key (`item_id`) REFERENCES  items(`item_id`) on delete cascade,
    FOREIGN KEY (`order_id`) REFERENCES orders(`order_id`)on delete cascade
);
