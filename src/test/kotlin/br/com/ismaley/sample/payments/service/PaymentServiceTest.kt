package br.com.ismaley.sample.payments.service

import br.com.ismaley.sample.payments.client.IntegrationClient
import br.com.ismaley.sample.payments.model.PaymentMethod
import br.com.ismaley.sample.payments.repository.PaymentRepository
import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Test

class PaymentServiceTest {

    private val paymentRepository: PaymentRepository = mock()
    private val client: IntegrationClient = mock()
    private val paymentService = PaymentService(paymentRepository, client)

    @Test
    fun `should create payment method`() {
        val createPaymentMethod = PaymentMethod()

        whenever(paymentRepository.save(createPaymentMethod))
            .doReturn(createPaymentMethod)

        paymentService.createPaymentMethod(createPaymentMethod)

        verify(paymentRepository).save(createPaymentMethod)
        verifyZeroInteractions(client)
        verifyNoMoreInteractions(paymentRepository)
    }
}