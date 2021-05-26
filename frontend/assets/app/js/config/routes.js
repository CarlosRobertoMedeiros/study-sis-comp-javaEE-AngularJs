(function (){
	angular
		.module('sisComp').config(['$stateProvider','urlRouterProvider',
			function($stateProvider, $urlRouterProvider){
			console.log("Entrei aqui");
			$stateProvider.state("dashboards",{
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
		}]).run(function($rootScope){

		});
  
})()

