package ca.letkeman.contact;

import ca.letkeman.contact.repository.ContactRepository;
import ca.letkeman.contact.repository.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {

  private final ContactRepository contactRepository;
  private final AddressRepository addressRepository;

  public SampleDataLoader(ContactRepository contactRepository, AddressRepository addressRepository) {
    this.contactRepository = contactRepository;
    this.addressRepository = addressRepository;
  }

  @Override
  public void run(String... args) {

  }
}
