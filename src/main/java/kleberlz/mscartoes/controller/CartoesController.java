package kleberlz.mscartoes.controller;

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

import kleberlz.mscartoes.dto.CartaoDTO;
import kleberlz.mscartoes.dto.ClienteCartaoDTO;
import kleberlz.mscartoes.mapper.CartaoConverter;
import kleberlz.mscartoes.mapper.ClienteCartaoConverter;
import kleberlz.mscartoes.model.Cartao;
import kleberlz.mscartoes.model.ClienteCartao;
import kleberlz.mscartoes.service.CartaoService;
import kleberlz.mscartoes.service.ClienteCartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {
	
	private final CartaoService cartaoService;
	private final ClienteCartaoService clienteCartaoService;
	private final CartaoConverter cartaoConverter;
	private final ClienteCartaoConverter clienteCartaoConverter;
	
	public CartoesController(CartaoService cartaoService, ClienteCartaoService clienteCartaoService,
			CartaoConverter cartaoConverter, ClienteCartaoConverter clienteCartaoConverter) {
		this.cartaoService = cartaoService;
		this.clienteCartaoService = clienteCartaoService;
		this.cartaoConverter = cartaoConverter;
		this.clienteCartaoConverter = clienteCartaoConverter;
	}
	
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody CartaoDTO cartaoDTO) {
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
	public ResponseEntity<List<ClienteCartaoDTO>> buscarCartoesPorCliente(@PathVariable String cpf) {
		List<ClienteCartao> listaClienteCartoes = clienteCartaoService.listarCartoesByCpf(cpf);
		
		if(listaClienteCartoes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		List<ClienteCartaoDTO> listaDTO = listaClienteCartoes.stream()
				.map(clienteCartaoConverter::entidadeParaDTO)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listaDTO);
	}

}
