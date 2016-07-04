'use strict';
	
	var App = angular.module('lmsApp',['ui.router']);
	
	App.config(['$stateProvider', '$urlRouterProvider', function(sp, urp){
		urp.otherwise('/empdetails');
		
		sp
			.state('empdetails', {
				url: '/empdetails',
				templateUrl: 'empdetails',
				controller: 'empdetailsCtrl'
			})
			
			.state('empdetails.newleave', {
				url: '/newleave',
				templateUrl: 'new_leave',
				controller: 'newleaveCtrl'
			})
			
			.state('empdetails.approvedleave', {
				url: '/approvedleave',
				templateUrl: 'approved_leave',
				controller: 'approvedleaveCtrl'
			})
			
			.state('empdetails.newemp', {
				url: '/newemp',
				templateUrl: 'new_emp',
				controller: 'newempCtrl'
			})
			
			.state('empdetails.approveleaveemp', {
				url: '/approveleaveemp',
				templateUrl: 'approve_leave_emp',
				controller: 'approveleaveempCtrl'
			})
			
			.state('empdetails.blank', {
				url: '/blank',
				templateUrl: 'blank'
			});
	}]);

	
		