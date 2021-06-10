(function(){
   
    'use strict';
    angular
        .module('sisComp')
        .service('ContatosService',['$http',ContatosService])

    function ContatosService($http){
        const vm = this;
        vm.classBody;  

        
        const baseUrl = "http://localhost:8080/siscomp-api/api/";
        const baseVersao = "v1/";

        vm.listarTodos = function(){
            let url = baseUrl+baseVersao+"contatos";
            return $http.get(url);
        }

        vm.excluirContato = function(contato){
            console.log(JSON.stringify(contato));
            let url = baseUrl+baseVersao+"contatos"+"/"+contato.idContato;
            return $http({
                    url: url,
                    method: "DELETE"
                });
        }
    }
})();