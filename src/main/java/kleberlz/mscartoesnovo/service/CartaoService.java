package kleberlz.mscartoesnovo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import kleberlz.mscartoesnovo.model.Cartao;
import kleberlz.mscartoesnovo.repository.CartaoRepository;

@Service
public class CartaoService {
	
	private final CartaoRepository cartaoRepository;
	
	public CartaoService(CartaoRepository cartaoRepository) {
		this.cartaoRepository = cartaoRepository;
	}
	
	public Cartao salvar(Cartao cartao) {
		if(cartao.getBandeira() == null || cartao.getBandeira().isEmpty()) {
			throw new IllegalArgumentException("A bandeira do cartão não deve ser nula ou vazia.");
		}
		
		return cartaoRepository.save(cartao);
	}
	
	public List<Cartao> buscarCartoesRendaMenorIgual(Long renda) {
		var rendaDigitada = BigDecimal.valueOf(renda);
		return cartaoRepository.findByRendaLessThanEqual(rendaDigitada);
	}

}
