package kleberlz.mscartoesnovo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kleberlz.mscartoesnovo.model.Cartao;

public interface CartaoRepository  extends JpaRepository<Cartao, Long> {
	
	List<Cartao> findByRendaLessThanEqual(BigDecimal renda);

}
