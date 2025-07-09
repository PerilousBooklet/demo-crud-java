package com.perilousbooklet.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perilousbooklet.app.repositories.ClientRepository;

import jakarta.validation.Valid;

import com.perilousbooklet.app.models.Client;
import com.perilousbooklet.app.models.ClientDto;

/**
 * The Class ClientsController.
 */
@Controller
@RequestMapping("/clients")
public class ClientsController {
  
  /** The client repo. */
  @Autowired
  private ClientRepository clientRepo;

  /**
   * Gets the clients.
   *
   * @param model the model
   * @return the clients
   */
  @GetMapping({"", "/"})
  public String getClients(Model model) {
    List<Client> clients = clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    model.addAttribute("clients", clients);
    return "clients/index";
  }

  /**
   * Creates the client.
   *
   * @param model the model
   * @return the string
   */
  @GetMapping("/create")
  public String createClient(Model model) {
    ClientDto clientDto = new ClientDto();
    model.addAttribute("clientDto", clientDto);
    return "clients/create";
  }

  /**
   * Creates the client.
   *
   * @param clientDto the client dto
   * @param result the result
   * @return the string
   */
  @PostMapping("/create")
  public String createClient(@Valid @ModelAttribute ClientDto clientDto, BindingResult result) {
    // Check if email address already exists
    if (clientRepo.findByEmail(clientDto.getEmail()) != null) {
      result.addError(new FieldError("clientDto", "email", clientDto.getEmail(), false, null, null, "Email address is already used!"));
    }
    // Check for validation errors
    if (result.hasErrors()) {
      return "clients/create";
    }
    // No validation errors -> create new client
    Client client = new Client();
    // Id is generated automatically (because of @GeneratedValue)
    client.setFirstName(clientDto.getFirstName());
    client.setLastName(clientDto.getLastName());
    client.setEmail(clientDto.getEmail());
    client.setPhone(clientDto.getPhone());
    client.setAddress(clientDto.getAddress());
    client.setStatus(clientDto.getStatus());
    client.setCreatedAt(new Date());
    clientRepo.save(client);
    
    return "redirect:/clients";
  }

  /**
   * Edits the client.
   *
   * @param model the model
   * @param id the id
   * @return the string
   */
  @GetMapping("/edit")
  public String editClient(Model model, @RequestParam int id) {
    Client client = clientRepo.findById(id).orElse(null);
    if (client == null) {
      return "redirect:/clients";
    }
    
    ClientDto clientDto = new ClientDto();
    clientDto.setFirstName(client.getFirstName());
    clientDto.setLastName(client.getLastName());
    clientDto.setEmail(client.getEmail());
    clientDto.setPhone(client.getPhone());
    clientDto.setAddress(client.getAddress());
    clientDto.setStatus(client.getStatus());

    model.addAttribute("client", client);
    model.addAttribute("clientDto", clientDto);

    return "clients/edit";
  }

  /**
   * Edits the client.
   *
   * @param model the model
   * @param id the id
   * @param clientDto the client dto
   * @param result the result
   * @return the string
   */
  @PostMapping("/edit")
  public String editClient(Model model, @RequestParam int id, @Valid @ModelAttribute ClientDto clientDto, BindingResult result) {
    Client client = clientRepo.findById(id).orElse(null);
    if (client == null) {
      return "redirect:/clients";
    }
    
    model.addAttribute("client", client);
    
    if (result.hasErrors()) {
      return "clients/edit";
    }

    // Update Client details
    client.setFirstName(clientDto.getFirstName());
    client.setLastName(clientDto.getLastName());
    client.setEmail(clientDto.getEmail());
    client.setPhone(clientDto.getPhone());
    client.setAddress(clientDto.getAddress());
    client.setStatus(clientDto.getStatus());

    try {
    	clientRepo.save(client);
    } catch (Exception e) {
    	result.addError(new FieldError("ClientDto", "email", clientDto.getEmail(), false, null, null, "Email address is already used"));
    	return "clients/edit";
    }
    
    return "redirect:/clients";
  }

  /**
   * Delete client.
   *
   * @param id the id
   * @return the string
   */
  @GetMapping("/delete")
  public String deleteClient(@RequestParam int id) {
    Client client = clientRepo.findById(id).orElse(null);
    if (client != null) {
      clientRepo.delete(client);
    }
    
    return "redirect:/clients";
  }
  
}
