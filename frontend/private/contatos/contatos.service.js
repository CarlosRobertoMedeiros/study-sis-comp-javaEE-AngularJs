(function(){
   
    'use strict';
    angular
        .module('sisComp')
        .service('ContatosService',['$http',ContatosService])

    function ContatosService($http){
        const vm = this;
        vm.classBody;  

        const baseUrl = "http://localhost:8086/siscomp-api/api/";
        const baseVersao = "v1/";

        vm.listarTodos = function(){
            let url = baseUrl+baseVersao+"contatos";
            return $http.get(url);
        }
    }
})();