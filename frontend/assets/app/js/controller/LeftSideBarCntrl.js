(function(){
    'use strict';
    angular
        .module('sisComp', ['ui.router'])
        .controller('LeftSideBarCntrl',[LeftSideBarCntrl]);

        function LeftSideBarCntrl($rootScope){
            var sbc = this;
    
            sbc.isLinkAtivo = function(viewLocation){
              return false;
              //  console.log($rootScope.$state);
              //  if (viewLocation === 'dashboard'){return 'active'};
            }
    
        }
})();

//Olhar a Partir desse Link
//https://stackoverflow.com/questions/25370775/exposing-the-current-state-name-with-ui-router