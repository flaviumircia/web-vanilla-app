<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,org.example.*,java.sql.*, java.io.*, java.util.*"%>
<%@ page import="org.example.controllers.ClientController" %>
<%@ page import="org.example.services.ClientService" %>
<%@ page import="org.example.models.Client" %>
<%@ page import="org.example.controllers.OrdersController" %>
<%@ page import="org.example.models.Orders" %>
<%@ page import="org.example.controllers.AssociationController" %>
<%@ page import="org.example.models.Association" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Tabela Asocieri</title>
</head>
<jsp:useBean id="jb" scope="session" class="org.example.Main" />
<jsp:setProperty name="jb" property="*" />
<body>
<h1 align="center"> Tabela Asocieri:</h1>
<br/>
<p align="center"><a href="adauga-assn.jsp"><button>Adauga o asociere</button></a>
<p align="center"><a href="update-assn.jsp"><button>Modifica o asociere</button></a>
<p align="center"><a href="index.html"><button>Home</button></a></p>
<form action="sterge-assn.jsp" method="post">
  <table border="1" align="center">
    <tr>
      <td><b>Mark:</b></td>
      <td><b>Id Asociere:</b></td>
      <td><b>Plata:</b></td>
      <td><b>Id Client:</b></td>
      <td><b>Nume Client:</b></td>
      <td><b>Email Client:</b></td>
      <td><b>Id Comanda:</b></td>
      <td><b>Titlu Comanda:</b></td>
      <td><b>Total Comanda:</b></td>

    </tr>
    <%
      AssociationController associationController=JspApplication.getAssnController();
      OrdersController ordersController=JspApplication.getOrdersController();
      ClientController clientController=JspApplication.getClientController();
      List<Association> list=associationController.get();
      for(Association association:list){
        Client temp_client=clientController.getFirstClientById(association.getId_client());
        Orders temp_orders=ordersController.getFirstOrderById(association.getId_order());
    %>
    <tr>
      <td><input type="checkbox" name="primarykey" value="<%=association.getId()%>" /></td>
      <td><%= association.getId()%></td>
      <td><%= association.getPayment()%></td>
      <td><%= temp_client.getId()%></td>
      <td><%= temp_client.getName()%></td>
      <td><%= temp_client.getEmail()%></td>
      <td><%= temp_orders.getId()%></td>
      <td><%= temp_orders.getItem_title()%></td>
      <td><%= temp_orders.getTotal()%></td>

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
