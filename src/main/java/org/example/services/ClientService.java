package org.example.services;

import org.example.data_access.ClientRepository;
import org.example.misc.DatabaseConfig;
import org.example.misc.JavaBean;
import org.example.models.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements ClientRepository {
    private final JavaBean javaBean;
    public ClientService(JavaBean javaBean) {
        this.javaBean = javaBean;
    }


    @Override
    public void add(Client client) {
        try{
            javaBean.connect();
            PreparedStatement statement;
            statement=javaBean.getCon().prepareStatement("insert into client(address, city, email, name, phone_no, state, zipcode) VALUES(?,?,?,?,?,?,?)");
            statement.setString(1,client.getAddress());
            statement.setString(2,client.getCity());
            statement.setString(3,client.getEmail());
            statement.setString(4,client.getName());
            statement.setString(5,client.getPhone_no());
            statement.setString(6,client.getState());
            statement.setString(7,client.getZipcode());
            statement.execute();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();

    }

    @Override
    public void update(Client client) {
        try{
            javaBean.connect();
            PreparedStatement statement;
            statement=javaBean.getCon().prepareStatement("update client set client.address=?,client.city=?,client.email=?,client.name=?,client.phone_no=?,client.state=?,client.zipcode=? where id=?");
            statement.setString(1,client.getAddress());
            statement.setString(2,client.getCity());
            statement.setString(3,client.getEmail());
            statement.setString(4,client.getName());
            statement.setString(5,client.getPhone_no());
            statement.setString(6,client.getState());
            statement.setString(7,client.getZipcode());
            statement.setLong(8,client.getId());
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
            delete=javaBean.getCon().prepareStatement("delete from client where id=?");
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



    @Override
    public List<Client> show() {
        ResultSet resultSet=null;
        String select_query="select * from pibd_vanilla_database.client";
        List<Client> list=new ArrayList<>();
        try{
            javaBean.connect();
            Statement statement=javaBean.getCon().createStatement();
            resultSet=statement.executeQuery(select_query);
            while(resultSet.next()){
                Client client=new Client(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("zipcode"),
                        resultSet.getString("phone_no")
                        );
                list.add(client);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
             javaBean.disconnect();
        return list;
    }

    @Override
    public Client findClientById(Long id) {
        ResultSet resultSet=null;
        String select_query="select * from pibd_vanilla_database.client where id=? limit 1";
        Client temp=new Client();
        try{
            PreparedStatement select_first;
            javaBean.connect();
            select_first=javaBean.getCon().prepareStatement(select_query);
            select_first.setLong(1,id);
            resultSet=select_first.executeQuery();
            if(resultSet.next()){
                temp=new Client(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("zipcode"),
                        resultSet.getString("phone_no")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }
    public Client getLastClient(){
        ResultSet resultSet=null;
        String select_query="select * from client order by id desc limit 1";
        Client temp=new Client();
        try{
            PreparedStatement select_first;
            javaBean.connect();
            select_first=javaBean.getCon().prepareStatement(select_query);
            resultSet=select_first.executeQuery();
            if(resultSet.next()){
                temp=new Client(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("zipcode"),
                        resultSet.getString("phone_no")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();
        return temp;
    }
}
