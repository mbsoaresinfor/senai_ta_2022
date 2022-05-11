package br.com.mbs.batch.item;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import br.com.mbs.entidades.Usuario;

public class UsuarioReader implements ItemReader<Usuario>{

	@Override
	public Usuario read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		return null;
	}

}
