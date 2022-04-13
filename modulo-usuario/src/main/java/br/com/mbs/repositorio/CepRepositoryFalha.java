package br.com.mbs.repositorio;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.mbs.entidades.Cep;

@Component
public class CepRepositoryFalha implements CepRepositorio{

	@Override
	public ResponseEntity<Boolean> existeCep(String cep) throws Exception {
		
		return ResponseEntity.ok(Boolean.FALSE);
	}

	@Override
	public ResponseEntity<Cep> buscarCep(String cep) throws Exception {
		Cep cepMock = new Cep();
		cepMock.bairro ="BAIRRO_MOCK";
		cepMock.nome = "RUA_MOCK";
		cepMock.nomeLogradouro = "NOME_LOGRADOURO_MOCK";
		cepMock.numero = -1;
		
		
		return ResponseEntity.ok(cepMock);
	}

	@Override
	public ResponseEntity<String> buscarNomeLogradouro(String cep) throws Exception {

		 return ResponseEntity.ok("NOME_RUA_MOCK");
	}

}
