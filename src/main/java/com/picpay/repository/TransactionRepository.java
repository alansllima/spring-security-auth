package com.picpay.repository;

import com.picpay.domain.transaction.Transaction;
import com.picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
