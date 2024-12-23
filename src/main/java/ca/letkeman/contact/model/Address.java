package ca.letkeman.contact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "country")
  private String country;

  @Column(name = "title")
  private String title;

  @Column(name = "postalCode")
  private String postalCode;

  @Column(name = "phone")
  private String phone;

  @Column(name = "province")
  private String province;

  @Column(name = "city")
  private String city;

  @Column(name = "street1")
  private String street1;

  @Column(name = "street2")
  private String street2;

  @Column(name = "email")
  private String email;

  @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
  @JoinColumn(name = "contact_id")
  @JsonBackReference
  private Contact contact;

  public Address() {
  }

  public Address(String title, String postalCode, String phone, String province, String city, String street1,
      String street2, String email, Contact contact, String country) {
    this.title = title;
    this.postalCode = postalCode;
    this.phone = phone;
    this.province = province;
    this.city = city;
    this.street1 = street1;
    this.street2 = street2;
    this.email = email;
    this.contact = contact;
    this.country = country;
  }

  public Address(Long id, String country, String title, String postalCode, String phone, String province, String city,
      String street1, String street2, String email) {
    this.id = id;
    this.country = country;
    this.title = title;
    this.postalCode = postalCode;
    this.phone = phone;
    this.province = province;
    this.city = city;
    this.street1 = street1;
    this.street2 = street2;
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Contact getContact() {
    return contact;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(getId(), address.getId()) && Objects.equals(getCountry(),
        address.getCountry()) && Objects.equals(getTitle(), address.getTitle()) && Objects.equals(
        getPostalCode(), address.getPostalCode()) && Objects.equals(getPhone(), address.getPhone())
        && Objects.equals(getProvince(), address.getProvince()) && Objects.equals(getCity(),
        address.getCity()) && Objects.equals(getStreet1(), address.getStreet1()) && Objects.equals(
        getStreet2(), address.getStreet2()) && Objects.equals(getEmail(), address.getEmail())
        && Objects.equals(getContact(), address.getContact());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCountry(), getTitle(), getPostalCode(), getPhone(), getProvince(), getCity(),
        getStreet1(), getStreet2(), getEmail(), getContact());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("country='" + country + "'")
        .add("title='" + title + "'")
        .add("postalCode='" + postalCode + "'")
        .add("phone='" + phone + "'")
        .add("province='" + province + "'")
        .add("city='" + city + "'")
        .add("street1='" + street1 + "'")
        .add("street2='" + street2 + "'")
        .add("email='" + email + "'")
//        .add("contact=" + contact)
        .toString();
  }
}
