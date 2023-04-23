ALTER TABLE PAQUETES ALTER COLUMN ID INTEGER AUTO_INCREMENT;
INSERT INTO PERSONAS VALUES (11, 'González', 'Pérez', 3115551234, 'Bogotá', 'Calle 123 # 45 - 67', 'gonzalez@gmail.com', 'Juan');
INSERT INTO PERSONAS VALUES (22, 'Martínez', 'Sánchez', 3104445678, 'Medellín', 'Carrera 34 # 56 - 78', 'martinez@gmail.com', 'María');
INSERT INTO PERSONAS VALUES (33, 'Pérez', 'García', 3173339012, 'Cali', 'Avenida 7 # 89 - 10', 'perez@gmail.com', 'Pedro');
INSERT INTO PERSONAS VALUES (44, 'Hernández', 'López', 3202223456, 'Bucaramanga', 'Calle 56 # 78 - 90', 'hernandez@gmail.com', 'Laura');
INSERT INTO PERSONAS VALUES (55, 'García', 'González', 3191117890, 'Pereira', 'Carrera 12 # 34 - 56', 'garcia@gmail.com', 'Carlos');
INSERT INTO PERSONAS VALUES (66, 'Rodríguez', 'Martínez', 3109992345, 'Barranquilla', 'Calle 90 # 12 - 34', 'rodriguez@gmail.com', 'Ana');
INSERT INTO PERSONAS VALUES (77, 'Sánchez', 'Hernández', 3138886789, 'Cartagena', 'Carrera 45 # 67 - 89', 'sanchez@gmail.com', 'David');
INSERT INTO PERSONAS VALUES (88, 'López', 'García', 3207770123, 'Manizales', 'Calle 23 # 56 - 78', 'lopez@gmail.com', 'Sofía');
INSERT INTO PERSONAS VALUES (99, 'González', 'Rodríguez', 3176663456, 'Cúcuta', 'Carrera 78 # 90 - 12', 'gonzalez_rodriguez@gmail.com', 'Diego');
INSERT INTO PERSONAS VALUES (1010, 'Martínez', 'González', 3115556789, 'Neiva', 'Calle 34 # 56 - 78', 'martinez_gonzalez@gmail.com', 'Mónica');
INSERT INTO PERSONAS VALUES (1111, 'Pérez', 'Hernández', 3104449012, 'Ibagué', 'Carrera 56 # 78 - 90', 'perez_hernandez@gmail.com', 'Andrés');
INSERT INTO EMPLEADOS VALUES (2, 'A_POSITIVO', 'CONDUCTOR', 11);
INSERT INTO EMPLEADOS VALUES (4, 'B_POSITIVO', 'REPARTIDOR', 22);
INSERT INTO EMPLEADOS VALUES (1, 'O_NEGATIVO', 'COORDINADOR', 33);
INSERT INTO EMPLEADOS VALUES (3, 'AB_POSITIVO', 'CONDUCTOR', 44);
INSERT INTO EMPLEADOS VALUES (6, 'A_NEGATIVO', 'REPARTIDOR', 55);
INSERT INTO EMPLEADOS VALUES (5, 'B_NEGATIVO', 'COORDINADOR', 66);
INSERT INTO EMPLEADOS VALUES (7, 'O_POSITIVO', 'CONDUCTOR', 77);
INSERT INTO CLIENTES VALUES (88);
INSERT INTO CLIENTES VALUES (99);
INSERT INTO CLIENTES VALUES (1010);
INSERT INTO CLIENTES VALUES (1111);
INSERT INTO PAQUETES (PESO, TIPO, VALOR_DECLARADO) VALUES (1, 'LIVIANO', 50000);
INSERT INTO PAQUETES (PESO, TIPO, VALOR_DECLARADO) VALUES (3, 'MEDIANO', 100000);
INSERT INTO PAQUETES (PESO, TIPO, VALOR_DECLARADO) VALUES (7, 'GRANDE', 200000);
INSERT INTO PAQUETES (PESO, TIPO, VALOR_DECLARADO) VALUES (5, 'MEDIANO', 15000);
INSERT INTO PAQUETES (PESO, TIPO, VALOR_DECLARADO) VALUES (3, 'MEDIANO', 80000);
INSERT INTO PAQUETES (PESO, TIPO, VALOR_DECLARADO) VALUES (7, 'GRANDE', 150000);
INSERT INTO ENVIOS VALUES ('AA1111', 3101234567, 'Bogotá', 'Medellín', 'Juan Perez', 'Calle 1 # 123', 'EN BODEGA', null, 20000, 1010, 1);
INSERT INTO ENVIOS VALUES ('BB2222', 3152345678, 'Cali', 'Bogotá', 'Pedro Gonzalez', 'Carrera 2 # 456', 'EN BODEGA', null,35000, 99, 2);
INSERT INTO ENVIOS VALUES ('CC3333', 3203456789, 'Barranquilla', 'Cali', 'Maria Rodriguez', 'Avenida 3 # 789', 'EN BODEGA', null, 15000, 88, 3);
INSERT INTO ENVIOS VALUES ('DD4444', 3109876543, 'Medellín', 'Bogotá', 'Luisa Gutierrez', 'Calle 4 # 567', 'EN RUTA', null, 25000, 1010, 4);
INSERT INTO ENVIOS VALUES ('EE5555', 3109876543, 'Medellín', 'Bogotá', 'Luisa Gutierrez', 'Calle 4 # 567', 'EN RUTA', null, 25000, 1010, 5);
INSERT INTO ENVIOS VALUES ('FF6666', 3207654321, 'Cali', 'Barranquilla', 'Fernando Castro', 'Avenida 6 # 234', 'ENTREGADO', '10:30:00', 12000, 88, 6);