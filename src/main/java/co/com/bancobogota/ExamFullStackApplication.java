package co.com.bancobogota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExamFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamFullStackApplication.class, args);
	}

}
