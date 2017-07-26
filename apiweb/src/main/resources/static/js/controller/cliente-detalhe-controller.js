appCliente.controller("clienteDetalheController", function($scope, $routeParams, $http){

	$scope.cliente = {};
	
	$scope.tags = [];
	  
	  $scope.loadCountries = function($query) {
	    return $http.get('json/countries.json', { cache: true}).then(function(response) {
	      var countries = response.data;
	      return countries.filter(function(country) {
	        return country.name.toLowerCase().indexOf($query.toLowerCase()) != -1;
	      });
	    });
	  };
	
	$http.get("admin/clientes/"+$routeParams.clienteId).then(function(response){
		
		$scope.cliente = response.data;
	}),(function(response){
		
	});
	
});