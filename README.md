# taegro
Meu teste 

Tecnologias.

SpringBoot
H2
JPA
Junit
SpringBootTest

Links 

Documentação e teste da API 

http://localhost:8080/swagger-ui.html#/

Fazenda-controller requer autenticação via token . 
usuario : usuario@email.com
senha : 123456

Detalhes dos métodos 

/fazenda/lista 
Lista todas as fazendas e dados , ou se tiver o parametro id vai exibir informações de uma fazenda. 

/fazenda/listatalhoes 
Lista talhoes da fazenda passada como parámetro. 

/fazenda/novoregistro 
Cadastrar um novo registro para um talhão 

/fazenda/prodtalhao
Exibe o calculo da produção de um talhão 


/fazenda/prodtotalfazenda
Exibe a lista de fazendas e sua produção total . 


Dados inseridos automaticamente na base para teste  . 

Fazendas 

id =1
nome= Fazenda_1

id =2 
nome =Fazenda_2

Talhao

id=1
area = 100
fazenda = 1

id=2
area = 200
fazenda = 1 

id=2
area = 120
fazenda = 2

id=3
area = 220
fazenda = 2 

Registros

registro =10
talhao_id = 1 

registro =20
talhao_id = 2

registro =30
talhao_id = 3

registro =40
talhao_id = 4

