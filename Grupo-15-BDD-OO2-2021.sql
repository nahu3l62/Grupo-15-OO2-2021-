CREATE DATABASE  IF NOT EXISTS `Grupo-15-BDD-OO2-2021`;
USE `Grupo-15-BDD-OO2-2021`;

INSERT INTO perfiles VALUES(1,true,'Administrador');
INSERT INTO perfiles VALUES(2,true,'Auditor');
INSERT INTO usuario VALUES(1,'User','$2a$10$SUJ4cNh2BsoR.i9KQxfnzOc8csk50wrBhX8tX.qid.Ogbz.KwUrSK','user@hotmail.com',true,0,'User','user','D.N.I.',1);
INSERT INTO usuario VALUES(2,'Auditor','$2a$10$haErjQs9KizZKoU4O0GXjuvQ5pPAwE1.noNdZMW02cNPO.5TAyEiW','auditor@hotmail.com',true,1,'Auditor','auditor','D.N.I.',2);

INSERT INTO lugar VALUES(1,'1828','Lomas de zamora');
INSERT INTO lugar VALUES(2,'1675','CABA');
INSERT INTO lugar VALUES(3,'7600','Mar del plata');
INSERT INTO lugar VALUES(4,'1678','Caseros');

select *from perfiles;
select *from usuario;
select *from persona;
select *from permiso;
select *from permiso_diario;
select *from permiso_periodo;
select *from permiso_desde_hasta;
select *from lugar;
select *from rodado;



