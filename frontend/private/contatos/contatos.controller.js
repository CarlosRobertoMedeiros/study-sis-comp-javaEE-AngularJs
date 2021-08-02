(function(){
    'use strict';
    angular
        .module('sisComp')
        .controller('ContatosController',['ContatosService',ContatosController])

    function ContatosController(contatosService){
        const vm = this;
        
        vm.dados = [];
        vm.dadosCopiados = [];
        vm.dadosOperadoras = [];
        vm.mensagem = undefined;
        vm.icIncluir = true;
        vm.contato = undefined;
        
        vm.init = function(){

            vm.dados = [];
            vm.dadosCopiados = [];
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
                            vm.dadosCopiados = angular.copy(vm.dados);

                        },function(error){
                            console.log('error '+error)
                        }
                        
                    )
        };

        vm.reset = function(contatoForm){
            if (contatoForm!=undefined){
                contatoForm.$setPristine(true);
            }
            vm.contato = undefined;
            vm.dados = vm.dadosCopiados;
        }

        vm.prepararInclusaoContato = function(){
            vm.reset();
            vm.icIncluir = true;
            vm.contato = undefined;
            
            contatosService.listarTodasOperadoras()
                .then(function(response){
                        vm.dadosOperadoras = [];
                        vm.dadosOperadoras = response.data;
                        $('#modalAlterarContato').modal('show');
                    },function(error){
                        console.log('error '+error)
                    }
                )
        
        };

        vm.incluirContato = function(){
            
            console.log('Incluir '+ vm.contato);
            
            contatosService.incluirContato(vm.contato)
                .then(function(response){
                        vm.dados = [];
                        vm.dados =  response.data;
                        vm.listarTodos();
                         $('#modalAlterarContato').modal('hide');
                    },function(error){
                        if (error.data){
                            vm.mensagem = error;
                            $('#modalContatoMensagem').modal('show');
                        }
                    }
                )
        };
        
        
        vm.prepararAlteracaoContato = function(contato){
            vm.reset();
            vm.icIncluir = false;
            vm.contato = contato;
            
            vm.contato.dataNascimento = new Date(vm.contato.dataNascimento.substr(0,4),vm.contato.dataNascimento.substr(5,2)-1, vm.contato.dataNascimento.substr(8,2));
            
            contatosService.listarTodasOperadoras()
                    .then(function(response){
                    
                        vm.dadosOperadoras.operadoras = [];
                        vm.dadosOperadoras.operadoras = response.data.operadoras;

                        //Pesquisar as Operadoras e Retornar Pelo Nome do contato selecionado
                        //vm.minhaOperadora = vm.dadosOperadoras.operadoras[2];
                        for (let i=0; i< vm.dadosOperadoras.operadoras.length; i++){
                            if (vm.dadosOperadoras.operadoras[i].nomeOperadora === contato.operadora.nomeOperadora){
                                vm.minhaOperadora = vm.dadosOperadoras.operadoras[i];       
                                break;
                            }
                        }
                        $('#modalAlterarContato').modal('show');
                    },function(error){
                        console.log('error '+error)
                    }   
                );
            console.log('alterar' + JSON.stringify(contato.operadora));
        };

        //TODO: verificar a alteração
        vm.alterarContato = function(){
            console.log(vm.contato);
            contatosService.alterarContato(vm.contato)
                .then(function(response){
                        vm.dados = [];
                        vm.dados =  response.data;
                        vm.dados.dataNascimento = new Date(vm.dados.dataNascimento.getFullYear(),("0"+(vm.dados.dataNascimento.getMonth()+1).slice(-2)),vm.dados.dataNascimento.getDay()); // convert filed to date
                        console.log("Aqui " + vm.dados.dataNascimento);
                        vm.listarTodos();
                        $('#modalAlterarContato').modal('hide');
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