insert into product(id, product_id, product_name, synchronizable) values(random_uuid(),'1', 'name1', true);
insert into product(id, product_id, product_name, synchronizable) values(random_uuid(),'2', 'name2', true);

insert into product_detail(id, product_id, html, attributes) values(random_uuid(), '1', '<html><p>1</p></html>', '{"brand":"Sony"}');
insert into product_detail(id, product_id, html, attributes) values(random_uuid(), '2', '<html><p>2</p></html>', '{"origin":"Korea"}');