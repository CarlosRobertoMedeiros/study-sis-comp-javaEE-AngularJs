(function(){
   
    'use strict';
    angular
        .module('sisComp')
        .controller('ContatosController',['ContatosService',ContatosController])

    let vm = undefined;
    

    function ContatosController(contatosService){
        vm = this;
        vm.listarTodos = function(){

            contatosService.listarTodos()
                .then(function(response){
                            vm.dados = [];
                            vm.dados =  response.data;
                        },function(error){
                            console.log('error '+error)
                        }
                        
                    )
                    return vm.dados;
        };

        //vm.listarTodos(); 
        
        
        
    }
    ContatosController.prototype.listaTodos = function(){
        return vm.listarTodos();
    };
    
})();

//https://code.angularjs.org/1.6.4/docs/api/ng/service/$http#
//Lendo essa referência 