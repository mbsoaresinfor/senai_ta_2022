package br.com.mbs.repositorio;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mbs.entidades.Cep;

//url: endereco de onde esta o servico.
@FeignClient(value = "modulo-endereco", 
url = "http://localhost:9091/cep/",
fallback = CepRepositoryFalha.class)
public interface CepRepositorio {

	@RequestMapping(value = "/existe-cep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> existeCep(
			  @PathVariable("cep") String cep
			  ) throws Exception;
	
	 @RequestMapping(value = "/buscar-cep/{cep}", method = RequestMethod.GET)
	 public ResponseEntity<Cep> buscarCep(
			  @PathVariable("cep") String cep
			  ) throws Exception;
}
