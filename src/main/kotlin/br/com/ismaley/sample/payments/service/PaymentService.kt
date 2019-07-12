package br.com.ismaley.sample.payments.service

import br.com.ismaley.sample.payments.client.IntegrationClient
import br.com.ismaley.sample.payments.dto.PaymentMethodUpdateRequest
import br.com.ismaley.sample.payments.exception.NotFoundException
import br.com.ismaley.sample.payments.model.PaymentMethod
import br.com.ismaley.sample.payments.repository.PaymentRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PaymentService(private val repository: PaymentRepository,
                     private val client: IntegrationClient) {

    fun createPaymentMethod(request: PaymentMethod): PaymentMethod = repository.save(request)

    fun getPaymentMethod(id: String): PaymentMethod = findOrFail(id)

    fun pay(id: String, cvv: Int): String = findOrFail(id).let { client.pay(it.cardNumber!!, cvv)!! }

    fun updatePaymentMethod(id: String, request: PaymentMethodUpdateRequest): PaymentMethod =
        findOrFail(id).copy(name = request.name, description = request.description)

    fun deletePaymentMethod(id: String) = findOrFail(id).let(repository::delete)

    private fun findOrFail(id: String): PaymentMethod {
        val paymentMethod = repository.findById(id)
        return when(paymentMethod.isPresent) {
            true -> paymentMethod.get()
            else -> throw NotFoundException("payment method: $id, not found")
        }
    }

}
