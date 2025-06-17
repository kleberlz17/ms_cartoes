package kleberlz.mscartoesnovo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MscartoesnovoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscartoesnovoApplication.class, args);
	}

}
