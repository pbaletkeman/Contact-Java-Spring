package ca.letkeman.contact.repository;

import ca.letkeman.contact.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Custom queries can be added here if needed
//    List<Address> findByName(String name);
    List<Address> findByContactId(long id);
}
