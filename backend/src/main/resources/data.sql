INSERT INTO tb_user (name, address, email, password) VALUES ('Alex', 'Rua do Campo, Bairro Alvorada', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, address, email, password) VALUES ('Maria', 'Rua das Flores, Bairro Primavera', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Hamburger de Siri', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 35.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Hamburger com Bacon', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 35.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Hamburger com Queijo', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 35.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Bolo de Cenoura', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 70.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Bolo de Chocolate', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 70.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Torta de Frango', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 70.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Torta de Sardinha', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 70.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Sopa de Legumes', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 25.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Sopa de Tainha', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 25.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Pizza Calabresa', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 82.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Pizza Portuguesa', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 82.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Pizza Marguerita', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 82.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Refrigerante Pureza', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 3.50, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Refrigerante Coca Cola', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 5.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Refrigerante Tubaína', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 4.75, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Suco de Laranja', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 8.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Suco de Uva', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 8.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Suco de Acerola', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy.', 8.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T18:25:20.12345Z', 2);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 1);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);

INSERT INTO tb_order_product(order_id, product_id) VALUES (1, 1);
INSERT INTO tb_order_product(order_id, product_id) VALUES (1, 14);

INSERT INTO tb_order_product(order_id, product_id) VALUES (2, 2);
INSERT INTO tb_order_product(order_id, product_id) VALUES (2, 13);

INSERT INTO tb_order_product(order_id, product_id) VALUES (3, 3);
INSERT INTO tb_order_product(order_id, product_id) VALUES (3, 15);

INSERT INTO tb_order_product(order_id, product_id) VALUES (4, 4);
INSERT INTO tb_order_product(order_id, product_id) VALUES (4, 16);

INSERT INTO tb_order_product(order_id, product_id) VALUES (5, 5);
INSERT INTO tb_order_product(order_id, product_id) VALUES (5, 18);

INSERT INTO tb_order_product(order_id, product_id) VALUES (5, 7);
INSERT INTO tb_order_product(order_id, product_id) VALUES (5, 13);
INSERT INTO tb_order_product(order_id, product_id) VALUES (5, 17);

INSERT INTO tb_order_product(order_id, product_id) VALUES (6, 10);
INSERT INTO tb_order_product(order_id, product_id) VALUES (6, 14);

INSERT INTO tb_order_product(order_id, product_id) VALUES (7, 12);
INSERT INTO tb_order_product(order_id, product_id) VALUES (7, 13);

INSERT INTO tb_order_product(order_id, product_id) VALUES (8, 8);
INSERT INTO tb_order_product(order_id, product_id) VALUES (8, 9);

INSERT INTO tb_order_product(order_id, product_id) VALUES (9, 5);
INSERT INTO tb_order_product(order_id, product_id) VALUES (9, 14);
INSERT INTO tb_order_product(order_id, product_id) VALUES (9, 16);
