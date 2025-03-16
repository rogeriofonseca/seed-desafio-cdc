INSERT INTO categorias (nome)
VALUES
  ('Non-Fiction'),
  ('Science Fiction'),
  ('Fantasy'),
  ('Mystery'),
  ('Thriller'),
  ('Romance'),
  ('Horror'),
  ('Biography'),
  ('History'),
  ('Self-Help'),
  ('Health'),
  ('Travel'),
  ('Children'),
  ('Religion'),
  ('Science'),
  ('Poetry'),
  ('Comics'),
  ('Art'),
  ('Cookbooks');

INSERT INTO pais (nome)
VALUES
  ('Brasil');

INSERT INTO estado (nome, pais_id)
VALUES
('Acre', 1),
('Alagoas', 1),
('Amapá', 1),
('Amazonas', 1),
('Bahia', 1),
('Ceará', 1),
('Distrito Federal', 1),
('Espírito Santo', 1),
('Goiás', 1),
('Maranhão', 1),
('Mato Grosso', 1),
('Mato Grosso do Sul', 1),
('Minas Gerais', 1),
('Pará', 1),
('Paraíba', 1),
('Paraná', 1),
('Pernambuco', 1),
('Piauí', 1),
('Rio de Janeiro', 1),
('Rio Grande do Norte', 1),
('Rio Grande do Sul', 1),
('Rondônia', 1),
('Roraima', 1),
('Santa Catarina', 1),
('São Paulo', 1),
('Sergipe', 1),
('Tocantins', 1);

INSERT INTO autores (instante_de_criacao, nome, email, descricao)
VALUES
  (CURRENT_TIMESTAMP, 'F. Scott Fitzgerald', 'fscottfitzgerald@example.com', 'Author of The Great Gatsby'),
  (CURRENT_TIMESTAMP, 'George Orwell', 'georgeorwell@example.com', 'Author of 1984');


---- Inserindo dados na tabela livro com data_publicacao no futuro
INSERT INTO livro (id, titulo, resumo_livro, sumario, preco, numero_paginas, isbn, data_publicacao, autor_id, categoria_id)
VALUES
    (1, 'O Código Limpo', 'Um livro sobre boas práticas de código', 'Capítulo 1: Introdução...', 99.90, 450, '978-85-66250-46-6', DATEADD('DAY', 2, CURRENT_DATE), 1, 2),
    (2, 'Refatoração', 'Melhore o design do código existente', 'Parte 1: Introdução...', 89.50, 350, '978-85-7522-412-1', DATEADD('DAY', 2, CURRENT_DATE), 1, 1);

--
--
---- Inserir livros na tabela livro
--INSERT INTO livro (titulo, resumo_livro, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id)
--VALUES
--  ('The Great Gatsby', 'A novel about the American dream', 'Summary of The Great Gatsby', 20.99, 180, '9780743273565', DATEADD('DAY', 1, CURRENT_DATE), 1, 1),
--  ('1984', 'A dystopian social science fiction novel', 'Summary of 1984', 20.99, 328, '9780451524935', DATEADD('DAY', 1, CURRENT_DATE), 1, 1);