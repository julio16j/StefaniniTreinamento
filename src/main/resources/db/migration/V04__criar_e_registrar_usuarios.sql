CREATE TABLE usuario(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE , 
    senha VARCHAR(150)
    ) ENGINE = InnoDB DEFAULT CHARSET=utf8;
INSERT INTO usuario (email , nome, senha ) 
			values("admin@admin.com" , "admin", "$2a$10$pJmbjkZ5dqMgq/9VWJqZ7u3Hzvnej8A3iy60/8U9IM/YEorlURkIu");