package org.example.models;

import java.beans.Transient;

public class Orders {
    Long id;
    String item_title;
    String item_description;
    Integer quantity;
    Double unit_price;
    Double total;
    public  Orders(){}
    public Orders(Long id, String item_title, String item_description, Integer quantity, Double unit_price) {
        this.id = id;
        this.item_title = item_title;
        this.item_description = item_description;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Orders(String item_title, String item_description, Integer quantity, Double unit_price) {
        this.item_title = item_title;
        this.item_description = item_description;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    @Transient
    public Double getTotal() {
        return this.unit_price*this.quantity;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", item_title='" + item_title + '\'' +
                ", item_description='" + item_description + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", total=" + getTotal() +
                '}';
    }
}
