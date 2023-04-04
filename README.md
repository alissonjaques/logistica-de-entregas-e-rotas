# Logistica de Entregas

TEMA: Logística - EXIGÊNCIAS MÍNIMAS: Cadastro de veículos de entrega, pacotes e motoristas e a junção de todos esses itens em uma rota de entrega de pacotes.

| :placard: Vitrine.Dev |     |
| -------------  | --- |
| :sparkles: Nome        | **Logística de entregas e rotas**
| :label: Tecnologias | java, jasper reports, java swing, sql, mysql

Primeira Etapa: Documentação com a explanação do problema a ser desenvolvido. A documentação deverá conter:
* Capa
* Resumo dos requisitos que serão implementados no problema;
* Descrição sobre o local que será utilizado como base de implementação do sistema, ou seja, o “cliente” fictício que irá “adquirir”;
* Diagrama de Caso de Uso;
* DER;

Segunda Etapa: Implementação da aplicação do tema específico, obedecendo os requisitos mínimos:

* Utilizar o padrão de desenvolvimento MVC (Model-View-Controller);
* Implementar GUI (Interface Gráfica com Usuário) amigável e bem formatada, prevendo possíveis equívocos do usuário (Ex.: desabilitar campos e botões, validações de ações, etc.);
* Implementar o Banco de Dados com mínimo 4 entidades comuns e pelo menos 1 Entidade de Relacionamento (Quando existem ligações N para N);
* Desenvolver no mínimo 4 Relatórios com filtro, salvando extensão pdf em uma pasta específica;

Para o banco de dados:

* 1º: Script: Descrição de toda a DDL e DML para as tabelas;
* 2º Views: Criar no mínimo 5 views utilizando de funções de JOIN;
* 3º Stored Procedures: Desenvolver no mínimo 3 funções com INSERT E UPDATE;
* 4º Triggers: Implementar no mínimo 3 funções com INSERT E UPDATE;

Para todas as entidades implementar o CRUD (Create, Read, Update e Delete) completo, salvo algumas exceções;
Utilizar esses itens do banco de dados na implementação da aplicação.

# Configurar aplicação:

* Execute todos os comandos SQL em um ambiente MySQL (atenção para os relacionamentos, triggers, views e procedures);
* Importe todas as bibliotecas necessárias no arquivo Bibliotecas;
* A senha e usuário para logar no app: admin;
* Configure o acesso a base de dados na classe Conexao, de acordo com suas credenciais;

# Imagens da aplicação funcionando:

![alt text](https://github.com/alissonjaques/logistica-de-entregas-e-rotas/blob/main/Imagens/principal.png#vitrinedev)
![alt text](https://github.com/alissonjaques/logistica-de-entregas-e-rotas/blob/main/Imagens/login.png#vitrinedev)
![alt text](https://github.com/alissonjaques/logistica-de-entregas-e-rotas/blob/main/Imagens/cadastro.png#vitrinedev)
