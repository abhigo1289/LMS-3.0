'use strict';

App.service('EmpService', ['$http', function(http){
	
	this.getEmpdetails = function(id){
		return http.get('emp/'+id);						
	};
	
	this.getEmpApprovedLeaves = function(id){
		return http.get('empleave/'+id)
	}
	
	this.deleteEmpLeave = function(id, startDate){
		var empLeave = {"empId":id,"startDate":startDate};
		return http({
		    method: 'POST',
		    url: 'empleavedelete/',
		    headers: {
		        'Content-Type': 'application/json', /*or whatever type is relevant */
		       
		    },
		    data: {"empId":id,"startDate":startDate}
		})
//		return http.put('empleavedelete/', empLeave);
	};
}]);