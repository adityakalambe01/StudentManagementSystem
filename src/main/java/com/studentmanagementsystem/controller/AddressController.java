package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @GetMapping
    public List<Address> getAddress(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ) {
        return addressService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping(value = "/{id}")
    public Address getAddressById(@PathVariable(value = "id") int id) {
        return addressService.findById(id);
    }

    @GetMapping(value = "/area-{area}")
    public List<Address> getAddressByArea(@PathVariable("area") String area) {
        return addressService.findByAreaContaining(area);
    }

    @GetMapping(value = "/city-{city}")
    public List<Address> getAddressByCity(@PathVariable("city") String city) {
        return addressService.findByCityContaining(city);
    }

    @GetMapping(value = "/state-{state}")
    public List<Address> getAddressByState(@PathVariable("state") String state) {
        return addressService.findByStateContaining(state);
    }

    @GetMapping(value = "/district-{district}")
    public List<Address> getAddressByDistrict(@PathVariable("district") String district) {
        return addressService.findByDistrictContaining(district);
    }

    @GetMapping(value = "/zip-{zip}")
    public List<Address> getAddressByZip(@PathVariable("zip") Integer zip) {
        return addressService.findByZip(zip);
    }

    @DeleteMapping(value = "/{id}")
    public Object deleteAddressById(@PathVariable("id") int id) {
        return addressService.deleteById(id);
    }

    @PostMapping(value = "/save-all-address")
    public List<Address> saveAll(@RequestBody List<Address> addresses) {
        for (Address address : addresses) {
            addressService.save(address);
        }
        return addresses;
    }

    @PutMapping("/{id}")
    public Object updateAddress(@PathVariable("id") int id, @RequestBody Address updatedAddress) {
        Address address = addressService.updateAddress(id,updatedAddress);
        return address==null? "Address Not Found": address;
    }


    @GetMapping("/xx")
    public Object getAddresses(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize,

            @RequestParam(value = "area", required = false) String area,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "district", required = false) String district,
            @RequestParam(value = "pincode", required = false) Integer pinCode,
            @RequestParam(value = "id", required = false) Integer id

    ) {
        if (area!=null){
            return this.getAddressByArea(area);
        } else if (city!=null) {
            return this.getAddressByCity(city);
        }else if (state!=null) {
            return this.getAddressByState(state);
        }else if (district!=null) {
            return this.getAddressByDistrict(district);
        }else if (pinCode!=null && pinCode!=0) {
            return this.getAddressByZip(pinCode);
        }else if (id!=null && id!=0) {
            return this.getAddressById(id);
        }

        return getAddress(pageNumber, pageSize);
    }

}
