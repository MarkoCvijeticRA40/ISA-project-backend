--INSERT INTO addresses(id, city, latitude, longitude, "number", state, street) VALUES (1, 'Beograd', 0, 0, '99', 'Srbija', 'Stefana Nemanje');
--INSERT INTO addresses(id, city, latitude, longitude, "number", state, street) VALUES (2, 'Novi Sad', 0, 0, '54A', 'Srbija', 'Maksima Gorkog');
--INSERT INTO addresses(id, city, latitude, longitude, "number", state, street) VALUES (3, 'Krusevac', 0, 0, '85B', 'Srbija', 'Cara Lazara');
--INSERT INTO addresses(id, city, latitude, longitude, "number", state, street) VALUES (4, 'Novi Sad', 0, 0, '33', 'Srbija', 'Laze Teleckog');
--INSERT INTO addresses(id, city, latitude, longitude, "number", state, street) VALUES (5, 'Beograd', 0, 0, '35', 'Srbija', 'Kralja Petra');


--INSERT INTO work_times VALUES (1, '15:00:00', '07:00:00');
--INSERT INTO work_times VALUES (2, '16:00:00', '08:00:00');
--INSERT INTO work_times VALUES (3, '14:00:00', '06:00:00');
--INSERT INTO work_times VALUES (4, '18:00:00', '09:00:00');
--INSERT INTO work_times VALUES (5, '17:00:00', '11:00:00');


--INSERT INTO centers(id, average_grade, description, name, address_id, work_time_id) VALUES (1, 0, 'Super', 'Banjica', 1, 1);
--INSERT INTO centers(id, average_grade, description, name, address_id, work_time_id) VALUES (2, 3, 'Ekstra', 'Zvezdara', 3, 2);
--INSERT INTO centers(id, average_grade, description, name, address_id, work_time_id) VALUES (3, 2, 'Okej', 'Napredak', 4, 3);
--INSERT INTO centers(id, average_grade, description, name, address_id, work_time_id) VALUES (4, 4, 'Nije lose', 'Zvezdara', 2, 4);


INSERT INTO roles(id, name) VALUES (1, 'REGISTERED_USER');
INSERT INTO roles(id, name) VALUES (2, 'SYSTEM_ADMINISTRATOR');
INSERT INTO roles(id, name) VALUES (3, 'MEDICAL_STAFF');

INSERT INTO user_categories(id, benefit, name) VALUES (1, 'nista spec', 'Regular');
INSERT INTO user_categories(id, benefit, name) VALUES (2, 'oke', 'Silver');
INSERT INTO user_categories(id, benefit, name) VALUES (3, 'nista spec', 'Gold');


--INSERT INTO users(user_type, id, email, facility_info, gender, identity_number, name, password, phone_num, profession, surname, num_of_penalties, points, address_id, role_id, user_category_id, center_id)	VALUES ('MS', 1, 'nesto@gmail.com', 'nesto', 0, '1234567891234', 'Pera', 'partizan', '789', 'student', 'Peric', 0, 0, 4, 3, 1, 1);

--Markovo

--INSERT INTO addresses(id,city,latitude,longitude,number,state,street) VALUES (1,'Sremska Mitrovica',52,61,1,'Srbija','Laze Kostica');

--INSERT INTO centers(id,average_grade,description,name,address_id,work_time_id) VALUES (1,4.12,'Prelep ambijent','Zimzolend',1,1);

--==INSERT INTO users(user_type,id,email,facility_info,gender,identity_number,name,password,phone_num,profession,surname,num_of_penalties,points,address_id,role_id,user_category_id,center_id) VALUES ('ms',1,"milan@gmail.com","Nista",1,512412414,"Milan","123",06124124,"Programer","Milanovic",1,1,1,1,1,1);

--INSERT INTO users(user_type, id, email, facility_info, gender, identity_number, name, password, phone_num, profession, surname, num_of_penalties, points, address_id, role_id, user_category_id, center_id)	VALUES ('MS', 1, 'milan@gmail.com', 'nesto', 0, '1234567891234', 'Pera', 'partizan', '789', 'student', 'Peric', 1,1, 1, 1, 1, 1);

--INSERT INTO users(user_type, id, email, facility_info, gender, identity_number, name, password, phone_num, profession, surname, num_of_penalties, points, address_id, role_id, user_category_id, center_id)	VALUES ('RU', 2, 'talambas@gmail.com', 'nesto', 0, '1234567891235', 'Talambas', 'talambas', '061', 'student', 'Peric', 1,1, 1, 1, 1, 1);


--INSERT INTO users(user_type, id, email, facility_info, gender, identity_number, name, password, phone_num, profession, surname, num_of_penalties, points, address_id, role_id, user_category_id, center_id)	VALUES ('SA', 3, 'lazar@gmail.com', '', 0, '1111111111111', 'Lazar', 'Mijatovic', '0612573707', 'administrator', 'Mijatovic', 0,0, 1,  2, null , null);



--INSERT INTO addresses(id,city,latitude,longitude,number,state,street) VALUES (1,'Sremska Mitrovica',52,61,1,'Srbija','Laze Kostica');

--INSERT INTO centers(id,average_grade,description,name,address_id,work_time_id) VALUES (1,4.12,'Prelep ambijent','Zimzolend',1,1);

--==INSERT INTO users(user_type,id,email,facility_info,gender,identity_number,name,password,phone_num,profession,surname,num_of_penalties,points,address_id,role_id,user_category_id,center_id) VALUES ('ms',1,"milan@gmail.com","Nista",1,512412414,"Milan","123",06124124,"Programer","Milanovic",1,1,1,1,1,1);

--INSERT INTO users(user_type, id, email, facility_info, gender, identity_number, name, password, phone_num, profession, surname, num_of_penalties, points, address_id, role_id, user_category_id, center_id)	VALUES ('MS', 1, 'milan@gmail.com', 'nesto', 0, '1234567891234', 'Pera', 'partizan', '789', 'student', 'Peric', 1,1, 1, 1, 1, 1);



