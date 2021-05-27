(function (){
	'use strict';
	angular
		.module('sisComp').config(['$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
		  $routeProvider
			.when('/dashboards', {
			  templateUrl: 'private/dashboard/listar.dashboard.html'
			})
			/*
			.when('/Book/:bookId/ch/:chapterId', {
			  templateUrl: 'chapter.html',
			  controller: 'ChapterCtrl',
			  controllerAs: 'chapter'
			});
			*/
	  
		  $locationProvider.html5Mode(true);


						//$urlRouterProvider.otherwise("private/dashboard/listar.dashboard.html");
				//$locationProvider.html5Mode(true);
		}])					
})()