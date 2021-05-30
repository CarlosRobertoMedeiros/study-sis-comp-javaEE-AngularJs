(function(){
    
    'use strict';
    angular
      .module("app")
      .config(function($stateProvider, $urlRouterProvider){
        
        // For any unmatched url, send to /route1
        $urlRouterProvider.otherwise("route1")
        
        $stateProvider
          .state('route1', {
              url: "/route1",
              templateUrl: "private/assunto1/route1.html"
          })
            .state('route1.list', {
                url: "/list",
                templateUrl: "private/assunto1/route1.list.html",
                controller: "route1ctrl"
            })
            
          .state('route2', {
              url: "/route2",
              templateUrl: "private/assunto2/route2.html"
          })
            .state('route2.list', {
                url: "/list",
                templateUrl: "private/assunto2/route2.list.html",
                controller: "route2ctrl"
            })
      });
  
  
  
  })();