(function(){
	'use strict';
	angular
		.module('sisComp')
		.controller('ConfiguracaoCntrl',[ConfiguracaoCntrl]);

	function ConfiguracaoCntrl(){
		const vm = this;
		vm.tituloProjeto = 'SisComp - Sistema Completo';
		
	};
	

})();