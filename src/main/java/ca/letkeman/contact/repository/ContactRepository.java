package ca.letkeman.contact.repository;

import ca.letkeman.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Custom queries can be added here if needed
    List<Contact> findByLastName(String lastName);

}
