'use strict';

App.controller('empdetailsCtrl', ['$scope', '$state', 'EmpService', function(scope, state, empService){
	
	var promise = empService.getEmpdetails(id);
	
	promise.then(
			function(response){
				scope.emp = response.data; //prints fetched data
				scope.empDetailsId = id; //prints empId
				console.log("Employee details retrived");
			},
			function(error){
				scope.errorMessage = error.statusText;
			}
		);
	//Button navigation
	scope.loadNewLeave = function(){
		$(".collapse").collapse('show');
		state.go('empdetails.newleave');
	}
	
	scope.loadApprovedLeaves = function(){
		$(".collapse").collapse('show');
		state.go('empdetails.approvedleave');
	}
	
	scope.loadNewEmp = function(){
		$(".collapse").collapse('show');
		state.go('empdetails.newemp');
	}
	
	scope.loadApproveLeaveEmp = function(){
		$(".collapse").collapse('show');
		state.go('empdetails.approveleaveemp');
	}
	
}]);