package org.example.services;

import org.example.data_access.OrdersRepository;
import org.example.misc.JavaBean;
import org.example.models.Client;
import org.example.models.Orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersService implements OrdersRepository {
    private  final JavaBean javaBean;

    public OrdersService(JavaBean javaBean) {
        this.javaBean = javaBean;
    }

    @Override
    public List<Orders> show() {
        ResultSet resultSet=null;
        String select_query="select * from pibd_vanilla_database.orders";
        List<Orders> list=new ArrayList<>();
        try{
            javaBean.connect();
            Statement statement=javaBean.getCon().createStatement();
            resultSet=statement.executeQuery(select_query);
            while(resultSet.next()){
                Orders orders=new Orders(resultSet.getLong("id_order"),
                        resultSet.getString("item_title"),
                        resultSet.getString("item_description"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("unit_price")
                );
                list.add(orders);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();
        return list;
    }

    @Override
    public void add(Orders orders) {
        try{
            javaBean.connect();
            PreparedStatement statement;
            statement=javaBean.getCon().prepareStatement("insert into orders(item_title,item_description, quantity, unit_price, total) VALUES(?,?,?,?,?)");
            statement.setString(1,orders.getItem_title());
            statement.setString(2,orders.getItem_description());
            statement.setInt(3,orders.getQuantity());
            statement.setDouble(4,orders.getUnit_price());
            statement.setDouble(5,orders.getTotal());
            statement.execute();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();

    }

    @Override
    public void update(Orders orders) {
        try{
            javaBean.connect();
            PreparedStatement statement;
            statement=javaBean.getCon().prepareStatement("update orders set item_title=?,item_description=?, quantity=?, unit_price=?, total=? where id_order=?");
            statement.setString(1,orders.getItem_title());
            statement.setString(2,orders.getItem_description());
            statement.setInt(3,orders.getQuantity());
            statement.setDouble(4,orders.getUnit_price());
            statement.setDouble(5,orders.getTotal());
            statement.setLong(6,orders.getId());
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
            delete=javaBean.getCon().prepareStatement("delete from orders where id_order=?");
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
    public Orders findOrdersById(Long id) {
        ResultSet resultSet=null;
        String select_query="select * from pibd_vanilla_database.orders where id_order=? limit 1";
        Orders temp=new Orders();
        try{
            PreparedStatement select_first;
            javaBean.connect();
            select_first=javaBean.getCon().prepareStatement(select_query);
            select_first.setLong(1,id);
            resultSet=select_first.executeQuery();
            if(resultSet.next()){
                 temp=new Orders(resultSet.getLong("id_order"),
                        resultSet.getString("item_title"),
                        resultSet.getString("item_description"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("unit_price")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }
    public Orders getLastOrder(){
        ResultSet resultSet=null;
        String select_query="SELECT * FROM orders ORDER BY id_order DESC LIMIT 1";
        Orders temp=new Orders();
        try{
            PreparedStatement select_first;
            javaBean.connect();
            select_first=javaBean.getCon().prepareStatement(select_query);
            resultSet=select_first.executeQuery();
            if(resultSet.next()){
                temp=new Orders(resultSet.getLong("id_order"),
                        resultSet.getString("item_title"),
                        resultSet.getString("item_description"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("unit_price")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        javaBean.disconnect();
        return temp;
    }

}
