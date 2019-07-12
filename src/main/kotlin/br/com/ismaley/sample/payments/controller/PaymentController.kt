package br.com.ismaley.sample.payments.controller

import br.com.ismaley.sample.payments.dto.PaymentMethodDTO
import br.com.ismaley.sample.payments.dto.PaymentMethodRequest
import br.com.ismaley.sample.payments.dto.PaymentMethodUpdateRequest
import br.com.ismaley.sample.payments.dto.PaymentRequest
import br.com.ismaley.sample.payments.model.PaymentMethod
import br.com.ismaley.sample.payments.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/payments")
class PaymentController(private val service : PaymentService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPaymentMethod(@RequestBody @Valid request: PaymentMethodRequest): PaymentMethodDTO {
        return Mapper.toDTO(service.createPaymentMethod(Mapper.toModel(request)))
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPaymentMethod(@PathVariable id: String): PaymentMethodDTO {
        return Mapper.toDTO(service.getPaymentMethod(id))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updatePaymentMethod(@PathVariable id: String, @RequestBody @Valid request: PaymentMethodUpdateRequest): PaymentMethodDTO {
        return Mapper.toDTO(service.updatePaymentMethod(id, request))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deletePaymentMethod(@PathVariable id: String) {
        return service.deletePaymentMethod(id)
    }

    @PostMapping("/{id}/pay")
    @ResponseStatus(HttpStatus.OK)
    fun pay(@PathVariable id: String, @RequestBody @Valid paymentRequest: PaymentRequest): String {
        return service.pay(id, paymentRequest.cvv!!)
    }



}