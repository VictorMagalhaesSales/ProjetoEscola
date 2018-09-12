
INSERT INTO aluno VALUES
(0,"Victor","Magalhães","admin@algamoney.com","$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.","2001-01-29","admin@algamoney.com","(85)988400644","c://imagems/ae.png"),
(0,"Yara","Santana","yara","$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.","2001-05-23","victormagadlhaessahles@gmail.com","(85)988400644","c://imagems/ae.png"),
(0,"Lucas","Sousa","lucas","$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.","2001-10-15","victormagalhaddessalkes@gmail.com","(85)988400644","c://imagems/ae.png");

INSERT INTO professor VALUES
(0,"Edy","vidal","Biologia","asd","$2a$10$CGa/84j80Y45c2SW99cSYep5mZy.SYtcId0YNQOQbDEAz50gRVz7q","2001-01-01","asdaskhgdad","asdgad","asdsasd"),
(0,"Kelmy","Carmurça","Português","logidn","$2a$10$CGa/84j80Y45c2SW99cSYep5mZy.SYtcId0YNQOQbDEAz50gRVz7q","2001-01-01","asdakshdad","asdafd","ajsdasd"),
(0,"Jhonnys","Sousa","Física","logdin","$2a$10$CGa/84j80Y45c2SW99cSYep5mZy.SYtcId0YNQOQbDEAz50gRVz7q","2001-01-01","asdajsdajd","asda;d","asçdasd");

INSERT INTO materia VALUES("Portugues");
INSERT INTO materia VALUES("Matematica");
INSERT INTO materia VALUES("Historia");
INSERT INTO materia VALUES("Geografia");
INSERT INTO materia VALUES("Fisica");
INSERT INTO materia VALUES("Quimica");
INSERT INTO materia VALUES("Filosofia");
INSERT INTO materia VALUES("Sociologia");
INSERT INTO materia VALUES("Literatura");
INSERT INTO materia VALUES("Redacao");

INSERT INTO bimestre VALUES (1),(2),(3),(4);


INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_LISTAR_ALUNOS');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_LISTAR_ALUNO');
INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_SALVAR_ALUNO');
INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_DELETAR_ALUNO');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_EDITAR_ALUNO');

INSERT INTO permissao (codigo, descricao) values (6, 'ROLE_LISTAR_FALTAS');
INSERT INTO permissao (codigo, descricao) values (7, 'ROLE_SALVAR_FALTA');
INSERT INTO permissao (codigo, descricao) values (8, 'ROLE_DELETAR_FALTA');

INSERT INTO permissao (codigo, descricao) values (9, 'ROLE_LISTAR_NOTAS');
INSERT INTO permissao (codigo, descricao) values (10, 'ROLE_SALVAR_NOTA');
INSERT INTO permissao (codigo, descricao) values (11, 'ROLE_DELETAR_NOTA');
INSERT INTO permissao (codigo, descricao) values (12, 'ROLE_EDITAR_NOTA');

INSERT INTO permissao (codigo, descricao) values (13, 'ROLE_LISTAR_PROFESSORES');
INSERT INTO permissao (codigo, descricao) values (14, 'ROLE_LISTAR_PROFESSOR');
INSERT INTO permissao (codigo, descricao) values (15, 'ROLE_SALVAR_PROFESSOR');
INSERT INTO permissao (codigo, descricao) values (16, 'ROLE_DELETAR_PROFESSOR');
INSERT INTO permissao (codigo, descricao) values (17, 'ROLE_EDITAR_PROFESSOR');

INSERT INTO aluno_permissao(codigo_aluno,codigo_permissao) VALUES 
(1,2),
(1,5),
(1,6),
(1,9),
(1,13);