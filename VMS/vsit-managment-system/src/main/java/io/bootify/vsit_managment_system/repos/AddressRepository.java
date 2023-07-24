package io.bootify.vsit_managment_system.repos;

import io.bootify.vsit_managment_system.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
