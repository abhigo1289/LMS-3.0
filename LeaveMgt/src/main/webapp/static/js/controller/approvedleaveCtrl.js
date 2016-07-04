'use strict';

App.controller('approvedleaveCtrl', ['$scope', '$state', 'EmpService', function(scope, state, empService){
//	Cancel button
	$(".btn-warning").click(function(){
        $(".collapse").collapse('hide');
    });
	
	
	var promise = empService.getEmpApprovedLeaves(id);
	
//	Fills Emp Leaves Approved table
	promise.then(
			function(response){
				scope.empLeaves = response.data;
				console.log("Employee Approved leaves retrieved");
			},
			function(error){
				alert(error.statusText);
			}
		);
	
//	Delete function
	scope.deleteEmpLeave = function(startDate){
		var yes = confirm("Delete Employee leave with start date "+startDate);
		if(yes){
			empService.deleteEmpLeave().then(
					function(response){
						scope.empLeaves = response.data;
						console.log("Employee Approved leaves retrieved");
						alert("Deleted Emp Leave record");
					},
					function(error){
						alert(error.statusText);
					}
				);
		}
	};
	
	
}]);