package kleberlz.mscartoes.dto;

import java.math.BigDecimal;


public class CartaoDTO {

	private String nome;
	private String bandeira;
	private BigDecimal renda;
	private BigDecimal limite;
	
	public CartaoDTO(String nome, String bandeira, BigDecimal renda, BigDecimal limite) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.renda = renda;
		this.limite = limite;
	}
	
	public CartaoDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	

	
	
}
