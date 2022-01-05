insert into product_group (id, name, description, is_physical) values (1, 'Clothes', 'Clothes Category', true);
insert into product_group (id, name, description, is_physical) values (2, 'Shoes', 'Shoes Category', true);
insert into product_group (id, name, description, is_physical) values (3, 'Book', 'Book Category', true);
insert into product_group (id, name, description, is_physical) values (4, 'Ebook', 'Ebook Category', false);
insert into product_group (id, name, description, is_physical) values (5, 'Video', 'Video Category', true);
/******************************************************************************************************************************/
insert into product_sub_group (id, name, description, product_group_id) values (1, 'Dress', 'Kinds of Dresses', 1);
insert into product_sub_group (id, name, description, product_group_id) values (2, 'Jean', 'Kinds of Jeans', 1);
insert into product_sub_group (id, name, description, product_group_id) values (3, 'Skirt', 'Kinds of Skirts', 1);
insert into product_sub_group (id, name, description, product_group_id) values (4, 'Suit', 'Kinds of Suits', 1);
insert into product_sub_group (id, name, description, product_group_id) values (5, 'T-shirt', 'Kinds of T-shirts', 1);

insert into product_sub_group (id, name, description, product_group_id) values (6, 'Boots', 'Kinds of Boots', 2);
insert into product_sub_group (id, name, description, product_group_id) values (7, 'Sandals', 'Kinds of Sandals', 2);
insert into product_sub_group (id, name, description, product_group_id) values (8, 'Casual', 'Kinds of Casuals', 2);
insert into product_sub_group (id, name, description, product_group_id) values (9, 'Sneakers', 'Kinds of Sneakers', 2);

insert into product_sub_group (id, name, description, product_group_id) values (10, 'Literature', 'Literature Books', 3);
insert into product_sub_group (id, name, description, product_group_id) values (11, 'History', 'History Books', 3);
insert into product_sub_group (id, name, description, product_group_id) values (12, 'Politics', 'Politics Books', 3);
insert into product_sub_group (id, name, description, product_group_id) values (13, 'Child Book', 'Child Books', 3);

insert into product_sub_group (id, name, description, product_group_id) values (14, 'Technology', 'Technology Ebooks', 4);
insert into product_sub_group (id, name, description, product_group_id) values (15, 'Education', 'Education Ebooks', 4);
insert into product_sub_group (id, name, description, product_group_id) values (16, 'Health', 'Health Ebooks', 4);

insert into product_sub_group (id, name, description, product_group_id) values (17, 'Film', 'Film Videos', 5);
insert into product_sub_group (id, name, description, product_group_id) values (18, 'Music', 'Music Videos', 5);
insert into product_sub_group (id, name, description, product_group_id) values (19, 'Sport', 'Sport Videos', 5);
insert into product_sub_group (id, name, description, product_group_id) values (20, 'Cooking', 'Cooking Videos', 5);
/******************************************************************************************************************************/
insert into member_type (id, name, description) values (1, 'Standart', 'Standart Membership');
insert into member_type (id, name, description) values (2, 'Premium', 'Premium Membership');
/******************************************************************************************************************************/
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (1, 'Tom', 'Darren', 'London', 04324525567, 1, 'ACTIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (2, 'Laura', 'Benn', 'Maidenhead', 34524525567, 1, 'PASSIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (3, 'Claire', 'Brown', 'Reading', 87564525567, 1, 'PASSIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (4, 'Michael', 'Hanks', 'Manchester', 92844525567, 1, 'ACTIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (5, 'Susan', 'Chan', 'Twford', 88764525567, 2, 'ACTIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (6, 'Jack', 'Simpson', 'Liverpool', 09824525567, 1, 'PASSIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (7, 'Jill', 'Jackson', 'London', 75624525567, 1, 'ACTIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (8, 'Anna', 'Roy', 'Newbury', 55424525567, 1, 'PASSIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (9, 'Sam', 'Ford', 'Oxford', 66724525567, 2, 'ACTIVE', 'tasatan@gmail.com');
insert into member (id, name, surname, address, telephone, member_type_id, member_status, email_address) values (10, 'Bruice', 'Souza', 'Edinburg', 22524525567, 1, 'ACTIVE', 'tasatan@gmail.com');
/******************************************************************************************************************************/
insert into agent (id, name, address, telephone) values (1, 'Agent1', 'Slough', 11124525567);
insert into agent (id, name, address, telephone) values (2, 'Agent2', 'Timperley', 22224525567);
insert into agent (id, name, address, telephone) values (3, 'Agent3', 'Baker Street', 33324525567);
insert into agent (id, name, address, telephone) values (4, 'Agent4', 'Tilehurst', 44424525567);
insert into agent (id, name, address, telephone) values (5, 'Agent5', 'Woodley', 55524525567);
insert into agent (id, name, address, telephone) values (6, 'Agent6', 'Early', 66624525567);
insert into agent (id, name, address, telephone) values (7, 'Agent7', 'Whitley', 77724525567);
insert into agent (id, name, address, telephone) values (8, 'Agent8', 'Tay Way', 88824525567);
insert into agent (id, name, address, telephone) values (9, 'Agent9', 'Maidenhead', 99924525567);
insert into agent (id, name, address, telephone) values (10, 'Agent10', 'Calcot', 10024525567);
/******************************************************************************************************************************/
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (1, 'Red Long Dress', 'Viscose', 1, 50.00, false, 35, 5, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (2, 'Blue Medium Dress', 'Silk', 1, 90.00, false, 23, 4, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (3, 'Green Dress', 'Cotton', 1, 60.00, false, 17, 4, 0.20);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (7, 'Winter Suit', 'Wool', 4, 130.00, false, 11, 1, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (8, 'Summer Suit', 'Linen', 4, 150.00, false, 22, 1, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (9, 'Sport Suit', 'Cotton', 4, 140.00, false, 77, 5, 0.20);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (4, 'Yellow T-shirt', 'Viscose', 5, 30.00, false, 35, 5, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (5, 'Pink T-shirt', 'Silk', 5, 60.00, false, 23, 5, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (6, 'Black T-shirt', 'Cotton', 5, 40.00, false, 17, 4, 0.20);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (10, 'Black Boot', 'Without heels', 6, 45.00, false, 63, 7, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (11, 'Brown Boot', 'Leather', 6, 80.00, false, 51, 7, 0.20);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (12, 'Colourful Sandal', 'Leather', 7, 30.00, false, 21, 7, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (13, 'Grey Casual Shoes', 'Leather', 8, 80.00, false, 19, 7, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (14, 'White Sneaker Shoes', 'Puma', 9, 50.00, false, 11, 1, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (15, 'Literature Book 1', 'Published in 2020', 10, 10.00, false, 6, 2, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (16, 'History Book1', 'Written by Alex', 11, 15.00, false, 23, 2, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (17, 'History Book2', 'Published in 1986', 11, 10.00, false, 37, 3, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (18, 'Politics Book1', 'Puma', 12, 20.00, false, 11, 3, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (19, 'The Snowman', 'Level1', 13, 5.00, false, 17, 3, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (20, 'Waffle and Bella', 'Level2', 13, 5.00, false, 19, 2, 0.10);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (21, 'Design Patterns in Java', 'Written By David', 14, 50.00, false, 0, 3, 0);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (22, 'PHP', 'Published in 2021', 14, 40.00, false, 0, 2, 0);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (23, 'Maths', 'Preparing to the exam', 15, 10.00, false, 0, 2, 0);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (24, 'English Grammer', 'Published in 2015', 15, 20.00, false, 0, 2, 0);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (25, 'Vegatarian Diet', 'Ebook', 16, 10.00, false, 0, 6, 0);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (26, 'The Pursuit of Happyness', 'Will Smith', 17, 10.00, false, 0, 9, 0.15);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (27, 'John Wick', 'Keanu Reeves', 17, 10.00, false, 0, 9, 0.15);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (28, 'Rockabye', 'Anne Marie', 18, 10.00, false, 0, 8, 0.15);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (29, 'Learning to Ski', 'Popular Ski Video', 19, 15.00, true, 0, 8, 0.15);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (30, 'How to Dive', 'By Expert Trainer', 19, 15.00, true, 0, 10, 0.15);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (31, 'Learning to Cook', 'Beginner', 20, 20.00, true, 0, 10, 0.15);
insert into product (id, name, description, product_sub_group_id, price, need_first_aid_video, stock_count, agent_id, agent_commission_rate) 
values (32, 'Be A Master At Cooking', 'Advanced', 20, 20.00, true, 0, 10, 0.15);
/******************************************************************************************************************************/
insert into member_order (id, member_id, order_date, order_time, order_status,  payment_method, total_amount, delivery_date) 
values(111111, 1, '2022-01-02','2022-01-02 19:06:14.414971','WAS_DELIVERED', 'CREDIT_CART', 50.00, '2022-01-03');
/******************************************************************************************************************************/
insert into order_detail (id, member_order_id, product_id, order_count, amount, agent_commission_amount)
values (99990, 111111, 7, 1, 130.00, 13.00);
insert into order_detail (id, member_order_id, product_id, order_count, amount, agent_commission_amount)
values (99991, 111111, 10, 1, 45.00, 4.50);


