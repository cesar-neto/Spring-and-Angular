appCliente.controller("loginController", function($scope, $http){
	
	$scope.usuario = {};
	$scope.token="";
	
	$scope.autenticar = function(){
		$http({
			  method: 'POST',
			  url: 'http://localhost:8080/autenticar/',
			  data: $scope.usuario
			}).then(function successCallback(response) {
				$scope.token = response.data.token;
				localStorage.setItem("userToken", response.data.token);
			    console.log(response.data);
			    console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.data);
				  console.log(response.status);
			  });
		};
	
	
});