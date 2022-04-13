package br.com.mbs.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.camunda.bpm.model.bpmn.impl.instance.WhileExecutingInputRefs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.mbs.entidades.Cep;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController(value="API para manipulacao de cep")
@RequestMapping("cep")
@Api(description="Api de cep")
public class CepController {

	Map<String,Cep> mapaCep = new HashMap<String,Cep>();
	
	public CepController() {
		Cep cep1 = new Cep();
		cep1.nomeLogradouro = "Av.";
		cep1.nome ="Assis Brasil";
		cep1.numero = 2000;
		cep1.bairro = "Sarandi";		
		mapaCep.put("90500100", cep1);
		
		Cep cep2 = new Cep();
		cep2.nomeLogradouro = "Rua";
		cep2.nome ="Padre caciqyue";
		cep2.numero = 3000;
		cep2.bairro = "vila marcia";		
		mapaCep.put("91630200", cep2);
		
		Cep cep3 = new Cep();
		cep3.nomeLogradouro = "av.";
		cep3.nome ="protasio alves";
		cep3.numero = 520;
		cep3.bairro = "protasio alves";		
		mapaCep.put("90000030", cep3);
	}
	
	 @RequestMapping(value = "/teste/", method = RequestMethod.GET)	 
	  public ResponseEntity<Void> teste() throws Exception {		 
		 System.out.println("Processando teste");
		 return null;
	  }
	 
	 @RequestMapping(value = "/existe-cep/{cep}", method = RequestMethod.GET)	 
	  public ResponseEntity<Boolean> existeCep(
			  @PathVariable("cep") String cep
			  ) throws Exception {		 
		 System.out.println("Processando existe-cep");
		 
		 Boolean existeCep = mapaCep.containsKey(cep);
		 		 
		 return ResponseEntity.ok(existeCep);
	  }
	 
	 @RequestMapping(value = "/buscar-cep/{cep}", method = RequestMethod.GET)	 
	  public ResponseEntity<Cep> buscarCep(
			  @PathVariable("cep") String cep
			  ) throws Exception {		 
		 System.out.println("Processando buscar-cep");
		 
		 Cep objCep = mapaCep.get(cep);
		 
		 return ResponseEntity.ok(objCep);
		 
		 
	  }
	 
	 @RequestMapping(value = "/busca-nome-logradouro/{cep}", method = RequestMethod.GET)	 
	  public ResponseEntity<String> buscarNomeLogradouro(
			  @PathVariable("cep") String cep
			  ) throws Exception {		 
		 System.out.println("Processando buscarNomeLogradouro");
		 
		 Cep objCep = mapaCep.get(cep);
		 String nomeRua = "";
		 if(objCep != null) {
			 nomeRua = objCep.nomeLogradouro;
		 }
		 
		 return ResponseEntity.ok(nomeRua);		 
		 
	  }
	 
	 

}
