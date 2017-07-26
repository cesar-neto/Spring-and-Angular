appCliente.controller("clienteDetalheController", function($scope, $routeParams, $http){

	$scope.cliente = {};
	
	$scope.tags = [
	               { text: 'Html' },
	               { text: 'Java' },
	               { text: 'C#' },
	               { text: 'Django' },
	               { text: 'Angular' },
	               { text: 'Swagger' },
	               { text: 'JavaScript' },
	               { text: 'Python' },
	               { text: 'React' },
	               { text: 'Css' }
	             ];
	
	$scope.loadTags = function(query) {
        return $http.get('/tags?query=' + query);
   };
	
	$http.get("admin/clientes/"+$routeParams.clienteId).then(function(response){
		
		$scope.cliente = response.data;
	}),(function(response){
		
	});
	
});