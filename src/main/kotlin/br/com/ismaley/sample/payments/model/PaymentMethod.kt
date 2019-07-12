package br.com.ismaley.sample.payments.model

import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
data class PaymentMethod(@Id var id: String? = UUID.randomUUID().toString(),
                         @Column(name = "description", nullable = false) val description: String? = null,
                         @Column(name = "card_number", nullable = false) val cardNumber: String? = null,
                         @Column(name = "year", nullable = false) val year: Int? = null,
                         @Column(name = "month", nullable = false) val month: Int? = null,
                         @Column(name = "name", nullable = false) val name: String? = null,
                         @Column(name = "customer_id", nullable = false) val customerId: String? = null) {
    fun pay() = "OK!"
}
