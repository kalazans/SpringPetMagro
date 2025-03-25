<h1> ola senhores, primera api testando os conceitos e apredendo</h1>
<p>Explicaçao da api vai ser posr pastas e funcionalidades</p>
<ul><li>Pasta:Controler -> fica o AnimalController que rebece todas as requisições Rest</li>
<li>Pasta:Cors -> Configuranto.class ta sem o mapemanto pos a api roda no localhost que o spring sobe, n tem html ainda</li></LI>
<li>Pasta:DTO ->  fica todos os DTOS de recebimento de json e filtragem das infos das Entity no Banco para o Front, no caso nao mostraremos o endereço<br>
As valições das infos recebidas pelo Front, eu mesmo fiz em vez de usar o BeansValidation, para entender como funciona</li>
<li>Pasta:Infra -> Past:Exceptions -> fica as Exceptions do spring e as que eu criei<br>
AnimalControolerAdvice.class faz o catch de todas as exceçoes lançadas pelo RestController</li>
<li>Pasta:Model -> ficam todos os objetos da regra de negócio</li>
<li>Pasta:Repository -> fica o Repository que extende a JpaRepository e faz a conexao com o banco</li>
<li>Pasta:Services -> AnimalService.class responsavel por usar o repository para buscar no campo de dados<br>
ValidadorInfo.class faz toda as validaçoes do projeto, desde os DTOs virem null or blank, até os Models</li></ul>

<h2> Como usar  </h2>
<ul><li>POST localhost:8080/animal + um json no Body -> para insertir no banco</li>
<li> GET localhost:8080/animal/lista -> para pegar a lista de todos os Cadatrados</li>
<li>PUT localhost:8080/animal/{id} + json -> para atualizar um Animal pelo id! somente age & weight podem ser atualizados</li>
<li> DELETE localhost:8080/animal/{id} -> apaga de vez do banco de dados</li>
<li>GET localhost:8080/animal/{id} -> traz info de um animal pelo id</li>
<li>GET localhost:8080/animal/busca? -> temos 3 parametros tipo,raça,nome (primeiroNome do Animal), escolha somente 1 dos parametros e faça a busca<br>
EXCEMPLO:localhost:8080/animal/busca?tipo=gato, fiquei na duvida de como fazer a validaçao de todos e gerar buscas conjunta, vou ler mais sobre! </li></ul>

<p>Obs: tem um class de nome:a! ta la só pq quando criavaa pasta em pasta meio q conjuntava as pasta em 1 e bugava</p>
<p>Api bem cru, pra testar os conceitos e ver situaçoes e como resolver, como a do gerar busca conjuntas.<br>
Usei tudo que me lembro: RestControoller,RestControllerAdvice,Service,Repository,ResponseEntity, o core da api</p>


<p>quem for brincar com esta bomba, agradeço kkkkk talvez tenha falhas,provavelmente tem kkkkk aceito qualquer critica em relação ao codigo, irei melhorar,obrigado!</p>
