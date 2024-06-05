# advantage-online-shopping

- Projeto de automação de testes Web para uma aplicação de ecommerce.

- Stack utilizada na construção do projeto:

    Java                 - v17
    
    Gradle               -v7.4
    
    JUnit5               -v5.8.1
    
    commons-dbutils      - v1.7
    
    Selenium             - v3.141.59
    
    mysql-connector-java - v8.0.28
    
    webdrivermanager     - v5.1.0
    
- Para este projeto é nescessário ter um banco local criado mysql com as seguintes especificações:

    - Crie a senha para seu banco local conforme "TESTE1@nao" ou altere no projeto como desejar.
    - Script para criação do banco:

CREATE DATABASE `banco_teste_automacao`;

CREATE TABLE `massas` (
`IDMASSAS` int(11) NOT NULL AUTO_INCREMENT,
`NAME_PRODUCT` varchar(45) DEFAULT NULL,
`CUSTOMIZATION` varchar(45) DEFAULT NULL,
`DISPLAY` varchar(600) DEFAULT NULL,
`DISPLAY_RESOLUTION` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`DISPLAY_SIZE` varchar(45) DEFAULT NULL,
`MEMORY` varchar(45) DEFAULT NULL,
`OPERATING_SYSTEM` varchar(45) DEFAULT NULL,
`PROCESSOR` varchar(255) DEFAULT NULL,
`TOUCHSCREEN` varchar(45) DEFAULT NULL,
`WEIGHT` varchar(45) DEFAULT NULL,
`COLOR` varchar(45) DEFAULT NULL,
PRIMARY KEY (`IDMASSAS`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into
massas(NAME_PRODUCT,CUSTOMIZATION,DISPLAY,DISPLAY_RESOLUTION,DISPLAY_SIZE,MEMORY,OP
ERATING_SYSTEM,PROCESSOR,TOUCHSCREEN,WEIGHT,COLOR)
values("HP PAVILION 15Z TOUCH LAPTOP","Simplicity","15.6-inch diagonal Full HD WLED-backlit Display
(1920x1080) Touchscreen","1920x1080","15.6","16GB DDR3 - 2 DIMM","Windows 10","AMD Quad-Core A10-
8700P Processor + AMD Radeon(TM) R6 Graphics","Yes","5.51 lb","GRAY");
  

- Comando para rodar os testes no terminal:

  gradle test
