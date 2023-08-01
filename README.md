# Sistema de Gestão de Funcionários
Bem-vindo ao Sistema de Gestão de Funcionários! Nossa API é uma poderosa ferramenta para simplificar e otimizar a gestão dos colaboradores da sua empresa. Com recursos modernos e seguros, oferecemos uma experiência inovadora e eficiente para administrar as informações dos funcionários.
### Pré-requisitos
O que você precisa instalar para rodar o projeto?
* [Gradle](https://https://gradle.org//)
* [JDK-17](https://www.oracle.com/technetwork/pt/java/javase/downloadsjdk8-downloads-2133151.html)
* [JRE-17](https://www.oracle.com/technetwork/pt/java/javase/downloadsjre8-downloads-2133155.html)
### Instalação
```
 git@github.com:jorgecamposdevs/Sistema-de-Gest-o-de-Funcion-rios.git
```
### Como rodar a API
```
./gradlew bootRun 
```
## Como rodar a API em dev
 ```
 * sudo sh docker-compose-dev.sh 
* sh docker-compose-dev.sh 
 ```
### Como rodar os testes?
```
./gradlew clean test 
```
### Para acessar a documentação do Swagger:
```
http://localhost:8080/swagger-ui/index.html
```
## Tecnologias utilizadas
* [Gradle](https://gradle.org/) - Gerenciamento de Dependência
* [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) - Starter para construção de web, incluindo aplicativos RESTful, usando o Spring MVC. Usa o Tomcat como o contêiner incorporado padrão
* [Swagger](https://https://swagger.io/) - Simplifique o desenvolvimento de API para usuários, equipes e empresas com o software livre Swagger e o conjunto de ferramentas profissionais. Descubra como o Swagger pode ajudá-lo a projetar e documentar suas APIs em escala.
* [Spring Boot Test Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test) - Starter para testar aplicativos Spring Boot com bibliotecas, incluindo JUnit, Hamcrest e Mockito.
* [Model Mapper](http://modelmapper.org/) - Os aplicativos geralmente consistem em modelos de objetos semelhantes, mas diferentes, em que os dados em dois modelos podem ser semelhantes, mas a estrutura e as preocupações dos modelos são diferentes. O mapeamento de objetos facilita a conversão de um modelo em outro, permitindo que modelos separados permaneçam segregados.
* [MongoDB](https://https://www.mongodb.com//) - O MongoDB é um banco de dados distribuído, baseado em documentos e de propósito geral, criado para desenvolvedores de aplicativos modernos e para a era da nuvem.