(function(){

    'use strict';
    angular
        .module('sisComp')
        .service('OperadorasService',['$http',OperadorasService])

    function OperadorasService($http){
        const vm = this;
        vm.classBody;  

        const baseUrl = "http://localhost:8080/siscomp-api/api/";
        const baseVersao = "v1/";

        vm.listarTodas = function(){
            let url = baseUrl+baseVersao+"operadoras";
            return $http.get(url);
        }
    }

})();