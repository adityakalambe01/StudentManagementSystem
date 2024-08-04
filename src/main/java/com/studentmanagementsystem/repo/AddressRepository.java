package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address save(Address address);

    Page<Address> findAll(Pageable pageable);

//    @Query(value = "from Address a where a.area=?1 and a.city=?2 and a.state=?3 and a.district=?4 and a.zip=?5")
//    Address findByAreaAndCityAndStateAndDistrictAndZip(String area, String city, String state, String district, String zip, Pageable pageable);

    Address findById(int id);

    List<Address> findByAreaContaining(String area);

    List<Address> findByCityContaining(String city);

    List<Address> findByStateContaining(String state);

    List<Address> findByDistrictContaining(String district);

    List<Address> findByZip(Integer zipcode);

    Address deleteById(int id);

}
