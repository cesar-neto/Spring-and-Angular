//criacao de controllers
appCliente.controller("clienteController", function($scope, $http){

	$scope.clientes = [];
	$scope.cliente = {};
	
	$scope.carregarClientes = function(){
		$http({
		  method: 'GET',
		  url: 'http://localhost:8080/clientes/'
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
		  url: 'http://localhost:8080/clientes/',
		  data: $scope.cliente
		}).then(function successCallback(response) {
		    //$scope.clientes.push(response.data);
			$scope.carregarClientes();
			$scope.cliente={};
			$scope.frmCliente.$setPristine(true);
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
		  url: 'http://localhost:8080/clientes/'+cliente.id
		}).then(function successCallback(response) {
		    $scope.clientes.splice(cliente.id-1,1);
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