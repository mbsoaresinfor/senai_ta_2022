package br.com.mbs.batch.item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import br.com.mbs.entidades.ProcessaUsuario;
import br.com.mbs.entidades.Usuario;

public class UsuarioWriter implements ItemWriter<ProcessaUsuario>{

	String fileName = "datas.txt";
	@Override
	public void write(List<? extends ProcessaUsuario> items) throws Exception {
		System.out.println("Write");
		// Maria - 12/08/2020 - adulto

		for(ProcessaUsuario user : items) {
			String conteudo = user.getNome() + " - " +
							user.getDataProcessamento() + " - " +
							user.getStatus();
			FileWriter fw = new FileWriter(fileName, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(conteudo);
		    bw.newLine();
		    bw.close();
		}
		
		
		
	}

}
