INSERT INTO users (id, username, password) VALUES (1, 'test', 'pwd123');
INSERT INTO users (id, username, password) VALUES (2, 'user', '123pwd');
INSERT INTO todos (id, title, last_change,todo_status, description, user_id) VALUES (1, 'Groceries', '2019-08-08', 'DONE', 'Oranges, Apples, Potatoes', 1);
INSERT INTO todos (id, title, last_change,todo_status, description, user_id) VALUES (2, 'Run', '2019-08-08', 'TODO', '1 km', 1);
INSERT INTO todos (id, title, last_change,todo_status, description, user_id) VALUES (3, 'Read', '2019-08-09', 'TODO', null, 1);
INSERT INTO todos (id, title, last_change,todo_status, description, user_id) VALUES (4, 'Call Freddy', '2019-08-07', 'DONE', '1. Guitar 2. Planning', 1);
INSERT INTO todos (id, title, last_change,todo_status, description, user_id) VALUES (5, 'Repair Door', '2019-08-07', 'TODO', 'Windshield', 2);
INSERT INTO todos (id, title, last_change,todo_status, description, user_id) VALUES (5, 'Buy new Keyboard', '2019-08-13', 'DONE', 'Logitech maybe Razer', 2);

-- INSERT INTO todos (id, title, last_change, due_date, todo_status, description, user_id) VALUES (1, 'Groceries', '2019-08-08', '2019-08-29', 'DONE', 'Oranges, Apples, Potatoes', 1);
-- INSERT INTO todos (id, title, last_change, due_date, todo_status, description, user_id) VALUES (2, 'Run', '2019-08-08', '2019-08-09', 'TODO', '1 km', 1);
-- INSERT INTO todos (id, title, last_change, due_date, todo_status, description, user_id) VALUES (3, 'Read', '2019-08-09', '2019-08-11', 'TODO', null, 1);
-- INSERT INTO todos (id, title, last_change, due_date, todo_status, description, user_id) VALUES (4, 'Call Freddy', '2019-08-07', '2019-08-24', 'DONE', '1. Guitar 2. Planning', 1);
-- INSERT INTO todos (id, title, last_change, due_date, todo_status, description, user_id) VALUES (5, 'Repair Door', '2019-08-07', '2019-08-12', 'TODO', 'Windshield', 2);
-- INSERT INTO todos (id, title, last_change, due_date, todo_status, description, user_id) VALUES (5, 'Buy new Keyboard', '2019-08-13', '2019-08-14', 'DONE', 'Logitech maybe Razer', 2);