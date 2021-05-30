(function(){
	'use strict';
	angular
		.module('app')
		.controller('route1ctrl',[Route1Ctrl]);

	function Route1Ctrl() {
		const rc = this;
		rc.items = ["A", "List", "Of", "Items"];
	}

})();