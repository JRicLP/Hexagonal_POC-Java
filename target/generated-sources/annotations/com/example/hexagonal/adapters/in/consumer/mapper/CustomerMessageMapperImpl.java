package com.example.hexagonal.adapters.in.consumer.mapper;

import com.example.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.example.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-24T15:24:23-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.21.1 (Oracle Corporation)"
)
@Component
public class CustomerMessageMapperImpl implements CustomerMessageMapper {

    @Override
    public Customer toCustomer(CustomerMessage customerMessage) {
        if ( customerMessage == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerMessage.getId() );
        customer.setName( customerMessage.getName() );
        customer.setCpf( customerMessage.getCpf() );

        return customer;
    }
}
