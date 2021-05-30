(function(){
   
    'use strict';
    angular
        .module('sisComp')
        .controller('ContatosController',['ContatosService',ContatosController]);

    function ContatosController(contatosService){
        const vm = this;

        vm.listarTodos = function(){

            contatosService.listarTodos()
                .then(function(response){
                            response.data;
                            console.log(response.data)
                        },function(error){
                            console.log('error '+error)
                        }
                    )
        };

    }

})();

//https://code.angularjs.org/1.6.4/docs/api/ng/service/$http#
//Lendo essa referência 