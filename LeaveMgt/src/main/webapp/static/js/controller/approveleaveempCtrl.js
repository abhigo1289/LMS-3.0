'use strict';

App.controller('approveleaveempCtrl', ['$scope', '$state', 'EmpService', function(scope, state, empService){
//	Cancel button
	$(".btn-warning").click(function(){
        $(".collapse").collapse('hide');
    });
	
	/*
	var promise = empService.getEmpdetails(id);
	
	promise.then(
			function(response){
				scope.emp = response.data;
				console.log("");
			},
			function(error){
				scope.errorMessage = error.statusText;
			}
		);
	*/
}]);