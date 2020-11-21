package org.SEP4_Data;

import org.SEP4_Data.iot_gateway_endpoint.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.ExecutionException;

@SpringBootApplication // that's for skipping DB
@EnableJpaRepositories
public class Sep4DataApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(Sep4DataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("#################################");
		System.out.println(context.getDisplayName());
		WebSocketClient client = context.getBean(WebSocketClient.class);
	}
}