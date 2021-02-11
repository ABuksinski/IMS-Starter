INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (`item_name`, `item_value`) VALUES ('cup', 20.0);
INSERT INTO `orders`(`customer_id`) VALUES (1);
INSERT INTO `ordersitems`(`order_id`,`item_id`,`quantity`) VALUES (1,1,10);