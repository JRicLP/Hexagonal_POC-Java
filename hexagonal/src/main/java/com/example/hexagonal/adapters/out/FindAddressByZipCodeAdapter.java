package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.out.client.FindAdressByZipCodeClient;
import com.example.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.example.hexagonal.application.core.domain.Address;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAdressByZipCodeClient findAdressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var adressResponse = findAdressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAdress(adressResponse);
    }
}
