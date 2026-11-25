package com.example.hexagonal.application.core.usecase;

import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.example.hexagonal.application.ports.out.SendCPFForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCPFForValidationOutputPort sendCPFForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCPFForValidationOutputPort sendCPFForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCPFForValidationOutputPort = sendCPFForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var adress = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(adress);
        insertCustomerOutputPort.insert(customer);
        sendCPFForValidationOutputPort.send(customer.getCpf());
    }
}
