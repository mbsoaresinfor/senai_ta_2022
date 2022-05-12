package br.com.mbs.batch.item;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.mbs.entidades.Usuario;
import br.com.mbs.servico.UsuarioServico;

public class UsuarioReader implements ItemReader<Usuario>{

	@Autowired	
	private UsuarioServico usuarioServico;
	
	private Iterator<Usuario> it ;
	
	private boolean jaBuscado;
	
	 @PostConstruct
	 public void postConstruct() {
			//it = usuarioServico.listar().iterator();	       
	 }
	
	
	@Override
	public Usuario read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Reader");
		if(jaBuscado == false) {
			it = usuarioServico.listar().iterator();
			jaBuscado = true;
		}
		while(it.hasNext()) {
			return it.next();
		}
		
		return null;
		
	}

}
