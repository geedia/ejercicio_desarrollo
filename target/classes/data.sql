INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('AR','ARGENTINA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO cuenta (id, moneda, saldo) 
VALUES (20,'DOLAR',220);

INSERT INTO cuenta (id, moneda, saldo) 
VALUES (10,'EURO',40);

INSERT INTO MOVIMIENTO (id, descripcion, fecha, importe, tipo, cuenta_id) 
VALUES (1,'CONSIGNACION', CURRENT_TIMESTAMP(), 100, 'D', 20);
INSERT INTO MOVIMIENTO (id, descripcion, fecha, importe, tipo, cuenta_id) 
VALUES (2,'COMPRA', CURRENT_TIMESTAMP(), 20, 'C', 20);
