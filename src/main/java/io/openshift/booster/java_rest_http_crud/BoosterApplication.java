package io.openshift.booster.java_rest_http_crud;

import java.net.URL;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.openshift.booster.java_rest_http_crud")
public class BoosterApplication {

	public static void main(String[] args) throws Exception {
		URL url;
		try {
			Class.forName("org.postgresql.Driver");
			DriverManager.getConnection(System.getenv("JDBC_URL"), System.getenv("DB_USER"),
					System.getenv("DB_PASSWORD"));
			// System.out.println("DB is available!!");
			url = BoosterApplication.class.getResource("/BOOT-INF/classes/db.properties");
		} catch (Exception e) {
			// System.out.printf("DB is no available!!: %s\n", e.getLocalizedMessage());
			url = BoosterApplication.class.getResource("/BOOT-INF/classes/no-db.properties");
		}

		System.setProperty("spring.config.location", url.toString());

		SpringApplication.run(BoosterApplication.class, args);
	}
}