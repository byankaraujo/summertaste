-- =========================
-- CLIENTES
-- =========================

INSERT INTO CLIENTE (CLIENTE_NOME, CLIENTE_CPF, CLIENTE_EMAIL, CLIENTE_DATA_CADASTRO)
VALUES ('Girlene da Silva Sauro', '49731346007', 'girlene@coldmail.com', CURRENT_DATE);

INSERT INTO CLIENTE (CLIENTE_NOME, CLIENTE_CPF, CLIENTE_EMAIL, CLIENTE_DATA_CADASTRO)
VALUES ('Pedro da Silva Sauro', '04417547084', 'pedro@coldmail.com', CURRENT_DATE);


-- =========================
-- PRODUTOS
-- =========================

INSERT INTO PRODUTO (PRODUTO_NOME, PRODUTO_DESCRICAO, PRODUTO_VALOR, PRODUTO_QTD_ESTOQUE, PRODUTO_DATA_CADASTRO)
VALUES ('Bolo de Chocolate', 'Massa e recheio de chocolate.', 45.00, 10, CURRENT_DATE);

INSERT INTO PRODUTO (PRODUTO_NOME, PRODUTO_DESCRICAO, PRODUTO_VALOR, PRODUTO_QTD_ESTOQUE, PRODUTO_DATA_CADASTRO)
VALUES ('Muffin de Baunilha', 'Massa de baunilha com gotas de chocolate.', 8.50, 30, CURRENT_DATE);

INSERT INTO PRODUTO (PRODUTO_NOME, PRODUTO_DESCRICAO, PRODUTO_VALOR, PRODUTO_QTD_ESTOQUE, PRODUTO_DATA_CADASTRO)
VALUES ('Torta de Limão', 'Massa amanteigada e mousse de limão.', 60.00, 5, CURRENT_DATE);


-- =========================
-- PEDIDO
-- =========================

INSERT INTO PEDIDO (CLIENTE_ID, PEDIDO_DATA)
VALUES (
           (SELECT CLIENTE_ID FROM CLIENTE WHERE CLIENTE_CPF = '49731346007'),
           CURRENT_DATE
       );


-- =========================
-- PEDIDO_PRODUTO
-- =========================

INSERT INTO PEDIDO_PRODUTO
(PEDIDO_ID, PRODUTO_ID, PRODUTO_QTD, PRODUTO_VALOR, PRODUTO_DESCONTO)
VALUES (
           (SELECT MAX(PEDIDO_ID) FROM PEDIDO),
           (SELECT PRODUTO_ID FROM PRODUTO WHERE PRODUTO_NOME = 'Muffin de Baunilha'),
           2,
           8.50,
           0.00
       );