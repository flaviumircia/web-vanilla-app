package org.example;

import org.example.controllers.AssociationController;
import org.example.controllers.ClientController;
import org.example.controllers.OrdersController;
import org.example.misc.DatabaseConfig;
import org.example.misc.FileReader;
import org.example.misc.JavaBean;
import org.example.models.Association;
import org.example.models.Client;
import org.example.models.Orders;
import org.example.services.AssociationService;
import org.example.services.ClientService;
import org.example.services.OrdersService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//      Default settings
        FileReader fileReader=new FileReader();
        DatabaseConfig databaseConfig=new DatabaseConfig();
        HashMap<String,String> map=fileReader.readFromFile();
        databaseConfig.setName("pibd_vanilla_database");
        databaseConfig.setUser(map.get("user"));
        databaseConfig.setPassword(map.get("password"));
        JavaBean javaBean=new JavaBean(databaseConfig);

        //      Connect to database
        javaBean.connect();

        ClientService clientService=new ClientService(javaBean);
        ClientController clientController=new ClientController(clientService);
//        List<Client> list=clientController.get();
//        for(Client client:list){
//            System.out.println(client.toString());
//        }
        Client client=new Client(53L,"a","b","c","d","e","f","g");
//        clientController.updateClient(client);

        OrdersService ordersService=new OrdersService(javaBean);
        OrdersController ordersController=new OrdersController(ordersService);
        Orders order=new Orders(6L,"tastatura","tastatura thinqpad",1,125.99);
//        ordersController.updateOrder(order);
//        List<Orders> ordersList=ordersController.get();
//        for(Orders orders:ordersList){
//            System.out.println(orders);
//        }
        AssociationService associationService=new AssociationService(javaBean);
        AssociationController associationController=new AssociationController(associationService);
        Association associations=new Association();
        associations.setPayment("cash");
        associations.setId(13L);
//        associationController.de(associations,client,order);
        associationController.delete(new String[]{"13","17"});
        List<Association> list=associationController.get();
        for(Association association:list){
            System.out.println(association.toString());
            System.out.println(clientController.getFirstClientById(association.getId_client()).toString());
            System.out.println(ordersController.getFirstOrderById(association.getId_order()).toString());
        }

    }
}