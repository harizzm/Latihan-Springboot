package com.tabeldata.buku;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BukuApplication {

	public static void main(String[] args) {
		SpringApplication.run(BukuApplication.class, args);
	}
        @Bean
        public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource){
            return new JdbcTemplate(dataSource);
        }
}
