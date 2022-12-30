<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,org.example.*,java.sql.*, java.io.*, java.util.*"%>
<%@ page import="org.example.controllers.ClientController" %>
<%@ page import="org.example.services.ClientService" %>
<%@ page import="org.example.models.Client" %>
<%@ page import="org.example.controllers.OrdersController" %>
<%@ page import="org.example.models.Orders" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Tabela Comenzi</title>
</head>
<jsp:useBean id="jb" scope="session" class="org.example.Main" />
<jsp:setProperty name="jb" property="*" />
<body>
<h1 align="center"> Tabela Comenzi:</h1>
<br/>
<p align="center"><a href="adauga-order.jsp"><button>Adauga o comanda</button></a>
<p align="center"><a href="update-order.jsp"><button>Modifica o comanda</button></a>
<p align="center"><a href="index.html"><button>Home</button></a></p>
<form action="sterge-order.jsp" method="post">
  <table border="1" align="center">
    <tr>
      <td><b>Mark:</b></td>
      <td><b>Id Order:</b></td>
      <td><b>Titlu:</b></td>
      <td><b>Descriere:</b></td>
      <td><b>Cantitate:</b></td>
      <td><b>Pret:</b></td>
      <td><b>Total:</b></td>

    </tr>
    <%
      OrdersController ordersController=JspApplication.getOrdersController();
      List<Orders> list=ordersController.get();
      for(Orders orders:list){
    %>
    <tr>
      <td><input type="checkbox" name="primarykey" value="<%=orders.getId()%>" /></td>
      <td><%= orders.getId()%></td>
      <td><%= orders.getItem_title()%></td>
      <td><%= orders.getItem_description()%></td>
      <td><%= orders.getQuantity()%></td>
      <td><%= orders.getUnit_price()%></td>
      <td><%= orders.getTotal()%></td>

      <%
        }
      %>
    </tr>
  </table><br/>
  <p align="center">
    <input type="submit" value="Sterge liniile marcate">
  </p>
</form>
<br/>
<p align="center">
  <a href="index.html"><b>Home</b></a>
  <br/>
</p>
</body>
</html>
