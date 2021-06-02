(function(){
   
    'use strict';
    angular
        .module('sisComp')
        .controller('ContatosController',['ContatosService',ContatosController])

    function ContatosController(contatosService){
        const vm = this;
        vm.dados = [];

        vm.listarTodos = function(){

            contatosService.listarTodos()
                .then(function(response){
                            vm.dados = [];
                            vm.dados =  response.data;
                        },function(error){
                            console.log('error '+error)
                        }
                    )
        };

        vm.listarTodos(); 

    }

})();

//https://code.angularjs.org/1.6.4/docs/api/ng/service/$http#
//Lendo essa referência 