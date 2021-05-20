(function (){
	angular
		.module("sisComp")
		.config(function($stateProvider, $urlRouterProvider, $locationProvider){
			
			$stateProvider.state("index",{
				url: "index",
				template: "<h1>Testei o Template 1</h1>"	
			}).state("dashboards", {
				url: "/dashboards",
				templateUrl: "private/dashboard/listar.dashboard.html"
			});
				
				/*
				.state
					({
						name: 'dashboard',
						url: '/dashboard',
						templateUrl: 'private/dashboard/listar.dashboard.html'
					})
				.state
					({
						name: 'marcasprodutos',
						url: '/marcasprodutos',
						templateUrl: 'private/marcas-e-produtos/listar.marcas-produtos.html'
					})
				.state
					({
						name: 'contatos',
						url: '/contatos',
						templateUrl: 'private/contatos/listar.contatos.html'
					})
					*/

				$urlRouterProvider.otherwise("private/dashboard/listar.dashboard.html");
				//$locationProvider.html5Mode(true);
		});
  
})()

