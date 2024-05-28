package idusw.springboot.kthmall;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication // (exclude={DataSourceAutoConfiguration.class}) // 데이터 설정 하지 않겠다는 의미
//@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class KthMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(KthMallApplication.class, args);
	}

}
