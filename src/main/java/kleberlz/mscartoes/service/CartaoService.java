package kleberlz.mscartoes.service;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kleberlz.mscartoes.model.Cartao;
import kleberlz.mscartoes.repository.CartaoRepository;


@Service
public class CartaoService {
	
	private final CartaoRepository cartaoRepository;
	
	public CartaoService(CartaoRepository cartaoRepository) {
		this.cartaoRepository = cartaoRepository;
	}
	
	@Transactional
	public Cartao salvar(Cartao cartao) {
		return cartaoRepository.save(cartao);
	}
	
	public List<Cartao> buscarCartoesRendaMenorIgual(Long renda) {//Recebe valor inteiro pra transformar em big decimal
		var rendaBigDecimal = BigDecimal.valueOf(renda);
		return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
		
	}

}
