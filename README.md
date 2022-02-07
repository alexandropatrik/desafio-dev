# CNAB-DEMO

O projeto tem como objetivo permitir o upload de um arquivo CNAB, por meio de um formulário web, formatado no layout especificado.
Após o upload, o arquiqvo é salvo temporariamente no servidor local e é parseado. Ao término do parser, os dados são persistidos em um banco de dados PostgreSQL.
Na sequência o usuário é redirecionado para uma página que exibe as transações do banco de dados, agrupadas por loja, com o saldo da conta.

## Tecnologias
- Java 11
- Springboot 2.6.3
- PostgreSQL 14
- Flyway (para controlar as migrations)

## Execução

### Docker
Entrar na pasta do projeto e executar o docker-compose
```
# docker-compose up -d
```

A aplicação iniciará na porta ```8080```.
Basta acessar a URL no navegador: localhost:8080 que será apresentado o formulário de upload.

## Ambiente
- Utilizado o Spring Tools Suite STS 4.12
- JDK 11

Para compilar a aplicação, pode-se usar a seguinte instrução (dentro da pasta do projeto):

```
# mvn clean compile package
```

Para avaliar o código:
```
# mvn verify -Dsonar.login=xxx-af911ebadaead36306d150b1af6c45fd6119 sonar:sonar
```

Para executar a aplicação
```
# java -jar target/cnab-demo-0.0.1-SNAPSHOT.jar
```

Para criar a imagem:
```
# docker build --no-cache -t repositorio/cnab-demo:v1 .
```

Para publicar a imagem:
```
# docker push repositorio/cnab-demo:v1
```



## Parser
Foi desenvolvido uma classe abstrata que faz a leitura da linha e executa o parser conforme configuração. Assim, ao desenvolver novos parsers, basta estender a classe base do interpretador (```EDITextInterpreter```) e anotar os atributos ```(@EDITextField(start = x, end = y)) ```.

Assim como no exemplo:

```java
public class TransacaoFinanceiraDTO extends EDITextInterpreter implements Serializable {
    @EDITextField(start = 0, end = 1)
    private String tipoTransacao;
    @EDITextField(start = 1, end = 9)
    private String data;
    @EDITextField(start = 9, end = 19)
    private String valor;
    @EDITextField(start = 19, end = 30)
    private String cpf;
    @EDITextField(start = 30, end = 42)
    private String cartao;
    @EDITextField(start = 42, end = 48)
    private String hora;
    @EDITextField(start = 48, end = 62)
    private String dono;
    @EDITextField(start = 62, end = 80)
    private String loja;
}    
```

