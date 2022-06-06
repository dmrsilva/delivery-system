INSERT INTO tb_user (name, address, email, password) VALUES ('Alex', 'Rua do Campo, Bairro Alvorada', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, address, email, password) VALUES ('Maria', 'Rua das Flores, Bairro Primavera', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T18:25:20.12345Z', 2);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 1);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);
INSERT INTO tb_order (moment, status) VALUES (TIMESTAMP WITH TIME ZONE '2022-05-10T20:30:10.12345Z', 0);

INSERT INTO tb_product (name, description, price, img_uri) VALUES ('Hamburger', 'Hamburger de siri', 35.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, description, price, img_uri) VALUES ('Bolo', 'Bolo de cenoura com cobertura de chocolate', 70.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, description, price, img_uri) VALUES ('Sopa', 'Sopa quente em um dia frio', 25.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, description, price, img_uri) VALUES ('Pizza', 'Pizza de calabresa com borda de cheddar', 82.00, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, description, price, img_uri) VALUES ('Refrigerante', 'Refrigerante pureza, sabor guaraná', 3.50, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');

INSERT INTO tb_order_product(order_id, product_id) VALUES (1, 4);
INSERT INTO tb_order_product(order_id, product_id) VALUES (1, 5);
INSERT INTO tb_order_product(order_id, product_id) VALUES (2, 1);
INSERT INTO tb_order_product(order_id, product_id) VALUES (2, 5);
INSERT INTO tb_order_product(order_id, product_id) VALUES (3, 2);
INSERT INTO tb_order_product(order_id, product_id) VALUES (4, 3);
