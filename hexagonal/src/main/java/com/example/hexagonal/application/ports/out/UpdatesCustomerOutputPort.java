package com.example.hexagonal.application.ports.out;

import com.example.hexagonal.application.core.domain.Customer;

public interface UpdatesCustomerOutputPort {

    void update(Customer customer);
}
