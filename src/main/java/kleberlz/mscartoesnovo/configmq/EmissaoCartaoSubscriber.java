package kleberlz.mscartoesnovo.configmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import kleberlz.mscartoesnovo.model.Cartao;
import kleberlz.mscartoesnovo.model.ClienteCartao;
import kleberlz.mscartoesnovo.repository.CartaoRepository;
import kleberlz.mscartoesnovo.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modelmq.DadosSolicitacaoEmissaoCartao;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmissaoCartaoSubscriber {
	
	private final CartaoRepository cartaoRepository;
	private final ClienteCartaoRepository clienteCartaoRepository;

	@RabbitListener(queues = "${mq.queues.emissao-cartoes}")
	public void receberSolicitacaoEmissao(@Payload String payload) { //Espera receber um object
		try {
			
			var mapper = new ObjectMapper();
			DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
			Cartao cartao = cartaoRepository.findById(dados.getId()).orElseThrow();
			
			ClienteCartao clienteCartao = new ClienteCartao();
			clienteCartao.setCartao(cartao);
			clienteCartao.setCpf(dados.getCpf());
			clienteCartao.setLimite(dados.getLimite());
			
			clienteCartaoRepository.save(clienteCartao);
			
			
		} catch (Exception ex) {
			log.error("Erro ao receber solicitação de emissão de cartão: {}", ex.getMessage());
		}
		
		
	}

}
