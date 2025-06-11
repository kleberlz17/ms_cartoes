package kleberlz.mscartoes.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kleberlz.mscartoes.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	List<Cartao> findByRendaLessThanEqual(BigDecimal renda);
}
