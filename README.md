# Tech Challenge 
Pós Tech Software Architecture - 6SOAT

---

#### Grupo 34

RM353609 - Deivid Cezar da Silva

RM355143 - Luhan Melo Tavares de Lacerda

RM354101 - Stephanie Santos Rodrigues

## O que é o projeto

Há uma lanchonete de bairro que está se expandindo devido ao seu grande sucesso.

Nesse contexto, um sistema de controle de pedidos é essencial para garantir que a lanchonete possa atender os clientes de maneira eficiente, gerenciando seus pedidos e estoques de forma adequada.

Para solucionar o problema, o projeto visa oferecer à lanchonete um sistema de autoatendimento de fast food que permite aos clientes selecionar e fazer pedidos sem precisar interagir com um atendente.

## Objetivos

Este sistema incluirá as seguintes funcionalidades:

- Cadastro e identificação do cliente
- Criar, editar e remover produtos
- Buscar produtos por categoria
- Checkout dos pedidos
- Listar os pedidos 

## Como iniciar o projeto localmente

### Docker compose para subir os containers da aplicação e do banco de dados

```bash
docker-compose up -d
```

### Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## Event Storming

Ilustrou-se o processo do negócio através da tempestade de eventos.

O primeiro passo foi o brainstorm, onde foram levantados os eventos do domínio abordado.

![Brainstorming](assets/event-storming/Brainstorming.svg)

Em seguida, organizou-se os eventos na linha do tempo para os fluxos:

Realização do pedido e pagamento:
![Pedido-pagamento](assets/event-storming/Pedido-pagamento.svg)

Preparação e entrega do pedido:
![Preparacao-entrega](assets/event-storming/Preparacao-entrega.svg)