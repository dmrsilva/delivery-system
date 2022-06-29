# Delivery System 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/dmrsilva/delivery-system/blob/main/LICENCE) 

# Sobre o projeto

https://dsdeliverysystem.netlify.app

Delivery System é uma aplicação simplificada de gerenciamento de pedidos e produtos. Possui uma tela para visualização de produtos que não requer autenticação, onde qualquer usuário poderá visualizar quais itens estão disponíveis e os seus detalhes. Além disso, existe uma página de gerenciamento 
onde um usuário **autenticado** e devidamente **autorizado** poderá manipular os produtos e pedidos na aplicação com base no seu perfil.

## Funcionalidades
- Listagem de produtos
- Busca de produtos
- Detalhes do produto
- Cadastro, alteração e exclusão de produtos
- Login de usuário
- Liberação de recursos com base no perfil de usuário

## Layout mobile
![Mobile 1](https://github.com/dmrsilva/assets/blob/main/image-mobile-1.png) ![Mobile 2](https://github.com/dmrsilva/assets/blob/main/image-mobile-2.png)

## Layout web
![Web 1](https://github.com/dmrsilva/assets/blob/main/image-web-1.png)

![Web 2](https://github.com/dmrsilva/assets/blob/main/image-web-2.png)

# Tecnologias utilizadas
## Front end
- HTML / CSS / JS / TypeScript
- Bootstrap
- React
- Axios
## Back end
- Java
- Spring Boot
- JPA / Hibernate / JPQL
- OAuth2 e JWT
- JUnit
- Maven
## Persistência de dados
- PostgreSQL
## Implantação em produção
- Front end web: Netlify
- Back end: Heroku / AWS / Docker
- Banco de dados: PostgreSQL
- AWS: EC2 / VPC / RDS

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone git@github.com:dmrsilva/delivery-system.git
ou
git clone https://github.com/dmrsilva/delivery-system.git

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## Front end web
Pré-requisitos: yarn

```bash
# clonar repositório
git clone git@github.com:dmrsilva/delivery-system.git
ou
git clone https://github.com/dmrsilva/delivery-system.git

# entrar na pasta do projeto front end web
cd frontweb

# instalar dependências
yarn install

# executar o projeto
yarn start
```

# Autor

Daniel Silva

https://www.linkedin.com/in/danielmrsilva/
