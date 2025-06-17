package kleberlz.mscartoesnovo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ClienteCartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cpf;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cartao")
	private Cartao cartao;

	private BigDecimal limite;

	public ClienteCartao(String cpf, Cartao cartao, BigDecimal limite) {
		this.cpf = cpf;
		this.cartao = cartao;
		this.limite = limite;
	}

	public ClienteCartao() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "ClienteCartao [id=" + id + ", cpf=" + cpf + ", cartao=" + cartao + ", limite=" + limite + "]";
	}

}
