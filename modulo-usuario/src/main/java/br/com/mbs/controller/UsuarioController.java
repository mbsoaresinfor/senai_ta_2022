package br.com.mbs.controller;



import java.util.Date;
import java.util.List;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@RestController(value="API para manipulacao de usuarios")
@Api(description="Api de usuarios")
public class UsuarioController {

	
	
	 @RequestMapping(value = "/teste/", method = RequestMethod.GET)	 
	  public ResponseEntity<Void> teste() throws Exception {		 
		 System.out.println("Processando teste");
		 return null;
	  }
	 
	

}
