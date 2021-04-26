INSERT INTO USUARIO(nome, email, senha) VALUES('usuario', 'usuario@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO FAZENDA(nome) VALUES('Fazenda_1');
INSERT INTO FAZENDA(nome) VALUES('Fazenda_2');

INSERT INTO TALHAO(area,fazenda_id )values(100,1);
INSERT INTO TALHAO(area,fazenda_id )values(200,1);
INSERT INTO TALHAO(area,fazenda_id )values(120,2);
INSERT INTO TALHAO(area,fazenda_id )values(220,2);

INSERT INTO REGISTRO(registro,talhao_id)values(10,1);
INSERT INTO REGISTRO(registro,talhao_id)values(20,2);

INSERT INTO REGISTRO(registro,talhao_id)values(30,3);
INSERT INTO REGISTRO(registro,talhao_id)values(40,4);

