<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,org.example.*,java.sql.*, java.io.*, java.util.*"%>
<%@ page import="org.example.controllers.ClientController" %>
<%@ page import="org.example.models.Client" %>
<%@ page import="org.example.controllers.OrdersController" %>
<%@ page import="org.example.models.Orders" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifica Comanda</title>
</head>
<jsp:useBean id="jb" scope="session" class="org.example.Main" />
<jsp:setProperty name="jb" property="*" />
<body>
<%
    String id=request.getParameter("id_order");
    String title = request.getParameter("item_title");
    String itemDescription = request.getParameter("item_description");
    String quantity = request.getParameter("quantity");
    String unitPrice = request.getParameter("unit_price");
    if(id!=null && title!=null && itemDescription!=null && quantity!=null && unitPrice!=null){
        OrdersController ordersController=JspApplication.getOrdersController();
        Orders orders=new Orders(Long.valueOf(id),title,itemDescription,Integer.valueOf(quantity),Double.valueOf(unitPrice));
        ordersController.updateOrder(orders);
%>
<p>Datele au fost modificate.</p><%
} else {
%>
<h1> Suntem in tabela Comanda.</h1>
<form action="update-order.jsp" method="post">
    <table>
        <tr>
            <td align="right">Id Comanda:</td>
            <td> <input type="text" name="id_order" size="40" /></td>
        </tr>
        <tr>
            <td align="right">Titlu:</td>
            <td> <input type="text" name="item_title" size="40" /></td>
        </tr>
        <tr>
            <td align="right">Descriere:</td>
            <td> <input type="text" name="item_description" size="30" /></td>
        </tr>
        <tr>
            <td align="right">Cantitate:</td>
            <td> <input type="text" name="quantity" size="30" /></td>
        </tr>
        <tr>
            <td align="right">Pret:</td>
            <td> <input type="text" name="unit_price" size="30" /></td>
        </tr>

    </table>
    <input type="submit" value="Modifica Comanda" />
</form>
<%
    }
%>
<br/>
<a href="index.html"><b>Home</b></a>
<br/>
</body>
</html>
