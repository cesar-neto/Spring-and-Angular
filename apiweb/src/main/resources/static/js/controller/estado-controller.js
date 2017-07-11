appCliente.controller("estadoController", function($scope, $http){
			
	$scope.estados = 
		[{id: 0,uf: "Acre"},
		{id: 1,uf: "Alagoas"},
		{id: 2,uf: "Amapá"},
		{id: 3,uf: "Amazonas"},
		{id: 4,uf: "Bahia"},
		{id: 5,uf: "Ceará"},
		{id: 6,uf: "Distrito Federal"},
		{id: 7,uf: "Espírito Santo"},
		{id: 8,uf: "Goiás"},
		{id: 9,uf: "Maranhão"},
		{id: 10,uf: "Mato Grosso"},
		{id: 11,uf: "Mato Grosso do Sul"},
		{id: 12,uf: "Minas Gerais"},
		{id: 13,uf: "Pará"},
		{id: 14,uf: "Paraíba"},
		{id: 15,uf: "Paraná"},
		{id: 16,uf: "Pernambuco"},
		{id: 17,uf: "Piauí"},
		{id: 18,uf: "Rio de Janeiro"},
		{id: 19,uf: "Rio Grande do Norte"},
		{id: 20,uf: "Rio Grande do Sul"},
		{id: 21,uf: "Rondônia"},
		{id: 22,uf: "Roraima"},
		{id: 23,uf: "Santa Catarina"},
		{id: 24,uf: "São Paulo"},
		{id: 25,uf: "Sergipe"},
		{id: 26,uf: "Tocantins"}];
	
	$scope.estado = {};
		
});