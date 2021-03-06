//criacao do modulo principal da aplicacao
var appCliente = angular.module("appCliente", ['ngRoute','ngTagsInput']);

appCliente.config(function($routeProvider, $locationProvider){
	
	$routeProvider
	.when("/clientes", { templateUrl: 'view/cliente.html', controller: 'clienteController'})
	.when("/clientes/:clienteId", { templateUrl: 'view/cliente-detalhe.html', controller: 'clienteDetalheController'})
	.when("/cidades", { templateUrl: 'view/cidade.html', controller: 'cidadeController'})
	.when("/estados", { templateUrl: 'view/estado.html', controller: 'estadoController'})
	.when("/usuarios", { templateUrl: 'view/registro.html', controller: 'registroController'})
	.when("/login", { templateUrl: 'view/login.html', controller: 'loginController'})
	.otherwise({redirectTo: '/'});
	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
	});
});


appCliente.config(function($httpProvider){
	
	$httpProvider.interceptors.push('tokenInterceptor');
	
});