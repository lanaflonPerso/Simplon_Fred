/**
 * Lanceur application
 */
package co.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication

public class MyFirstApiRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyFirstApiRestApplication.class, args);
	}
	
	@Autowired
    JdbcTemplate jdbcTemplate;

    
}
