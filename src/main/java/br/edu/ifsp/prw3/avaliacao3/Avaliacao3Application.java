package br.edu.ifsp.prw3.avaliacao3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Avaliacao3Application {

	public static void main(String[] args) {
		SpringApplication.run(Avaliacao3Application.class, args);
	}

}
