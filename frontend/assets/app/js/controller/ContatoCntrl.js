(function(){
	'use strict';
	angular
		.module('sisComp') 
		.controller('ContatoCtrl',[ContatoCtrl]);

	function ContatoCtrl(){
		var mc = this;
		mc.mensagem = 'Minha Aplicação Principal';

		mc.init = function(){
			console.log('teste ContatoCtrl');

		};

		mc.init();
	}

})();