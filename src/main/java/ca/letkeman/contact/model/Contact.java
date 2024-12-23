package ca.letkeman.contact.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "middleName")
  private String middleName;

  @OneToMany(
      fetch = FetchType.LAZY,
      mappedBy = "contact",
      cascade = CascadeType.ALL
  )
  private List<Address> addresses = new ArrayList<>();


  public Contact(String firstName) {
    this.firstName = firstName;
  }

  public Contact(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public Contact() {
  }

  public Contact(Long id, String firstName, String middleName, String lastName, List<Address> addresses) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.addresses = addresses;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }


  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(getId(), contact.getId()) && Objects.equals(getFirstName(),
        contact.getFirstName()) && Objects.equals(getLastName(), contact.getLastName())
        && Objects.equals(getMiddleName(), contact.getMiddleName()) && Objects.equals(getAddresses(),
        contact.getAddresses());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFirstName(), getLastName(), getMiddleName(), getAddresses());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Contact.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("firstName='" + firstName + "'")
        .add("lastName='" + lastName + "'")
        .add("middleName='" + middleName + "'")
        .add("addresses=" + addresses)
        .toString();
  }
}
