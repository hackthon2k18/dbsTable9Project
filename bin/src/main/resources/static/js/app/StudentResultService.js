/**
 * 
 */
app.service('StudentResultService',[ '$http', function($http) {
	this.getAllMarks =  function(){
		return $http({
			method : 'GET',
			url : 'http://localhost:8080/marks/getallmarks'
		});
	}
}]);