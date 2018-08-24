package com.hand.service.impl;

import com.hand.entity.Address;
import com.hand.mapper.AddressMapper;
import com.hand.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<Address> getAddressAll() {
        List<Address> addresses = addressMapper.AddressSelectAlls();
        return addresses;
    }
}
