(function(){
    'use strict';

    angular
        .module('sisComp')
        .config(function($stateProvider, $urlRouterProvider){

            // For any unmatched url, send to /dashboard
            $urlRouterProvider.otherwise("dashboard")

            $stateProvider
                .state('dashboard', {
                    url: "/dashboard",
                    templateUrl: "private/dashboard/listar.dashboard.html"
                })
                /*
                .state('route1.list', {
                    url: "/list",
                    templateUrl: "private/assunto1/route1.list.html",
                    controller: "route1ctrl"
                })
                */
                
                .state('contatos', {
                    url: "/contatos",
                    templateUrl: "private/contatos/listar.contatos.html"
                })
                /*
                .state('route2.list', {
                    url: "/list",
                    templateUrl: "private/assunto2/route2.list.html",
                    controller: "route2ctrl"
                })
                */
                .state('marcas', {
                    url: "/marcaseprodutos",
                    templateUrl: "private/marcas-e-produtos/listar.marcas-produtos.html"
                })
        });
})();