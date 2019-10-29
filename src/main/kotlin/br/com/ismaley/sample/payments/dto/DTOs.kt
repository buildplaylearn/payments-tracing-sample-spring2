package br.com.ismaley.sample.payments.dto

import org.hibernate.validator.constraints.CreditCardNumber
import org.hibernate.validator.constraints.Range
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class PaymentMethodRequest(@NotEmpty val name: String,
                                @NotEmpty val description: String,
                                @NotEmpty val customerId: String,
                                @NotEmpty @CreditCardNumber(message = "invalid card number", ignoreNonDigitCharacters = true) val cardNumber: String,
                                @Pattern(regexp = "^\\d{4}\$") @NotEmpty val year: Int,
                                @NotEmpty @Range(min = 1, max = 12) val month: Int)

data class PaymentMethodUpdateRequest(val name: String,
                                      val description: String)

data class PaymentMethodDTO(val paymentMethodId: String,
                            val name: String,
                            val description: String,
                            val customerId: String,
                            val cardNumber: String,
                            val year: Int,
                            val month: Int)

data class PaymentRequest(@NotEmpty val cvv: Int?)