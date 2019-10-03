package br.com.ismaley.sample.payments.controller

import br.com.ismaley.sample.payments.dto.PaymentMethodDTO
import br.com.ismaley.sample.payments.dto.PaymentMethodRequest
import br.com.ismaley.sample.payments.model.PaymentMethod

class Mapper {

    companion object {
        fun toModel(paymentMethodRequest: PaymentMethodRequest) = PaymentMethod(
            customerId = paymentMethodRequest.customerId,
            name = paymentMethodRequest.name,
            description = paymentMethodRequest.description,
            cardNumber = paymentMethodRequest.cardNumber,
            year = paymentMethodRequest.year,
            month = paymentMethodRequest.month
        )

        fun toDTOList(paymentMethodList: List<PaymentMethod>): List<PaymentMethodDTO> {
            return paymentMethodList.map { toDTO(it) }
        }

        fun toDTO(paymentMethod: PaymentMethod) = PaymentMethodDTO(
            paymentMethodId = paymentMethod.id!!,
            customerId = paymentMethod.customerId!!,
            name = paymentMethod.name!!,
            description = paymentMethod.description!!,
            year = paymentMethod.year!!,
            month = paymentMethod.month!!,
            cardNumber = paymentMethod.cardNumber!!)
    }

}