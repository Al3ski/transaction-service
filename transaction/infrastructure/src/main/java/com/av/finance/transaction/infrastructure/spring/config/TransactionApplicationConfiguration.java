package com.av.finance.transaction.infrastructure.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.av.finance.transaction")
@Configuration
public class TransactionApplicationConfiguration {
}
