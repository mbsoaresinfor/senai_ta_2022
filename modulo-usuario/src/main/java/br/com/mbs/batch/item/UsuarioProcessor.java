package br.com.mbs.batch.item;

import org.springframework.batch.item.ItemProcessor;

import br.com.mbs.entidades.ProcessaUsuario;
import br.com.mbs.entidades.Usuario;

public class UsuarioProcessor 
	implements ItemProcessor<Usuario, ProcessaUsuario> {

	@Override
	public ProcessaUsuario process(Usuario item) throws Exception {

		System.out.println("Processor " + item);
		
		ProcessaUsuario pu = new ProcessaUsuario();
		pu.setNome(item.nome); // de-para
		if(item.idade >= 18) {
			pu.setStatus("e maior de idade");
		}else {
			pu.setStatus("e menor de idade");
		}
		
		return pu;
	}
	
	
	

}
