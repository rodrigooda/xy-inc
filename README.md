# xy-inc
Projeto xy-inc
----------------
Arquitetura
---------------
Gerenciador de compilação e dependência
Gradle por ser uma ferramento robusta e com diversidade de tasks

Persistência
Banco de dados relacional
MySQL por ser robusto com boa documentação e eficiente

Back-End
Spring Framework por ser um framework robusto e bem conhecido, e pela diversidade de ferramentas e frameworks disponíveis para qualquer necessidade

Front-End
Angular 6 por ser uma nova tecnologia com base forte desde o Angular 2, robusto, com grande participação da comunidade

Tratamento de exceções
	
Build
Docker devido a redução do consumo de recursos e para mater configuração e as biblioteca da aplicação, isoladas de outras aplicações, evitando conflitos
Persistência utilizando docker	
Gitlab CI para automatizar o processo de build

Deploy
Gitlab CI para automatizar o processo de build

Passos para rodar

No diretorio raiz:
1 - subir o docker do banco de dados com
 docker-compose up;
2 - fazer o build da aplicação com
./gradlew buildAll
3 - subir a aplicação com
java -jar backend/buil/libs/app-0.0.1-SNAPSHOT.jar
