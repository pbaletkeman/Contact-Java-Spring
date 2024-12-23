package ca.letkeman.contact.controller;

import ca.letkeman.contact.model.Address;
import ca.letkeman.contact.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address/v1")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // Create a new Address
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address savedAddress = addressService.createAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    // Update an existing Address
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        return ResponseEntity.ok(updatedAddress);
    }

    // List all Address
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    // View details of a specific Address
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{ids}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable String ids) {
        addressService.deleteManyAddresses(ids);
    }

    // List all Addresses
    @GetMapping("/contacts/{id}")
    public ResponseEntity<List<Address>> getContactAddresses(@PathVariable long id) {
        List<Address> addresses = addressService.getAddressByContact(id);
        return ResponseEntity.ok(addresses);
    }
    // Other endpoints (e.g., delete, additional queries) can be added as needed
}
