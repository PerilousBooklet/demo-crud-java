package com.perilousbooklet.app.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perilousbooklet.app.models.Client;
import com.perilousbooklet.app.models.ClientDTO;
import com.perilousbooklet.app.repositories.ClientRepository;
import com.perilousbooklet.app.services.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
  
  @Autowired
  private ClientRepository clientRepo;
  
  @Autowired
  private ClientService clientService;
  
  
  // Homepage
  @GetMapping({"", "/"})
  public String getClients(Model model) {
    List<Client> clients = clientService.getAllClients();
    model.addAttribute("clients", clients);
    return "clients/index";
  }
  
  // New client
  @GetMapping("/create")
  public String createClient(Model model) {
    ClientDTO clientDto = new ClientDTO();
    model.addAttribute("clientDto", clientDto);
    return "clients/create";
  }
  @PostMapping("/create")
  public String createClient(@Valid @ModelAttribute ClientDTO clientDto, BindingResult result) {
    if (clientRepo.findByEmail(clientDto.getEmail()) != null) {
      result.addError(new FieldError(
        "clientDto", 
        "email", 
        clientDto.getEmail(), 
        false, 
        null, 
        null, 
        "Email address is already used!"
      ));
    }
    if (result.hasErrors()) {
      return "clients/create";
    }
    
    clientService.createClient(clientDto);
    
    return "redirect:/clients";
  }
  
  
  // Edit existing client
  @GetMapping("/edit")
  public String editClient(Model model, @RequestParam int id) {
    Client client = clientRepo.findById(id).orElse(null);
    if (client == null) {
      return "redirect:/clients";
    }
    
    ClientDTO clientDto = clientService.mapEntityToDTO(client);
    model.addAttribute("client", client);
    model.addAttribute("clientDto", clientDto);
    
    return "clients/edit";
  }
  @PostMapping("/edit")
  public String editClient(
    Model model, 
    @RequestParam int id, 
    @Valid @ModelAttribute ClientDTO clientDto, 
    BindingResult result
  ) {
    Client client = clientRepo.findById(id).orElse(null);
    if (client == null) {
      return "redirect:/clients";
    }
    
    model.addAttribute("client", client);
    
    if (clientService.emailExistsForOtherClient(clientDto.getEmail(), id)) {
      result.addError(new FieldError(
        "clientDto",
        "email", 
        clientDto.getEmail(), 
        false, 
        null, 
        null, 
        "Email address is already used!"
      ));
    }
    if (result.hasErrors()) {
      return "clients/edit";
    }
    
    clientService.updateClient(id, clientDto);
    
    return "redirect:/clients";
  }

  
  // Delete client
  @GetMapping("/delete")
  public String deleteClient(@RequestParam int id) {
    clientService.deleteClient(id);
    return "redirect:/clients";
  }
  
}
