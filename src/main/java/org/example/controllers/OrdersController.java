package org.example.controllers;

import org.example.models.Orders;
import org.example.services.OrdersService;

import java.util.List;

public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    public List<Orders> get(){
        return ordersService.show();
    }
    public void addOrder(Orders order){
        ordersService.add(order);
    }
    public void updateOrder(Orders order){
        ordersService.update(order);
    }
    public void deleteOrder(String[] primaryKeys){
        ordersService.delete(primaryKeys);
    }
    public Orders getFirstOrderById(Long id){
        return ordersService.findOrdersById(id);
    }
}
