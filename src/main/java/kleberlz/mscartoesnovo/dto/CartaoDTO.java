package kleberlz.mscartoesnovo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CartaoDTO {

	@Min(1)
	@Max(999999)
	private Long id;

	@NotBlank(message = "O nome do cartão não deve estar em branco.")
	@Size(min = 3, max = 100, message = "Fora do tamanho padrão permitido.")
	private String nome;

	@NotBlank(message = "A bandeira do cartão não deve estar em branco.")
	@Size(min = 3, max = 100, message = "Fora do tamanho padrão permitido.")
	private String bandeira;

	@NotNull(message = "A renda não deve ser nula.")
	private BigDecimal renda;

	@NotNull(message = "O limite não deve ser nulo.")
	private BigDecimal limite;

	public CartaoDTO(String nome, String bandeira, BigDecimal renda, BigDecimal limite) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.renda = renda;
		this.limite = limite;
	}

	public CartaoDTO() {

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

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

}
