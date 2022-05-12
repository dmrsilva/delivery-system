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

INSERT INTO tb_product (name, description, img_uri, order_id) VALUES ('Hamburger', 'Hamburger de siri', 'https://raw.githubusercontent.com/', 1);
INSERT INTO tb_product (name, description, img_uri, order_id) VALUES ('Bolo', 'Bolo de cenoura com cobertura de chocolate', 'https://raw.githubusercontent.com/', 2);
INSERT INTO tb_product (name, description, img_uri, order_id) VALUES ('Sopa', 'Sopa quente em um dia frio', 'https://raw.githubusercontent.com/', 2);
INSERT INTO tb_product (name, description, img_uri, order_id) VALUES ('Pizza', 'Pizza de calabresa com bordas de cheddar', 'https://raw.githubusercontent.com/', 3);
INSERT INTO tb_product (name, description, img_uri, order_id) VALUES ('Refrigerante', 'Refrigerante pureza, sabor guaraná', 'https://raw.githubusercontent.com/', 3);
