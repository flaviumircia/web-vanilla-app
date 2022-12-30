package org.example.models;

public class Association {
    Long id;
    String payment;
    Long id_client;
    Long id_order;

    public Association(){

    }
    public Association(Long id, String payment, Long id_client, Long id_order) {
        this.id = id;
        this.payment = payment;
        this.id_client = id_client;
        this.id_order = id_order;
    }

    public Association(String payment, Long id_client, Long id_order) {
        this.payment = payment;
        this.id_client = id_client;
        this.id_order = id_order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", payment='" + payment + '\'' +
                ", id_client=" + id_client +
                ", id_order=" + id_order +
                '}';
    }
}
