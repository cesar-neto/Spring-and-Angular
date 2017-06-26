package ws.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Cliente;

@RestController
public class ClienteController {
	
	Map<Integer, Cliente> clientes;
	Integer proximoID = 0;
	
	// negocios
	
	private Cliente cadastrar(Cliente cliente){
		
		if(clientes == null){
			clientes = new HashMap<>();
		}
		
		cliente.setId(proximoID);
		proximoID++;
		
		clientes.put(cliente.getId(), cliente);
		
		return cliente;
	}
	
	
	// end points
	
	@RequestMapping(method=RequestMethod.POST, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void cadastrarCliente(@RequestBody Cliente cliente){
		System.out.println("Chamou /cliente");
	}

}
