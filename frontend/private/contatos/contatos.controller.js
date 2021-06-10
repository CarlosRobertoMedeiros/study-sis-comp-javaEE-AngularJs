(function(){
    'use strict';
    angular
        .module('sisComp')
        .controller('ContatosController',['ContatosService',ContatosController])

    function ContatosController(contatosService){
        const vm = this;
        
        vm.dados = [];
        vm.mensagem = undefined;
        vm.icIncluir = true;
        vm.contato = undefined;
        
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

        vm.prepararInclusaoContato = function(){
            vm.icIncluir = true;
            vm.contato = undefined;
            $('#modalAlterarContato').modal('show');
        };

        //TODO: Implementar a Inclusão
        vm.alterarContato = function(){
            //Aqui carregar a Lista de Operadoras
        
        };
        
        
        vm.prepararAlteracaoContato = function(contato){
            vm.icIncluir = false;
            vm.contato = contato;
            $('#modalAlterarContato').modal('show');
        };

        //TODO: Implementar a alteração
        vm.alterarContato = function(){

        }

        
        
        vm.prepararExclusaoContato = function(contato){
            vm.icIncluir = false;
            vm.contato = contato;
            $('#modalExcluirContato').modal('show');
        };

        vm.excluirContato = function(){
            contatosService.excluirContato(vm.contato)
                .then(function(response){
                        vm.mensagem = response.data;
                        $('#modalExcluirContato').modal('hide');
                        vm.listarTodos();
                    },function(error){
                        if (error.data){
                            vm.mensagem = error.data.deRetorno;
                            $('#modalContatoMensagem').modal('show');
                        }
                    }
                )
        };
        
        
        vm.listarTodos(); 
       
    }
   
})();

//https://code.angularjs.org/1.6.4/docs/api/ng/service/$http#
//Lendo essa referência 