DROP DATABASE if exists PousadaappJPA2;

CREATE DATABASE IF NOT EXISTS PousadaappJPA2;
USE PousadaappJPA2;

-- Tabela quarto
CREATE TABLE Quarto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    identificacao VARCHAR(50) NOT NULL,   -- número ou nome do quarto
    capacidadeMaxima INT NOT NULL,        -- limite de hóspedes
    tipo VARCHAR(50)                      -- opcional: casal, solteiro, suíte...
);

-- Inserção dos quartos
INSERT INTO Quarto (identificacao, capacidadeMaxima, tipo)
VALUES 
('1', 4, 'Casal + Beliche'),
('2', 6, '3 Beliches'),
('3', 5, 'Casal + Beliche + Solteiro'),
('4', 15, 'Coletivo: 6 Beliches + 3 Solteiros');

-- Tabela Hospede
CREATE TABLE Hospede (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    idade INT NOT NULL,
    contato VARCHAR(15) NOT NULL,
    numeroDeDias INT NOT NULL,
    saldo DECIMAL(9,2) NOT NULL,
    quarto_id INT,
    CONSTRAINT fk_quarto FOREIGN KEY (quarto_id) REFERENCES Quarto(id)
);

-- Tabela Usuario
CREATE TABLE Usuario(
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
login VARCHAR(30) NOT NULL,
senha TEXT NOT NULL,
tipo VARCHAR (30) NOT NULL,
PRIMARY KEY (ID)
);

-- tabela Gastos
CREATE TABLE gastos(
id INT NOT NULL AUTO_INCREMENT,
data varchar(12) NOT NULL,
descricao VARCHAR(30) NOT NULL,
valor DOUBLE (9,2) NOT NULL,
PRIMARY KEY(id)
);

-- Tabela Caixa
CREATE TABLE Caixa (
 id INT NOT NULL AUTO_INCREMENT, 
 saldoTotal DOUBLE(9,2) NOT NULL DEFAULT 0, 
 PRIMARY KEY (id)
 );
 
CREATE TABLE SenhaTeste (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255),
    senha_original VARCHAR(255),
    senha_md5 VARCHAR(32)
);


SELECT*FROM USUARIO;
SELECT*FROM HOSPEDE;
SELECT*FROM QUARTO;
SELECT*FROM GASTOS;
SELECT SUM(VALOR) FROM GASTOS;
SELECT*FROM SENHATESTE;

/*
logins e senhas: @filipe  senha: adm123 tipo: Administrador
                 @dulci   senha: dulci109 tipo: Proprietaria
                 @maria   senha: mari123 tipo: Secretaria
*/




