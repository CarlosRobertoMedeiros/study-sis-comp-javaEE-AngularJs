(function() {

  var app = angular.module('app');

  app.controller('route2ctrl', ['$scope',
    function($scope) {

      $scope.things = ["A", "Set", "Of", "Things"];
    }
  ]);
})();