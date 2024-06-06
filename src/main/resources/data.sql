
insert into shops(id, name) values (100, '1000 мелочей');
insert into shops(id, name) values (101, '100 мелочей');

insert into categories(id,name,active, shop_id) values(1, 'Молочка', true, 100);
insert into categories(id,name,active,shop_id) values(2, 'Хлебобулочные', false, 101);


insert into products(id, name, price, category_id) values (1, 'Молоко', 45, 1);
insert into products(id, name, price, category_id) values (2, 'Хлеб', 23, 2);
insert into products(id, name, price, category_id) values (3, 'Кефир', 87, 1);
insert into products(id, name, price, category_id) values (4, 'Сыр', 113, 1);

