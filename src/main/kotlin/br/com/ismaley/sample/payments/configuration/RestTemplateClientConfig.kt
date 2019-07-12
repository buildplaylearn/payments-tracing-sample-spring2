package br.com.ismaley.sample.payments.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateClientConfig {

    @Bean
    fun restTemplate() : RestTemplate = RestTemplate()

}