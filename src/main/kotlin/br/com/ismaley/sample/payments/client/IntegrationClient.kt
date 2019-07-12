package br.com.ismaley.sample.payments.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.net.URI

@Component
class IntegrationClient(private val restTemplate: RestTemplate,
                        private var mapper: ObjectMapper) {

    init {
        mapper = ObjectMapper()
    }

    fun pay(cardNumber: String, cvv: Int): String? =
            restTemplate.postForObject(URI("http://localhost:8888/pay"), buildPayload(cardNumber, cvv), String::class.java)

    private fun buildPayload(cardNumber: String, cvv: Int): HttpEntity<ObjectNode> =
            HttpEntity(mapper.createObjectNode()
                .put("cardNumber", cardNumber)
                .put("cvv", cvv))

}
