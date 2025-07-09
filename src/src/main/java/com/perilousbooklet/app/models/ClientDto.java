package com.perilousbooklet.app.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

/**
 * The Class ClientDto.
 */
public class ClientDto {
  
  /** The first name. */
  // Fields
  @NotEmpty(message = "The first name is required!")
  private String firstName;

  /** The last name. */
  @NotEmpty(message = "The last name is required!")
  private String lastName;

  /** The email. */
  @NotEmpty(message = "The email is required!")
  @Email
  private String email;

  /** The phone. */
  private String phone;
  
  /** The address. */
  private String address;

  /** The status. */
  @NotEmpty(message = "The status is required!")
  private String status;  // New, Permanent, Lead, Occasional, Inactive
  
  // Access Methods
  /**
   * Gets the first name.
   *
   * @return the first name
   */
  // TODO: add input type checks
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
}
