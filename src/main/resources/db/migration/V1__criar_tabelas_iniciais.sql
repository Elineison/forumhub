CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL
);

CREATE TABLE cursos (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        categoria VARCHAR(100) NOT NULL
);

CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(100) NOT NULL,
                         mensagem TEXT NOT NULL,
                         data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         status VARCHAR(50) NOT NULL,
                         autor_id BIGINT NOT NULL,
                         curso_id BIGINT NOT NULL,

                         FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                         FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

-- Inserir dados iniciais
INSERT INTO cursos (nome, categoria) VALUES
                                         ('Spring Boot', 'Programação'),
                                         ('Java', 'Programação');

-- Inserir usuário de teste (senha: admin123)
INSERT INTO usuarios (nome, email, senha) VALUES
    ('Admin', 'admin@alura.com', '$2a$10$GVtI2lC0l.zM8tOAM1kTNOmk1eZMHTA.KCH4sshkOZ4Xt8LRWkQHC');