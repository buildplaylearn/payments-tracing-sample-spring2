package br.com.ismaley.sample.payments.repository

import br.com.ismaley.sample.payments.model.PaymentMethod
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<PaymentMethod, String>