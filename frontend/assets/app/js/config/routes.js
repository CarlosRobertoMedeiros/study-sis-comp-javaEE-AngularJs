(function (){
	angular
		.module('sisComp')
		.config(function($stateProvider, $urlRouterProvider, $locationProvider){
			
			$urlRouterProvider.otherwise("private/dashboard/listar.dashboard.html");
			$stateProvider
				.state
					({
						name: 'index',
						url: '/index',
						templateUrl: 'private/dashboard/listar.dashboard.html'
					})
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
				$locationProvider.html5Mode(true);
		});
  
})()

