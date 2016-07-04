'use strict';
//Cancel Button	
$(".btn-warning").click(function(){
    $(".collapse").collapse('hide');
});

App.controller('newleaveCtrl', ['$scope', '$state', 'EmpService', function(scope, state, empService){
	
//	Cancel Button	
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