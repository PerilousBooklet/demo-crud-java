package com.perilousbooklet.app.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.perilousbooklet.app.repositories.ClientRepository;
import com.perilousbooklet.app.models.Client;
import com.perilousbooklet.app.models.ClientDTO;

@Service
@Transactional
public class ClientService {
  
  @Autowired
  private ClientRepository clientRepo;
  
  
  private void mapDTOToEntity(ClientDTO dto, Client entity) {
    entity.setFirstName(dto.getFirstName());
    entity.setLastName(dto.getLastName());
    entity.setEmail(dto.getEmail());
    entity.setPhone(dto.getPhone());
    entity.setAddress(dto.getAddress());
    entity.setStatus(dto.getStatus());
  }
  public ClientDTO mapEntityToDTO(Client entity) {
    ClientDTO dto = new ClientDTO();
    dto.setFirstName(entity.getFirstName());
    dto.setLastName(entity.getLastName());
    dto.setEmail(entity.getEmail());
    dto.setPhone(entity.getPhone());
    dto.setAddress(entity.getAddress());
    dto.setStatus(entity.getStatus());
    return dto;
  }
  
  
  public Optional<Client> findById(int id) {
    return clientRepo.findById(id);
  }
  public boolean emailExists(String email) {
    return clientRepo.findByEmail(email) != null;
  }
  public boolean emailExistsForOtherClient(String email, int excludedId) {
    Client existingClient = clientRepo.findByEmail(email);
    return existingClient != null && existingClient.getId() != excludedId;
  }
  
  
  public List<Client> getAllClients() {
    return clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }
  public Client createClient(ClientDTO dto) {
    Client client = new Client();
    mapDTOToEntity(dto, client);
    client.setCreatedAt(new Date());
    return clientRepo.save(client);
  }
  public Client updateClient(int id, ClientDTO dto) {
    Client client = clientRepo
      .findById(id)
      .orElseThrow(
        () -> new IllegalArgumentException("Client not found with ID: " + id)
      );
    mapDTOToEntity(dto, client);
    return clientRepo.save(client);
  }
  public boolean deleteClient(int id) {
    Optional<Client> client = clientRepo.findById(id);
    if (client.isPresent()) {
      clientRepo.delete(client.get());
      return true;
    }
    return false;
  }
  
}
