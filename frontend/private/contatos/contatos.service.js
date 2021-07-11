(function(){
   
    'use strict';
    angular
        .module('sisComp')
        .service('ContatosService',['$http','OperadorasService',ContatosService])

    function ContatosService($http,operadorasService){
        const vm = this;
        vm.classBody;  

        
        const baseUrl = "http://localhost:8080/siscomp-api/api/";
        const baseVersao = "v1/";

        vm.listarTodos = function(){
            let url = baseUrl+baseVersao+"contatos";
            return $http.get(url);
        }

        
        vm.listarTodasOperadoras = function(){
            return operadorasService.listarTodas();
        }
        

        vm.incluirContato = function(contato){
            console.log(JSON.stringify(contato));
            let url = baseUrl+baseVersao+"contatos";
            return $http({
                    url: url,
                    method: "POST",
                    data: contato
                });
        }

        vm.alterarContato = function(contato){
            console.log(JSON.stringify(contato));
            let url = baseUrl+baseVersao+"contatos";
            return $http({
                    url: url,
                    method: "PUT",
                    data: contato
                });
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