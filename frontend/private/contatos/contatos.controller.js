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
        
        vm.init = function(){

            vm.dados = [];
            vm.mensagem = undefined;
            vm.icIncluir = true;
            vm.contato = undefined;

            vm.listarTodos(); 
        }
        
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
            
            contatosService.listarTodasOperadoras()
                .then(function(response){
                        vm.dados = [];
                        vm.dados =  response.data;
                        $('#modalAlterarContato').modal('show');
                    },function(error){
                        console.log('error '+error)
                    }
                )
        };

        vm.incluirContato = function(){
            
            contatosService.incluirContato(vm.contato)
                .then(function(response){
                        vm.dados = [];
                        vm.dados =  response.data;
                        vm.listarTodos();
                    },function(error){
                        if (error.data){
                            vm.mensagem = error;
                            $('#modalContatoMensagem').modal('show');
                        }
                    }
                )
        };
        
        
        vm.prepararAlteracaoContato = function(contato){
            vm.icIncluir = false;
            vm.contato = contato;
            
            contatosService.listarTodasOperadoras()
                .then(function(response){
                        vm.dados = [];
                        vm.dados =  response.data;
                        $('#modalAlterarContato').modal('show');
                    },function(error){
                        console.log('error '+error)
                    }
                )
            
            //Posicionar a lista no contato existente
            
        };

        //TODO: verificar a alteração
        vm.alterarContato = function(){
            
            contatosService.alterarContato(vm.contato)
                .then(function(response){
                        vm.dados = [];
                        vm.dados =  response.data;
                        vm.listarTodos();
                    },function(error){
                        if (error.data){
                            vm.mensagem = error;
                            $('#modalContatoMensagem').modal('show');
                        }
                    }
                )
        };

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
        
        
        vm.init();
       
    }
   
})();

//https://code.angularjs.org/1.6.4/docs/api/ng/service/$http#
//Lendo essa referência 