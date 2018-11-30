CREATE TABLE escuela(
codigo int not null,
nombre varchar(30) not null,
PRIMARY KEY (codigo)

);

CREATE TABLE Estudiante(
codigo int not null,
nombre varchar(30) not null,
codEscuela  int not null,

PRIMARY KEY(codigo),

FOREIGN KEY (codEscuela) REFERENCES escuela(codigo)


);

CREATE TABLE Profesor(
codigo int not null,
nombre varchar(30) not null,
apellido varchar(30) not null,
PRIMARY KEY (codigo)

);

CREATE TABLE curso(
codigo int not null,
nombre varchar(30) not null,
codProfesor int not null,
PRIMARY KEY (codigo),
FOREIGN KEY (codProfesor) REFERENCES Profesor(codigo)
);



CREATE TABLE Registro(

id serial  ,
codEstudiante int not null,
codCurso int not null,
semestre varchar(30),
nota FLOAT not null,

PRIMARY KEY (Id),
FOREIGN KEY (codEstudiante) REFERENCES Estudiante(codigo),
FOREIGN KEY (codCurso) REFERENCES Curso(codigo)
);




INSERT INTO Escuela VALUES (1,'Ciencias Exactas');
INSERT INTO Escuela VALUES (2,'Marketing');
INSERT INTO Escuela VALUES (3,'Psicologia');


INSERT INTO Estudiante VALUES (1,'Perez',1);
INSERT INTO Estudiante VALUES (2,'Jhoan',1);
INSERT INTO Estudiante VALUES (7,'Sebas Aya',1);

INSERT INTO Estudiante VALUES (3,'Gonzales',2);
INSERT INTO Estudiante VALUES (4,'Eduardo',2);

INSERT INTO Estudiante VALUES (5,'Patriciio',3);
INSERT INTO Estudiante VALUES (6,'Pera',3);

INSERT INTO Profesor VALUES (1,'Eduardo','Ficti');
INSERT INTO Profesor VALUES (2,'MICHAEL','Soto2');
INSERT INTO Profesor VALUES (3,'Ganze','Rose');
INSERT INTO Profesor VALUES (4,'Kirito','Ronce');
INSERT INTO Profesor VALUES (5,'Sebastian','Soto5');
INSERT INTO Profesor VALUES(6,'Fabian','Giraldo');


INSERT INTO Curso VALUES(1,'Digitales',1);
INSERT INTO Curso VALUES(2,'Mat Especiales',1);

INSERT INTO Curso VALUES(9,'base de datos',6);


INSERT INTO Curso VALUES(3,'Digitales 1',2);
INSERT INTO Curso VALUES(4,'Sociologia',3);
INSERT INTO Curso VALUES(5,'Investigacion',4);
INSERT INTO Curso VALUES(6,'Sist 3',2);
INSERT INTO Curso VALUES(7,'Comportamiento humano',3);
INSERT INTO Curso VALUES(8,'Dinero dinero',4);



INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (1,9,'2017_II',4.5);
INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (2,9,'2017_II',4);
INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (7,9,'2017_II',4.6);
INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (1,3,'2017_II',5);
INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (5,7,'2017_II',0);
INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (5,5,'2017_II',3.1);
INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (5,3,'2017_II',2);

INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (6,1,'2017_II',5);
INSERT INTO REGISTRO (codestudiante,codcurso,semestre,nota) VALUES (6,3,'2018_II',5);




