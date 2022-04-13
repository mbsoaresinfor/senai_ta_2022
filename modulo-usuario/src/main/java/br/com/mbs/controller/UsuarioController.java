package br.com.mbs.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mbs.entidades.Cep;
import br.com.mbs.entidades.NomeUsuarioELogradouroResponse;
import br.com.mbs.entidades.Usuario;
import br.com.mbs.entidades.UsuarioResponse;
import br.com.mbs.repositorio.CepRepositorio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController(value="API para manipulacao de usuarios")
@RequestMapping("usuarios")
@Api(description="Api de usuarios")
public class UsuarioController {

	@Autowired
	private CepRepositorio cepRepositorio;
	
	Map<Integer,Usuario> mapaUsuario = new HashMap<Integer,Usuario>();
	Integer contador = 1;
	
	 @RequestMapping(value = "/teste/", method = RequestMethod.GET)	 
	  public ResponseEntity<Void> teste() throws Exception {		 
		 System.out.println("Processando teste");
		 return null;
	  }
	 
	 
	 @ApiOperation(value = "Salvar um usuario via json" )
	 @ApiResponses(value = {
		@ApiResponse(code = 200, message = "usuário salvo com sucesso", response = String.class),
		@ApiResponse(code = 405, message = "Problema de validação do usuário",response = String.class),
		@ApiResponse(code = 500, message = "Error no servidor.")
			 
	 })
	 @RequestMapping(value = "/salvar2/", method = RequestMethod.POST, 
			 consumes ={MediaType.APPLICATION_JSON})	 
	  public ResponseEntity<String> salvarUsuario2(
			  @RequestBody Usuario usuario)
			   throws Exception {
		 
		 System.out.println("Processando salvarUsuario2");
		 
		 usuario.id = contador;
		 	
		 // error de negocio
		 if(usuario.cep.equals("")) {
			 return new ResponseEntity<>("Error no cep", HttpStatus.BAD_REQUEST); 
		 }
		 
		 ResponseEntity<Boolean> retCep = cepRepositorio.existeCep(usuario.cep);
		 if(retCep.getBody().equals(Boolean.FALSE)) {
			 return new ResponseEntity<>("Cep informado não existe", HttpStatus.BAD_REQUEST);
		 }
		 
		 
		 mapaUsuario.put(contador, usuario);
		 
		 contador++;
		 
		 return ResponseEntity.ok(usuario.id.toString());
	  }
	 
	 
	 @ApiOperation(value = "Salvar um usuario via requestParam" )
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
	 
	 
	 @ApiOperation(value = "Retorna todos os usuários pelo ID" )
	 @ApiResponses(value = {
		@ApiResponse(code = 200, message = "retorno com sucesso", response = Usuario.class)		
			 
	 })
	 @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)	 
	  public ResponseEntity<UsuarioResponse> buscar(
			  
			  @PathVariable("id") Integer id)
			  
			  throws Exception {		 
		 
		 System.out.println("Processando buscar ");
		 Usuario usuario =  mapaUsuario.get(id);
		 ResponseEntity<Cep> cep = cepRepositorio.buscarCep(usuario.cep);
		 
		 UsuarioResponse ur = new UsuarioResponse();
		 ur.id = usuario.id;
		 ur.idade = usuario.idade;
		 ur.nome = usuario.nome;
		 ur.cep = usuario.cep;
		 ur.cepCompleto = cep.getBody();
		 
		 
		 return ResponseEntity.ok(ur );
	  }
	
	 
	 @ApiOperation(value = "Remove um usuário pelo seu ID" )
	 @ApiResponses(value = {
		@ApiResponse(code = 200, message = "sucesso na remocao", response = Void.class)		
			 
	 })
	 @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)	 
	  public ResponseEntity<Void> deletar(
			  
			  @PathVariable("id") Integer id)
			  
			  throws Exception {		 
		 
		 System.out.println("Processando deletar ");
		 mapaUsuario.remove(id);
		 return ResponseEntity.ok().build();
	  }
	 
	 @ApiOperation(value = "Atualiza um usuário" )
	 @ApiResponses(value = {
		@ApiResponse(code = 200, message = "sucesso", response = String.class)	
			 
	 })
	 @RequestMapping(value = "/atualizar/", method = RequestMethod.PUT)	 
	  public ResponseEntity<String> atualizarUsuario(
			  
			  @RequestParam("id") Integer id,
			  @RequestParam("cep") String cep,
			  @RequestParam("idade") Integer idade)
	  
			   throws Exception {
		 
		 System.out.println("Processando atualizarUsuario");
		 
		 Usuario usuario = mapaUsuario.get(id);
		 usuario.cep = cep;
		 usuario.idade = idade;		 
		 
		 
		 return ResponseEntity.ok("sucesso");
	  }
	 
	 @RequestMapping(value = "/listar/", method = RequestMethod.GET)	 
	  public ResponseEntity<List<Usuario>> listar()			  
			  throws Exception {		 
		 
		 System.out.println("Processando listar ");
		 ArrayList<Usuario> lista = new ArrayList<>(mapaUsuario.values());
		 		 
		 return ResponseEntity.ok(lista);
	  }
	 
	 @RequestMapping(value = "/busca-usuario-nome-logradouro/{id}", method = RequestMethod.GET)	 
	  public ResponseEntity<NomeUsuarioELogradouroResponse> buscaUsuarioComSeuNomeLogradouro(
			  
			  @PathVariable("id") Integer id)
			  
			  throws Exception {		 
		 
		 System.out.println("Processando buscaUsuarioComSeuNomeLogradouro ");
		 Usuario usuario =  mapaUsuario.get(id);
		 String nomeUsuario = usuario.nome;
		 
		 ResponseEntity<String> nomeLogradouro = cepRepositorio.
				 	buscarNomeLogradouro(usuario.cep);
		 
		
		 NomeUsuarioELogradouroResponse response = 
				 new NomeUsuarioELogradouroResponse();
		 response.setNomeLogradouro(nomeLogradouro.getBody());
		 response.setNomeUsuario(nomeUsuario);		 
		 
		 return ResponseEntity.ok(response);
	  }
	 
	 

}
