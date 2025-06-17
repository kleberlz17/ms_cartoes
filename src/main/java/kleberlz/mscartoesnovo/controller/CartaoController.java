package kleberlz.mscartoesnovo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kleberlz.mscartoesnovo.dto.CartaoDTO;
import kleberlz.mscartoesnovo.mapper.CartaoConverter;
import kleberlz.mscartoesnovo.mapper.ClienteCartaoConverter;
import kleberlz.mscartoesnovo.model.Cartao;
import kleberlz.mscartoesnovo.model.ClienteCartao;
import kleberlz.mscartoesnovo.response.CartaoResponseDTO;
import kleberlz.mscartoesnovo.service.CartaoService;
import kleberlz.mscartoesnovo.service.ClienteCartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
	
	private final CartaoService cartaoService;
	private final ClienteCartaoService clienteCartaoService;
	private final CartaoConverter cartaoConverter;
	private final ClienteCartaoConverter clienteCartaoConverter;

	
	public CartaoController(CartaoService cartaoService, ClienteCartaoService clienteCartaoService,
			CartaoConverter cartaoConverter, ClienteCartaoConverter clienteCartaoConverter) {
		this.cartaoService = cartaoService;
		this.clienteCartaoService = clienteCartaoService;
		this.cartaoConverter = cartaoConverter;
		this.clienteCartaoConverter = clienteCartaoConverter;
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar (@RequestBody CartaoDTO cartaoDTO) {
		Cartao cartao = cartaoConverter.dtoParaEntidade(cartaoDTO);
		Cartao cartaoSalvo = cartaoService.salvar(cartao);
		
		URI uri = URI.create("/cartoes/" + cartaoSalvo.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/renda/{renda}")
	public ResponseEntity<List<Cartao>> buscarCartoesRendaAte(@PathVariable Long renda) {
		List<Cartao> listaCartoes = cartaoService.buscarCartoesRendaMenorIgual(renda);
		
		if(listaCartoes.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(listaCartoes);
		}
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<CartaoResponseDTO>> listarCartoesByCpf(@PathVariable String cpf) {
		List<ClienteCartao> listaClienteCartoes = clienteCartaoService.listarCartoesByCpf(cpf);
		
		List<CartaoResponseDTO> listaDTO = listaClienteCartoes.stream()
				.map(clienteCartaoConverter::entidadeParaDTO)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listaDTO);
	}
}
