package kleberlz.mscartoes.dto;

import java.math.BigDecimal;

import kleberlz.mscartoes.model.BandeiraCartao;

public class ClienteCartaoDTO {//Somente os dados necessários pra mostrar na requisição
	
	private String nome;
	private BandeiraCartao bandeira;
	private BigDecimal limite;
	
	public ClienteCartaoDTO(String nome, BandeiraCartao bandeira, BigDecimal limite) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.limite = limite;
	}
	
	public ClienteCartaoDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
	
	

}
