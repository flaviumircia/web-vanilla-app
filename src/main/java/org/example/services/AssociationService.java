package org.example.services;

import org.example.data_access.AssociationRepository;
import org.example.misc.JavaBean;
import org.example.models.Association;
import org.example.models.Client;
import org.example.models.Orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssociationService implements AssociationRepository {
    private final JavaBean javaBean;

    public AssociationService(JavaBean javaBean) {
        this.javaBean = javaBean;
    }

    @Override
    public List<Association> show() {
        ResultSet resultSet=null;
        String select_query="select " +
                "a.id,a.payment," +
                "c.id as 'id client',c.name as 'client name',c.email as 'client email'," +
                "o.id_order as 'id order',o.item_title as 'order title',o.quantity as 'quantity', o.unit_price as 'unit price', o.total as 'total'" +
                " from association a " +
                "inner join client c on a.id_client=c.id " +
                "inner join orders o on a.id_order=o.id_order;";
        List<Association> list=new ArrayList<>();
        try{
            javaBean.connect();
            Statement statement=javaBean.getCon().createStatement();
            resultSet=statement.executeQuery(select_query);
            while(resultSet.next()){
                Association association=new Association(resultSet.getLong("id"),
                        resultSet.getString("payment"),
                        resultSet.getLong("id client"),
                        resultSet.getLong("id order")
                );
                list.add(association);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();
        return list;
    }

    @Override
    public void add(Association association, Client client, Orders order) {
        try{
            ClientService clientService=new ClientService(javaBean);
            OrdersService ordersService=new OrdersService(javaBean);
            PreparedStatement statement;
            clientService.add(client);
            ordersService.add(order);
            Client temp_client=clientService.getLastClient();
            Orders temp_order=ordersService.getLastOrder();
            javaBean.connect();
            statement=javaBean.getCon().prepareStatement("insert into association(payment,id_client, id_order) VALUES(?,?,?)");
            statement.setString(1,association.getPayment());
            statement.setLong(2,temp_client.getId());
            statement.setLong(3,temp_order.getId());
            statement.execute();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();

    }

    @Override
    public void update(Association association,Client client,Orders order) {
        try{
            ClientService clientService=new ClientService(javaBean);
            OrdersService ordersService=new OrdersService(javaBean);
            PreparedStatement statement;
            clientService.update(client);
            ordersService.update(order);
            javaBean.connect();
            statement=javaBean.getCon().prepareStatement("update association set payment=?,id_client=?, id_order=? where id=?");
            statement.setString(1,association.getPayment());
            statement.setLong(2,client.getId());
            statement.setLong(3,order.getId());
            statement.setLong(4,association.getId());
            statement.execute();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();
    }

    @Override
    public void delete(String[] primaryKeys) {
        try{
            long index;
            PreparedStatement delete;
            javaBean.connect();
            delete=javaBean.getCon().prepareStatement("delete from association where id=?");
            for(String primaryKey:primaryKeys){
                index=Long.parseLong(primaryKey);
                delete.setLong(1,index);
                delete.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();
    }

}
