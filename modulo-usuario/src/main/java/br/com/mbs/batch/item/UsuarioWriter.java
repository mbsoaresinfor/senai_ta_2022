package br.com.mbs.batch.item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import br.com.mbs.entidades.Usuario;

public class UsuarioWriter implements ItemWriter<Usuario>{

	String fileName = "datas.txt";
	@Override
	public void write(List<? extends Usuario> items) throws Exception {
		System.out.println("Write");
		
		for(Usuario user : items) {
			String conteudo = user.nome + "," + user.idade;
			FileWriter fw = new FileWriter(fileName, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(conteudo);
		    bw.newLine();
		    bw.close();
		}
		
		
		
	}

}
