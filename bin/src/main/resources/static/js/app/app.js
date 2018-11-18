/**
 * 
 */

var app = angular.module('studentApp', []);
app.controller('StudentCtrl', [ '$scope','$http',
		function($scope, $http, $stateParams, $state) {	
			$scope.loginForm = function(t){
				var user = {
						id   		: t.id,
						password    : t.password,
						};
				/*$scope.editedArrayDetails = [];
                $scope.editedArrayDetails.push(t);
                $scope.json = angular.toJson(t);
                console.log($scope.json );*/
				console.log(angular.toJson(user || '{}'));
				$http({
					method : 'POST',
					url    : 'http://localhost:8080/studentResult/login',					
					data   : angular.toJson(user || '{ }')
				}).then(function(response){
					   console.log("in");
					   console.log(response.data);
				});
			} 
	
			$scope.getAllMarks = function() {
				 $http({
					method : 'GET',
					url : 'http://localhost:8080/marks/getallmarks'
				}).then(function success(response) {
					$scope.marks = response.data;
					console.log(response);
					$scope.message = 'getting all marks';
					$scope.errorMessage = '';
				}, function error(response) {
					$scope.message = '';
					$scope.errorMessage = 'Error getting users!';
				});
			}
			
			$scope.editMarks = function(marks){
				//var id = $scope.m.id;
				//console.log(marks.id);
				
				$scope.update = {"id":marks.id,"name":marks.name,"c":marks.c,"java":marks.java,"python":marks.python,"linux":marks.linux}
				console.log($scope.update);
				$scope.updates = $scope.update
				}
			
			$scope.updateMarks = function(updateMark){
				//console.log($scope.updateMark);
				$http({
					method : 'PUT',
					url : 'http://localhost:8080/marks/update/'+updateMark.id,
					data : updateMark
					
				}).then((response)=>{
					//console.log(response.data);
					$scope.getAllMarks();
				})
			}
			
			$scope.getAll = function(){
				$http({
					url : 'http://localhost:8080/register/findById/4',
					method : 'GET'
				}).then((response)=>{
					$scope.list = response.data;
					console.log($scope.list);
				})
				.catch(()=>{
					
				});
				}
				//$scope.getAll();
				$scope.deleteThisStudent = function(studentId){
					$http({
						url : 'http://localhost:8080/register/delete/'+studentId,
						method : 'DELETE'
					}).then((response)=>{
						console.log(response);
						$scope.getAll();
					});
				}
				$scope.editStudent = function(studentId)
				{
					$scope.list.forEach((element)=>{
						if(element.id == studentId )
							{
							$scope.editStudentObject = element;
							console.log($scope.editStudentObject);
							}
					})  
					
					
				}
				
				$scope.updateStudent = function()
				{
			/* 		console.log("ready to update");
					console.log($scope.editStudentObject); */
					$http({
						url : 'http://localhost:8080/register/update/'+$scope.editStudentObject.id,
						method : 'PUT',
						data : $scope.editStudentObject
						
					}).then((response)=>{
						console.log(response);
					})
				}
				
				$scope.addStudent = function()
				{
					$http({
						
						url : 'http://localhost:8080/register/insert',
						method : 'POST',
						data : $scope.addStudentObject
						
					}).then((response)=>{
						console.log(response.data);
						$scope.addStudentObject = null;
						$scope.getAll();
					})
					
				}
		} ]);

/*
 * app.service('StudentResultService',[ '$http', function($http) {
 * console.log("service"); $scope.getAllMarks = function(){ return $http({
 * method : 'GET', url : 'http://localhost:8080/marks/getallmarks' }); } }]);
 */
