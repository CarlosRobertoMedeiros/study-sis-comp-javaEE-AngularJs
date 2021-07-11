(function(){
    'use strict';

    angular
        .module('sisComp')
        .controller('OperadorasController',['OperadorasService',OperadorasController]);

    function OperadorasController(operadorasService){
        const vm = this;
        
        vm.dadosOperadoras = [];

        vm.listarTodasOperadoras = function(){

            operadorasService.listarTodas()
                .then(function(response){
                        vm.dadosOperadoras = [];
                        vm.dadosOperadoras =  response.data;
                        //$('#modalAlterarContato').modal('show');
                    },function(error){
                        console.log('error '+error)
                    }
                )   
        }



    }





})();