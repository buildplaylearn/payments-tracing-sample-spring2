package br.com.ismaley.sample.payments

import br.com.ismaley.sample.payments.model.PaymentMethod
import br.com.ismaley.sample.payments.repository.PaymentRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan(basePackageClasses = [PaymentMethod::class])
@EnableJpaRepositories(basePackageClasses = [PaymentRepository::class])
@SpringBootApplication
class PaymentsTracingSample2Application

fun main(args: Array<String>) {
	runApplication<PaymentsTracingSample2Application>(*args)
}
