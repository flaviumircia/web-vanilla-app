package org.example.data_access;

import org.example.models.Client;
import org.example.models.Orders;

import java.util.List;

public interface OrdersRepository {

    public List<Orders> show();
    public void add(Orders orders);
    public void update(Orders orders);
    public void delete(String[] primaryKeys);
    Orders findOrdersById(Long id);
    Orders getLastOrder();

}
