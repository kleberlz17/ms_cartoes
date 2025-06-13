package kleberlz.mscartoes.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	
	private String bandeira;
	
	private BigDecimal renda;
	
	private BigDecimal limiteBasico;
	
	public Cartao(String nome, String bandeira, BigDecimal renda, BigDecimal limiteBasico) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.renda = renda;
		this.limiteBasico = limiteBasico;
	}
	
	public Cartao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getLimiteBasico() {
		return limiteBasico;
	}

	public void setLimiteBasico(BigDecimal limiteBasico) {
		this.limiteBasico = limiteBasico;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", nome=" + nome + ", bandeira=" + bandeira + ", renda=" + renda + ", limiteBasico="
				+ limiteBasico + "]";
	}

	
	

}
