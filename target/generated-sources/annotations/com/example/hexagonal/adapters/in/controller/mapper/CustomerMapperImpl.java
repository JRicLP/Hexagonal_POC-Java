package com.example.hexagonal.adapters.in.controller.mapper;

import com.example.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.example.hexagonal.adapters.in.controller.response.AddressResponse;
import com.example.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.example.hexagonal.application.core.domain.Address;
import com.example.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-24T15:24:23-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.21.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerRequest.getName() );
        customer.setCpf( customerRequest.getCpf() );

        return customer;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setName( customer.getName() );
        customerResponse.setAddress( addressToAddressResponse( customer.getAddress() ) );
        customerResponse.setCpf( customer.getCpf() );
        customerResponse.setCpfValid( customer.isCpfValid() );

        return customerResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setStreet( address.getStreet() );
        addressResponse.setCity( address.getCity() );
        addressResponse.setState( address.getState() );

        return addressResponse;
    }
}
