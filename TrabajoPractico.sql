CREATE DATABASE  IF NOT EXISTS `TrabajoPractico`;
USE `TrabajoPractico`;

INSERT INTO perfiles VALUES(1,true,'Administrador');
INSERT INTO perfiles VALUES(2,true,'Auditor');
INSERT INTO usuario VALUES(1,'User','$2a$10$SUJ4cNh2BsoR.i9KQxfnzOc8csk50wrBhX8tX.qid.Ogbz.KwUrSK','user@hotmail.com',true,0,'User','user','D.N.I.',1);

select *from perfiles;
select *from usuario;
