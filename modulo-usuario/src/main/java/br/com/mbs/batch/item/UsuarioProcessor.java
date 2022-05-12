package br.com.mbs.batch.item;

import org.springframework.batch.item.ItemProcessor;

import br.com.mbs.entidades.Usuario;

public class UsuarioProcessor 
	implements ItemProcessor<Usuario, Usuario> {

	@Override
	public Usuario process(Usuario item) throws Exception {

		System.out.println("Processor " + item);
		// logica de negocio (processaemnto)
		item.nome = item.nome.toUpperCase();
		
		return item;
	}

}
