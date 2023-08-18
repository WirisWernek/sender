# sender

## Como criar sua senha de app no Gmail ?

https://support.google.com/accounts/answer/185833?hl=pt-BR


## Como fazer o build?
docker build -t sender:versao_da_imagem localizacao_dockerfile

Ex: `docker build -t sender:1.1 .`


## Como criar a sua network do docker local?
docker network create your_network_name

Ex: `docker network create minha_rede`


## Para conectar um container a network, caso já tenha ele criado

`docker network connect networkname containername`

Ex: `docker network connect local postgresserver`


## Como executar o container?

`docker container run -d --name sender -p 8080:8080 --network younetwork -e POSTGRES_USER=postgres -e POSTGRES_SERVER=postgresserver -e POSTGRES_PASSWORD=postgres -e GMAIL_USERNAME=youremail -e GMAIL_PASSWORD=yourapppassword sender:versao_da_imagem`


## Criando o container do banco de dados já com a network
`docker run --name postgresserver --network younetwork -e POSTGRES_PASSWORD=your_password_here -e POSTGRES_DB=senderdb -p 5432:5432 -d postgres:latest`