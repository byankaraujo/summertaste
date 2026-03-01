SummerTaste - Sistema de Gestão de Pedidos

Sistema de gerenciamento de pedidos desenvolvido como solução para desafio técnico, utilizando Spring Boot, arquitetura em camadas e boas práticas de organização de código.

Objetivo

Permitir o cadastro e consulta de:

Clientes

Produtos

Pedidos com múltiplos itens

Cálculo de total por pedido e total acumulado por cliente

Atualização automática de estoque

Arquitetura

O projeto segue arquitetura em camadas:

Controller → Service → Repository → Database

Estrutura do Projeto
src/main/java/br/com/summertaste
Controller      → Camada de entrada (REST / Web)
Service         → Regras de negócio
Dto             → Objetos de transferência de dados
Repository      → Acesso a dados (JPA)
Model           → Entidades JPA

Tecnologias Utilizadas

Java 17, 
Spring Boot,
Spring Data JPA,
Hibernate,
Banco H2 (em memória),
Maven,
HTML + JavaScript (frontend simples).

Funcionalidades

Cliente
- Cadastro
- Listagem com ou sem filtros

Produto
- Cadastro
- Controle de estoque
- Atualização automática ao criar pedido
- Listagem com ou sem filtros

Pedido
- Criação com múltiplos produtos
- Aplicação de desconto por item
- Cálculo automático do total do pedido
-Listagem com ou sem filtros
- Agrupamento por cliente
- Exibição do valor total acumulado por cliente

Regras de Negócio
- Criação de Pedido

Não é permitido pedido sem cliente;

Não é permitido pedido sem itens;

Estoque é reduzido automaticamente;

Caso estoque seja insuficiente → erro de validação;

Desconto nulo é tratado como 0.00;

- Consulta por Período

Data inicial e final devem ser informadas juntas, portanto, a data que não foi informada é preenchida automaticamente.

Regra de cálculo

Total por item: (valorProduto * quantidade) - descontoProduto

Total do pedido: Soma de todos os itens do pedido

Total por cliente: Soma de todos os pedidos do cliente

🔎 Exemplos de Endpoint
Criar Pedido
POST /pedidos

Exemplo de JSON:

{
"cpfCliente": "49731346007",
"itens": [
{
"idProduto": 1,
"quantidade": 2,
"desconto": 0
},
{
"idProduto": 2,
"quantidade": 1,
"desconto": 1.50
}
]
}
Buscar Pedidos
GET /pedidos?cpf=49731346007
GET /pedidos?id=1
GET /pedidos?dataInicio=2025-01-01&dataFim=2025-01-31

Passos para execução do projeto:

Clonar repositório
    git clone <url-do-repositorio>

Entrar na pasta
    cd summertaste

Executar aplicação
    mvn spring-boot:run

Aplicação disponível em:

http://localhost:8080


Banco de Dados

Banco utilizado: H2 (em memória)

Console disponível em:

http://localhost:8080/h2-console

Configuração padrão:

JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vazio)


Arquivo data.sql contém dados iniciais para testes.


Tratamento de Validações

CPF obrigatório;

Cliente deve existir;

Produto deve existir;

Estoque suficiente;

Pedido deve conter pelo menos um item;

Organização técnica:

- Arquitetura organizada

- Tratamento de valores nulos

- Separação clara entre regra de negócio e camada de persistência

- Agrupamento de pedidos por cliente com cálculo acumulado

Autor

Desenvolvido por Myrelly Byanka Araujo de Oliveira