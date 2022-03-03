package br.com.mbs.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.mbs.entidades.Usuario;
import io.swagger.annotations.Api;

@RestController(value="API para manipulacao de usuarios")
@RequestMapping("usuarios")
@Api(description="Api de usuarios")
public class UsuarioController {

	Map<Integer,Usuario> mapaUsuario = new HashMap<Integer,Usuario>();
	Integer contador = 1;
	
	 @RequestMapping(value = "/teste/", method = RequestMethod.GET)	 
	  public ResponseEntity<Void> teste() throws Exception {		 
		 System.out.println("Processando teste");
		 return null;
	  }
	 
	 
	 @RequestMapping(value = "/salvar/", method = RequestMethod.POST)	 
	  public ResponseEntity<Integer> salvarUsuario(
			  
			  @RequestParam("nome") String nome,
			  @RequestParam("cep") String cep,
			  @RequestParam("idade") Integer idade)
	  
			   throws Exception {
		 
		 System.out.println("Processando salvarUsuario");
		 
		 Usuario usuario = new Usuario();
		 usuario.cep = cep;
		 usuario.idade = idade;
		 usuario.nome = nome;
		 usuario.id = contador;
		 		 
		 mapaUsuario.put(contador, usuario);
		 
		 contador++;
		 
		 return ResponseEntity.ok(usuario.id);
	  }
	 
	 
	 @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)	 
	  public ResponseEntity<Usuario> buscar(
			  
			  @PathVariable("id") Integer id)
			  
			  throws Exception {		 
		 
		 System.out.println("Processando buscar ");
		 return ResponseEntity.ok(mapaUsuario.get(id));
	  }
	

}
