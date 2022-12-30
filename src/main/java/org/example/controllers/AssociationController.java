package org.example.controllers;

import org.example.models.Association;
import org.example.models.Client;
import org.example.models.Orders;
import org.example.services.AssociationService;

import java.util.List;

public class AssociationController {
    private final AssociationService associationService;

    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }
    public List<Association> get(){
        return associationService.show();
    }
    public void add(Association association, Client client, Orders orders){
        associationService.add(association,client,orders);
    }
    public void update(Association association, Client client, Orders orders){
        associationService.update(association,client,orders);
    }
    public void delete(String[] primaryKeys){
        associationService.delete(primaryKeys);
    }
}
