//criacao de controllers
appCliente.controller("clienteController", function($scope, $http){

	$scope.clientes = [];
	$scope.cliente = {};
	
	$scope.carregarClientes = function(){
		
		token = localStorage.getItem("userToken");
		$http.defaults.headers.common.Authorization = "Bearer "+token;
		
		$http({
		  method: 'GET',
		  url: 'http://localhost:8080/admin/clientes/'
		}).then(function successCallback(response) {
		    $scope.clientes=response.data;
		    console.log(response.data);
		    console.log(response.status);
		  }, function errorCallback(response) {
			  console.log(response.data);
			  console.log(response.status);
		  });
	};
	
	$scope.carregarClientes();
	
	$scope.salvarCliente = function(){
		$http({
			  method: 'POST',
			  url: 'http://localhost:8080/admin/clientes/',
			  data: $scope.cliente
			}).then(function successCallback(response) {
			    //$scope.clientes.push(response.data);
				$scope.carregarClientes();
				$scope.cliente={};
			    console.log(response.data);
			    console.log(response.status);
			  }, function errorCallback(response) {
				  console.log(response.data);
				  console.log(response.status);
			  });
		};
	
	
	
	$scope.excluirCliente = function(cliente){
		$http({
		  method: 'DELETE',
		  url: 'http://localhost:8080/admin/clientes/'+cliente.id
		}).then(function successCallback(response) {
		    $scope.clientes.splice(cliente.id-1,1);
		    $scope.carregarClientes();
			$scope.cliente={};
		    console.log(response.data);
		    console.log(response.status);
		  }, function errorCallback(response) {
			  console.log(response.data);
			  console.log(response.status);
		  });
	};
	
	$scope.cancelarEdicao = function(){
		$scope.cliente = {};		
		
	}
	
	$scope.editarCliente = function(cli){
		$scope.cliente = angular.copy(cli);
		
	};
	
});