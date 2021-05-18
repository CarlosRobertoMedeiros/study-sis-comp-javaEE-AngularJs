### First project developed in order to show variations of architectures using as back end Java and front end AngularJs

## Project Arch (1)
	- First Project Backend:  JAVAEE(7) Technology
	- First Project FrontEnd: AngularJS
	- Application Server Wildfly 18

## Owner

	- Carlos Roberto Medeiros de Lima

### Tools and Technologies Used ###
	
	#Backend 
		- Maven
		- JavaEE 7 
			- Jax-Rs 2
			- Ejb 3.2
			- Jpa 2
		- Swagger 1.5

	#Backend Test
		- Junit 4 (Unit Test)
		- Rest Assured (Api Test)
		
	#Backend API Documentation
		SWAGGER: http://localhost:8086/siscomp-api/
		
		GET:     http://localhost:8086/siscomp-api/api/v1/contatos/contatos-paginados?totalRegistrosPorPagina=4&paginaAtual=2
		GET:     http://localhost:8086/siscomp-api/api/v1/contatos
		GET:     http://localhost:8086/siscomp-api/api/v1/contatos/4
		POST:    http://localhost:8086/siscomp-api/api/v1/contatos
		PUT:     http://localhost:8086/siscomp-api/api/v1/contatos/11
		DELETE:  http://localhost:8086/siscomp-api/api/v1/contatos/11
		
		GET:     http://localhost:8086/siscomp-api/api/v1/sisinfo
		
	#DataBase
		The database's Oracle 11g, wrapper in a Docker Container
		Use the docker-compose up to start the database, dont´t forget to put the enviroment variable to PWD.
		
	#Front End
		* To emulate the Front End use: http-server
		- Gulp (in progress)
		- Bootstrap 4 (in progress)
		- AngularJS 1.6.4 (in progress)

    # In the Future
	
	Tecnologias Utilizadas
	
	- Para o SSO utiliza-se o KeyCloack 
		- Oauth 2 
		- JWT
		- ClientCredentials Flow