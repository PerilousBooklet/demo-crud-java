package com.perilousbooklet.app.repositories;

import com.perilousbooklet.app.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface ClientRepository.
 */
public interface ClientRepository extends JpaRepository<Client, Integer>{
  
  /**
   * Find by email.
   *
   * @param email the email
   * @return the client
   */
  public Client findByEmail(String email);
  
}
