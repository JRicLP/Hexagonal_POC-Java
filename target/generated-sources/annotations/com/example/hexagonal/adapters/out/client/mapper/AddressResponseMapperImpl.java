package com.example.hexagonal.adapters.out.client.mapper;

import com.example.hexagonal.adapters.out.client.response.AddressResponse;
import com.example.hexagonal.application.core.domain.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-24T15:24:23-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.21.1 (Oracle Corporation)"
)
@Component
public class AddressResponseMapperImpl implements AddressResponseMapper {

    @Override
    public Address toAdress(AddressResponse adressResponse) {
        if ( adressResponse == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( adressResponse.getStreet() );
        address.setCity( adressResponse.getCity() );
        address.setState( adressResponse.getState() );

        return address;
    }
}
