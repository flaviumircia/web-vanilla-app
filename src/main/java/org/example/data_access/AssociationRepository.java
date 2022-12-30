package org.example.data_access;

import org.example.models.Association;
import org.example.models.Client;
import org.example.models.Orders;

import java.util.List;

public interface AssociationRepository{
    public List<Association> show();
    public void add(Association association, Client client, Orders orders);
    public void update(Association association, Client client, Orders orders);
    public void delete(String[] primaryKeys);
}
