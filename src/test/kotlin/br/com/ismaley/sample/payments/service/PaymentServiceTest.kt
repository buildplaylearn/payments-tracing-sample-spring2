package br.com.ismaley.sample.payments.service

import br.com.ismaley.sample.payments.client.IntegrationClient
import br.com.ismaley.sample.payments.exception.NotFoundException
import br.com.ismaley.sample.payments.model.PaymentMethod
import br.com.ismaley.sample.payments.repository.PaymentRepository
import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

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

    @Test
    fun `should get payment method`() {
        whenever(paymentRepository.findById("1"))
            .doReturn(Optional.of(PaymentMethod("1")))

        val paymentMethod = paymentService.getPaymentMethod("1")
        Assertions.assertSame(paymentMethod.id, "1")
    }

    @Test
    fun `should throw exception if payment method is not found`() {
        whenever(paymentRepository.findById("1"))
            .doReturn(Optional.empty())

        assertThrows<NotFoundException> {
            paymentService.getPaymentMethod("1")
        }
    }
}