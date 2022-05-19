package br.com.mbs.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mbs.batch.item.UsuarioProcessor;
import br.com.mbs.batch.item.UsuarioReader;
import br.com.mbs.batch.item.UsuarioWriter;
import br.com.mbs.entidades.ProcessaUsuario;
import br.com.mbs.entidades.Usuario;

@Configuration
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public UsuarioReader usuarioReader() {
		return new UsuarioReader(); 
	}
	
	@Bean
	public UsuarioProcessor usuarioProcessor() {
		return new UsuarioProcessor(); 
	}
	
	@Bean
	public UsuarioWriter usuarioWriter() {
		return new UsuarioWriter(); 
	}
	
	@Bean
	public Job processJob(UsuarioReader usuarioReader,
			UsuarioProcessor usuarioProcessor,
			UsuarioWriter usuarioWriter) {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.flow(orderStep1(usuarioReader,
						usuarioProcessor, 
						usuarioWriter)).end().build();
	}

	@Bean
	public Step orderStep1(UsuarioReader usuarioReader,
			UsuarioProcessor usuarioProcessor,
			UsuarioWriter usuarioWriter) {
		return stepBuilderFactory.get("orderStep1").
				<Usuario, ProcessaUsuario> chunk(1)
				.reader(usuarioReader)
				.processor(usuarioProcessor)
				.writer(usuarioWriter)
				.build();
	}

	
}
