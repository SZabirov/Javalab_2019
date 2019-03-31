--Создание таблицы
CREATE TABLE shop_user
(
    id INTEGER PRIMARY KEY, --первичный ключ
    username VARCHAR(255),
    password VARCHAR(255)
);

--Вставка в таблицу
INSERT INTO shop_user(id, username, password)
VALUES (1, 'Petya', 'Qwerty123');

INSERT INTO shop_user(id, username, password)
VALUES (2, 'Salavat', 'суперпароль');

--Выборка из таблицы. * - все колонки
SELECT * FROM shop_user;
SELECT * FROM shop_user;

--ORDER BY - упорядочить строки в выборке по значению колонки.
--Параметр ASC - по возрастанию; DESC - по убыванию
SELECT username, id FROM shop_user ORDER BY id ASC;

--Выборка с условием
SELECT * FROM shop_user WHERE id = 1;

--Обновление имеющейся в таблице записи с id=1
UPDATE shop_user SET username = 'PETYA12345' WHERE id = 1;

--Удаление записей по условию
DELETE FROM shop_user WHERE username = 'Salavat';

SELECT * FROM shop_user;

--SELECT, INSERT, DELETE, UPDATE = DML

--CREATE, DROP, ALTER = DDL

DROP TABLE product;
CREATE TABLE product
(
    id INTEGER PRIMARY KEY,
    name VARCHAR(255),
    cost INTEGER CHECK ( cost >= 0 ) NOT NULL --на данную колонку добавили два constraint'а (ограничения)
);

SELECT NULL > 0;

INSERT INTO product(id, name, cost)
VALUES (1, 'TV', 20000);

INSERT INTO product(id, name, cost)
VALUES (1, 'Multivarka', -2999); --отрицательная цена не пройдет CHECK

INSERT INTO product(id, name, cost)
VALUES (2, 'Multivarka', 2999);

INSERT INTO product(id, name)
VALUES (1, 'Multivarka'); -- запись без цены не пройдет ограничение NOT NULL

DROP TABLE shop_order;
CREATE TABLE shop_order
(
    user_id INTEGER REFERENCES shop_user(id), --FOREIGN KEY на колонку id в таблице shop_user
    product_id INTEGER REFERENCES product(id)
);

SELECT * FROM shop_user;
SELECT * FROM product;

INSERT INTO shop_order(user_id, product_id)
VALUES (1, 1), (1, 2);

INSERT INTO shop_order(user_id, product_id)
VALUES (2, 1);

SELECT * FROM shop_order;

--Выборка из двух таблиц с условием
SELECT * FROM shop_user u, shop_order o
WHERE u.id = o.user_id;

--Выборка из трех таблиц. Результат запроса - это пары
-- имя_пользователя, который заказал продукт, и название_продукта
SELECT u.username, p.name
FROM shop_user u, shop_order o, product p
WHERE u.id = o.user_id AND o.product_id = p.id;

--Выборка из нескольких таблиц с использованием JOIN
SELECT shop_user.username, p.name
FROM shop_user INNER JOIN shop_order so
                          on shop_user.id = so.user_id
               INNER JOIN product p on so.product_id = p.id;

--в данной таблице пара серия-номер является
--уникальным идентификатором гражданина
CREATE TABLE citizen(
                        name VARCHAR(255),
                        surname VARCHAR(255),
                        series CHAR(4),
                        number CHAR(6)
);

INSERT INTO citizen(name, surname, series, number)
VALUES ('Aaaa', 'Bcd', '1234', '123456'),
       ('John', 'John', '1234', '123456');

--изменение схемы таблицы - добавление ограничения Первичный ключ
-- поскольку добавленные предыдущим insert'ом записи содержат
-- одинаковую пару серия-номер, то добавление ограничения PK будет неудачным
ALTER TABLE citizen
    ADD CONSTRAINT citizen_pk
        PRIMARY KEY (series, number);










