package kleberlz.mscartoes.mapper;

import org.springframework.stereotype.Component;
import kleberlz.mscartoes.dto.ClienteCartaoDTO;
import kleberlz.mscartoes.model.Cartao;
import kleberlz.mscartoes.model.ClienteCartao;

@Component
public class ClienteCartaoConverter {
	
	public ClienteCartao dtoParaEntidade(ClienteCartaoDTO dto) {
		ClienteCartao clienteCartao = new ClienteCartao();
		
		Cartao cartao = new Cartao();
		cartao.setNome(dto.getNome());
		cartao.setBandeira(dto.getBandeira());
		
		clienteCartao.setCartao(cartao);
		clienteCartao.setLimite(dto.getLimite());
		
		return clienteCartao;
	}
	
	public ClienteCartaoDTO entidadeParaDTO(ClienteCartao entidade) {
		ClienteCartaoDTO dto = new ClienteCartaoDTO();
		dto.setNome(entidade.getCartao().getNome());
		dto.setBandeira(entidade.getCartao().getBandeira());
		dto.setLimite(entidade.getLimite());
		
		return dto;
	}
	

}
