appCliente.factory("tokenInterceptor", function($q, $location){
	
	return {
	    // optional method
	    'request': function(config) {
	      // do something on success
	    	config.headers.Authorization = 'Bearer ' + localStorage.getItem("userToken");
	      return config;
	    },

	    // optional method
	   'requestError': function(rejection) {
	      // do something on error
	      if (canRecover(rejection)) {
	        return responseOrNewPromise
	      }
	      return $q.reject(rejection);
	    },



	    // optional method
	    'response': function(response) {
	      // do something on success
	      return response;
	    },

	    // optional method
	   'responseError': function(rejection) {
	      // do something on error
		   
		   if(rejection.status == 500){
		   		$location.path("/login");
		   	}
		   
	     /* if (canRecover(rejection)) {
	        return responseOrNewPromise
	      }*/
	      return $q.reject(rejection);
	    }
	  };
	
});