package br.com.mbs.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ProcessaUsuario implements Serializable{
	
	private String nome;
	private String dataProcessamento = criaData();
	private String status;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataProcessamento() {
		return dataProcessamento;
	}
	public void setDataProcessamento(String dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	private String criaData() { 
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		return DateFor.format(date);
	}
	
	


}
