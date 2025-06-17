package kleberlz.mscartoesnovo.mapper;

import org.springframework.stereotype.Component;

import kleberlz.mscartoesnovo.dto.CartaoDTO;
import kleberlz.mscartoesnovo.model.Cartao;

@Component
public class CartaoConverter {
	
	public Cartao dtoParaEntidade(CartaoDTO dto) {
		Cartao cartao = new Cartao();
		cartao.setNome(dto.getNome());
		cartao.setBandeira(dto.getBandeira());
		cartao.setRenda(dto.getRenda());
		cartao.setLimite(dto.getLimite());
		
		return cartao;
	}
	
	public CartaoDTO entidadeParaDTO(Cartao entidade) {
		return new CartaoDTO(
				entidade.getNome(),
				entidade.getBandeira(),
				entidade.getRenda(),
				entidade.getLimite());
	}

}
