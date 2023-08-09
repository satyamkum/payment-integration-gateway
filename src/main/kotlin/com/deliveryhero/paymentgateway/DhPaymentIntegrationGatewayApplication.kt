package com.deliveryhero.paymentgateway

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
	info = Info(title = "dh-fintech-payment-integration-gateway", version = "1.0"),
	servers = [Server(url = "http://localhost:8080", description = "Generated on Localhost")]
)
class DhPaymentIntegrationGatewayApplication

fun main(args: Array<String>) {
	runApplication<DhPaymentIntegrationGatewayApplication>(*args)
}
