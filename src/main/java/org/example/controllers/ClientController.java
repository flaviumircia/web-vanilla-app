package org.example.controllers;

import org.example.models.Client;
import org.example.services.ClientService;

import java.util.List;

public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    public List<Client> get(){
        return clientService.show();
    }
    public void deleteClient(String[] primaryKeys){
        clientService.delete(primaryKeys);
    }
    public void addClient(Client client){
        clientService.add(client);
    }
    public void updateClient(Client client){
        clientService.update(client);
    }
    public Client getFirstClientById(Long id){
        return clientService.findClientById(id);
    }
}
