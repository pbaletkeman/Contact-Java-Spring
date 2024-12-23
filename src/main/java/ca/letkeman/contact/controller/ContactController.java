package ca.letkeman.contact.controller;

import ca.letkeman.contact.model.Contact;
import ca.letkeman.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contacts/v1")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Create a new contact
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact savedExercise = contactService.createContact(contact);
        return ResponseEntity.ok(savedExercise);
    }

    // Update an existing contact
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Contact updatedContact = contactService.updateContact(id, contact);
        return ResponseEntity.ok(updatedContact);
    }

    // List all contacts
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    // View details of a specific contact
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{ids}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable String ids) {
        contactService.deleteManyContacts(ids);
    }

    // Other endpoints (e.g., delete, additional queries) can be added as needed
}
