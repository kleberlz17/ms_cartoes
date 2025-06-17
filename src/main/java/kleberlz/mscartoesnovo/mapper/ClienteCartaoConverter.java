package kleberlz.mscartoesnovo.mapper;

import org.springframework.stereotype.Component;

import kleberlz.mscartoesnovo.model.Cartao;
import kleberlz.mscartoesnovo.model.ClienteCartao;
import kleberlz.mscartoesnovo.response.CartaoResponseDTO;

@Component
public class ClienteCartaoConverter {
	
	public ClienteCartao dtoParaEntidade(CartaoResponseDTO dto) {
		ClienteCartao clienteCartao = new ClienteCartao();
		
		Cartao cartao = new Cartao();
		cartao.setNome(dto.getNome());
		cartao.setBandeira(dto.getBandeira());
		
		clienteCartao.setCartao(cartao);
		clienteCartao.setLimite(dto.getLimite());
		
		return clienteCartao;
	}
	
	public CartaoResponseDTO entidadeParaDTO(ClienteCartao entidade) {
		CartaoResponseDTO dto = new CartaoResponseDTO();
		dto.setNome(entidade.getCartao().getNome());
		dto.setBandeira(entidade.getCartao().getBandeira());
		dto.setLimite(entidade.getLimite());
		
		return dto;
	}

}
