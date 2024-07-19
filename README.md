# Tech Challenge - Pós Tech Software Architecture

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

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você tem uma máquina `<Windows / Linux / Mac>`.
* Docker
* Postman ou insomnia
* Jdk 17 ou superior

## Como iniciar o projeto localmente

### Docker compose para subir os containers da aplicação e do banco de dados

```bash
docker-compose up -d
```

### <img src="https://user-images.githubusercontent.com/25181517/186711335-a3729606-5a78-4496-9a36-06efcc74f800.png" width=30> Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## <img src="https://skillicons.dev/icons?i=kubernetes" width=30> Rodando o projeto no Kubernetes

Para rodar no **Kubernetes** siga as seguintes etapas:

#### Instale o Docker e habilite o k8s de acordo com seu Sistema Operacional

<img width="20" src="https://user-images.githubusercontent.com/25181517/186884150-05e9ff6d-340e-4802-9533-2c3f02363ee3.png" alt="Ícone indicando o sistema operacional Windows">

> Instale o Docker Desktop de acordo com o [manual oficial](https://docs.docker.com/desktop/install/windows-install/) e [habilite o Kubernetes](https://docs.docker.com/desktop/kubernetes/)

<img width="20" src="https://github.com/marwin1991/profile-technology-icons/assets/76662862/2481dc48-be6b-4ebb-9e8c-3b957efe69fa" alt="Ícone indicando o sistema operacional Linux">

> Instale o docker engine de acordo com o [manual oficial](https://docs.docker.com/engine/install/) e [instale e configure o kubernetes](https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/)

<img width="20" src="https://user-images.githubusercontent.com/25181517/186884152-ae609cca-8cf1-4175-8d60-1ce1fa078ca2.png" alt="Ícone indicando o sistema operacional MacOS">

> Instale o Docker Desktop de acordo com o [manual oficial](https://docs.docker.com/desktop/install/mac-install/) e [instale e habilite o kubernetes](https://docs.docker.com/desktop/kubernetes/)

#### Rode a aplicação

1º Aplique as configurações da aplicação no K8S estando na pasta do projeto
```bash
kubectl apply -f ./infra/k8s
```
A inicialização deve levar de 5 a 10 minutos

2º Para abrir o swagger no navegador, obtenha o a porta de saída da aplicação através do comando:

```bash
kubectl get service lanchonete-api
```
_Caso esteja rodando em alguma Cloud este comando será útil para obter o endereço externo da aplicação_

3º Após a utilização, caso deseje remover todas as configurações da aplicação, poderá executar:
```bash
kubectl delete -f ./infra/k8s
```

## Event Storming

Ilustrou-se o processo do negócio através do [**Event Storming**](assets/event-storming).

O primeiro passo foi o brainstorm, onde foram levantados os eventos do domínio abordado.

<p align = "center">
  <img src = assets/event-storming/Brainstorming.svg>
</p>

Em seguida, organizou-se os eventos na linha do tempo para os seguintes fluxos:

- Realização do pedido e pagamento:

<p align = "center">
  <img src = assets/event-storming/Pedido-pagamento.svg>
</p>

- Preparação e entrega do pedido:

<p align = "center">
  <img src = assets/event-storming/Preparacao-entrega.svg>
</p>
