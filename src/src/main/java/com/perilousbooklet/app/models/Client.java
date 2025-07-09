package com.perilousbooklet.app.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

/**
 * The Class Client.
 */
@Entity
@Table(name = "clients")
public class Client {

  /** The id. */
  // Fields
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  /** The first name. */
  private String firstName;
  
  /** The last name. */
  private String lastName;

  /** The email. */
  @Column(unique = true, nullable = false)
  private String email;

  /** The phone. */
  private String phone;
  
  /** The address. */
  private String address;
  
  /** The status. */
  private String status;  // New, Permanent, Lead, Occasional, Inactive

  /** The created at. */
  private Date createdAt;
  

  /**
   * Gets the id.
   *
   * @return the id
   */
  // Access methods
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name.
   *
   * @param firstName the new first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName the new last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets the phone.
   *
   * @param phone the new phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets the address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address.
   *
   * @param address the new address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Gets the created at.
   *
   * @return the created at
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the created at.
   *
   * @param createdAt the new created at
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
