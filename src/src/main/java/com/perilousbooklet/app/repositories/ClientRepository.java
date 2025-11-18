package com.perilousbooklet.app.repositories;

import com.perilousbooklet.app.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>{
  
  public Client findByEmail(String email);
  
}
