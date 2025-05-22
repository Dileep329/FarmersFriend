package com.friend.farmers.service;

import com.ecommerce.flipkart.exception.ResourceNotFoundException;
import com.ecommerce.flipkart.models.Address;
import com.ecommerce.flipkart.models.User;
import com.ecommerce.flipkart.payload.AddressDTO;
import com.ecommerce.flipkart.respository.AddressRepository;
import com.ecommerce.flipkart.respository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
       Address address=modelMapper.map(addressDTO, Address.class);
       List<Address> addressList=user.getAddressList();
       addressList.add(address);
       user.setAddressList(addressList);
       address.setUser(user);
       addressRepository.save(address);
       return addressDTO;
    }

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map(address->modelMapper.map(address,AddressDTO.class)).toList();
    }

    @Override
    public AddressDTO getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId).
                orElseThrow(()->new ResourceNotFoundException("Address","addressId",addressId));
        return modelMapper.map(address,AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getUserAddresses(User user) {
        List<Address> addresses = user.getAddressList();
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .toList();
    }

    @Override
    public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) {
        Address addressFromDatabase = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
        addressFromDatabase.setCity(addressDTO.getCity());
        addressFromDatabase.setPincode(addressDTO.getPincode());
        addressFromDatabase.setState(addressDTO.getState());
        addressFromDatabase.setCountry(addressDTO.getCountry());
        addressFromDatabase.setStreet(addressDTO.getStreet());
        addressFromDatabase.setBuildingName(addressDTO.getBuildingName());
        Address updatedAddress = addressRepository.save(addressFromDatabase);
        User user = addressFromDatabase.getUser();
        user.getAddressList().removeIf(address -> address.getAddress_id().equals(addressId));
        user.getAddressList().add(updatedAddress);
        userRepository.save(user);
        return modelMapper.map(updatedAddress, AddressDTO.class);
    }



    @Override
    public String deleteAddress(Long addressId) {
        Address addressFromDatabase = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
        User user = addressFromDatabase.getUser();
        user.getAddressList().removeIf(address -> address.getAddress_id().equals(addressId));
        userRepository.save(user);
        addressRepository.delete(addressFromDatabase);
        return "Address deleted successfully with addressId: " + addressId;

    }

}
