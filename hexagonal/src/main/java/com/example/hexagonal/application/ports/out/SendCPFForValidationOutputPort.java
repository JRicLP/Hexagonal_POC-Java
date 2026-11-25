package com.example.hexagonal.application.ports.out;

public interface SendCPFForValidationOutputPort {

    void send(String cpf);
}
