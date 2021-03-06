package co.com.bancobogota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRedisMysql {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisMysql.class, args);
	}

}
