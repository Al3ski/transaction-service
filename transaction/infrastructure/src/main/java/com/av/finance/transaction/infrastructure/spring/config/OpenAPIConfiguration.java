package com.av.finance.transaction.infrastructure.spring.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "Transaction service API",
        version = "0.0.1",
        contact = @Contact(
                name = "Aleksey Vtyurin",
                email = "aleksey_minsk@yahoo.com"
        )
))
public class OpenAPIConfiguration {
}
