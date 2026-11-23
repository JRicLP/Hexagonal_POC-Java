package com.example.hexagonal.application.core.usecase;

import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.hexagonal.application.ports.out.UpdatesCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdatesCustomerOutputPort updatesCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort
    , UpdatesCustomerOutputPort updatesCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updatesCustomerOutputPort = updatesCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updatesCustomerOutputPort.update(customer);
    }
}
