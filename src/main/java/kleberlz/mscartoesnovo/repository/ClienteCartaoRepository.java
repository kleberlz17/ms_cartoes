package kleberlz.mscartoesnovo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kleberlz.mscartoesnovo.model.ClienteCartao;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {
	
	@Query("SELECT cc FROM ClienteCartao cc JOIN FETCH cc.cartao WHERE cc.cpf = :cpf")
	List<ClienteCartao> findByCpf(String cpf);

}
