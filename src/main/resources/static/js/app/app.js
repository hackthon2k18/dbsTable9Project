/**
 * 
 */


var app = angular.module('studentApp', ['ngRoute']);

app.config(function ($routeProvider) {
    
    $routeProvider.when('/getData', {
    	 templateUrl : "StudentResult.html",
    })
    .when('/', {
    	 templateUrl : "login.html",
    })
    .when('/invalidUser', {
    	 templateUrl : "invalidUser.html",
    })
    .when('/details', {
    	 templateUrl : "admin_StudentDetails.html",
    })
    .when('/marks', {
    	templateUrl : "admin_StudentMarks.html"
    });
});

app.controller("StudentCtrl",
		function($scope, $http,$location) {	
			$scope.loginForm = function(login){
				
				console.log("iam in loginForm");
				$scope.id = login.id;
				$scope.password =  login.password;
				
				var user = {
						id   		: login.id,
						password    : login.password,
						};
				console.log(user);
				console.log("hii");
				$http({
					method : 'POST',
					url    : 'http://localhost:8080/studentResult/login',					
					data   : user
				}).then(function(response){
					   console.log("--------------------");
					   console.log(response.data.response);
					   if(response.data.response == "Unauthorised User")
						   {
						   /*$window.location.href = '/invalidUser.html';*/
						   $scope.res = response.data.response;
						   $location.path('/')
						   
						   console.log("success"+f);
						   
						   }
					   else if(response.data.response == "Admin login")
						   {
						  /* $window.location.href = '/admin_StudentDetails.html';*/
						   $scope.admin = 5;
						   console.log($scope.admin);
						   $location.path('/details')
						   console.log("iam here");
						   }
					   else if( response.data.response  == "Valid User")
						   {
						   console.log("id is----------:"+$scope.id);
						   
						   
						   
						   $scope.getMarksById($scope.id);
						   }
					   console.log("--------------------");
				});
			} 
			
	
			$scope.getMarksById = function(studentId){
				$http({
					method : 'GET',
					url : 'http://localhost:8080/marks/getone/'+studentId
				}).then((response)=>{
					console.log("iam in" );
					$scope.marksById = response.data;
					
					$location.path('/getData')
					
					console.log($scope.marksById);
					
					
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
					$location.path('/marks')
				})
			}
			
			$scope.getAll = function(){
				$http({
					method : 'GET',
					url : 'http://localhost:8080/register/findAll'
				}).then((response)=>{
					$scope.items = response.data.students;
					console.log($scope.items);
				})
				.catch(()=>{
					console.log('error');
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
				$scope.editStudent = function(student)
				{
					console.log(student);
					var stu = {"id": student.id, "name": student.name, "password": student.password, "branch": student.branch, "dob":student.dob,"address":student.address };
					$scope.editStudentObject = stu;
					$scope.getAll();
					/*$scope.list.forEach((element)=>{
						if(element.id == studentId )
							{
							$scope.editStudentObject = element;
							console.log($scope.editStudentObject);
							}
					}) */ 
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
						//$location.path('/index.html');
					//	$window.location.href = '/admin_StudentDetails.html';
						$scope.getAll();
					})
				}
				
				$scope.addStudent = function(addStudentObject)
				{
					console.log("----------");
					console.log(addStudentObject);
					console.log("---------------------");
					$http({
						
						url : 'http://localhost:8080/register/insert',
						method : 'POST',
						data : addStudentObject
						
					}).then((response)=>{
					
						console.log(response.data);
						addStudentObject = null;
						$scope.getAll();
					})
					
				}
		} );


/*
 * app.service('StudentResultService',[ '$http', function($http) {
 * console.log("service"); $scope.getAllMarks = function(){ return $http({
 * method : 'GET', url : 'http://localhost:8080/marks/getallmarks' }); } }]);
 */
