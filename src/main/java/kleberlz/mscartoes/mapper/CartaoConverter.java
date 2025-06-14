package kleberlz.mscartoes.mapper;

import org.springframework.stereotype.Component;

import kleberlz.mscartoes.dto.CartaoDTO;
import kleberlz.mscartoes.model.Cartao;

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
