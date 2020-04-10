package com.example.midterm.Repositories;

import com.example.midterm.Models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

    List<Customers> findByFirstName(String firstName);
}
