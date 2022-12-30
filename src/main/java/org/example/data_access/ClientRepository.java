package org.example.data_access;

import org.example.models.Client;

import java.util.List;

public interface ClientRepository{


    void add(Client client);
    void update(Client client);
    void delete(String[] primaryKeys);
    public List show();
    Client findClientById(Long id);
    Client getLastClient();
}
