package kleberlz.mscartoes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kleberlz.mscartoes.model.ClienteCartao;
import kleberlz.mscartoes.repository.ClienteCartaoRepository;

@Service
public class ClienteCartaoService {

	private final ClienteCartaoRepository clienteCartaoRepository;
	
	public ClienteCartaoService(ClienteCartaoRepository clienteCartaoRepository) {
		this.clienteCartaoRepository = clienteCartaoRepository;
	}
	
	public List<ClienteCartao> listarCartoesByCpf(String cpf) {
		return clienteCartaoRepository.findByCpf(cpf);
	}
}
