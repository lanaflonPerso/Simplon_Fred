package co.simplon.spring20170412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootWebApplication {

//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

	private static final Logger log = LoggerFactory.getLogger(SpringBootWebApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Autowired
    JdbcTemplate jdbcTemplate;
}
