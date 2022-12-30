package org.example;

import org.example.controllers.AssociationController;
import org.example.controllers.ClientController;
import org.example.controllers.OrdersController;
import org.example.misc.DatabaseConfig;
import org.example.misc.FileReader;
import org.example.misc.JavaBean;
import org.example.services.AssociationService;
import org.example.services.ClientService;
import org.example.services.OrdersService;

import java.io.IOException;
import java.util.HashMap;

public class JspApplication {
    public static ClientController getClientController() throws IOException {
        FileReader fileReader=new FileReader();

        //        Database configuration
        DatabaseConfig databaseConfig=new DatabaseConfig();
        HashMap<String,String> map=fileReader.readFromFile();
        databaseConfig.setName("pibd_vanilla_database");
        databaseConfig.setUser(map.get("user"));
        databaseConfig.setPassword(map.get("password"));

        //      Connect to database
        JavaBean javaBean=new JavaBean(databaseConfig);
        javaBean.connect();

        ClientService clientService=new ClientService(javaBean);
        return new ClientController(clientService);
    }
    public static OrdersController getOrdersController() throws IOException{
        FileReader fileReader=new FileReader();

        //        Database configuration
        DatabaseConfig databaseConfig=new DatabaseConfig();
        HashMap<String,String> map=fileReader.readFromFile();
        databaseConfig.setName("pibd_vanilla_database");
        databaseConfig.setUser(map.get("user"));
        databaseConfig.setPassword(map.get("password"));

        //      Connect to database
        JavaBean javaBean=new JavaBean(databaseConfig);
        javaBean.connect();

        OrdersService ordersService=new OrdersService(javaBean);
    return new OrdersController(ordersService);}
    public static AssociationController getAssnController() throws IOException {
        FileReader fileReader = new FileReader();

        //        Database configuration
        DatabaseConfig databaseConfig = new DatabaseConfig();
        HashMap<String, String> map = fileReader.readFromFile();
        databaseConfig.setName("pibd_vanilla_database");
        databaseConfig.setUser(map.get("user"));
        databaseConfig.setPassword(map.get("password"));

        //      Connect to database
        JavaBean javaBean = new JavaBean(databaseConfig);
        javaBean.connect();

        AssociationService associationService = new AssociationService(javaBean);
        return new AssociationController(associationService);
    }
}
