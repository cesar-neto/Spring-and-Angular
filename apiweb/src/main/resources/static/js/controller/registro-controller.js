appCliente.controller("registroController", function($scope, $http){
	
	$scope.usuario = {};
	
	$scope.cadastrar = function(){
		$http({
			  method: 'POST',
			  url: 'http://localhost:8080/usuarios/',
			  data: $scope.usuario
			}).then(function successCallback(response) {
			    console.log(response.data);
			    console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.data);
				  console.log(response.status);
			  });
		};
	
	
});