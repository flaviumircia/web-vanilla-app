<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,org.example.*,java.sql.*, java.io.*, java.util.*"%>
<%@ page import="org.example.controllers.ClientController" %>
<%@ page import="org.example.models.Client" %>
<%@ page import="org.example.controllers.OrdersController" %>
<%@ page import="org.example.models.Orders" %>
<%@ page import="org.example.models.Association" %>
<%@ page import="org.example.controllers.AssociationController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifica Asociere</title>
</head>
<jsp:useBean id="jb" scope="session" class="org.example.Main" />
<jsp:setProperty name="jb" property="*" />
<body>
<%
    String id_client=request.getParameter("id_client");
    String id_order=request.getParameter("id_order");
    String id_assn=request.getParameter("id_assn");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String zipcode = request.getParameter("zipcode");
    String phone_number = request.getParameter("phone_number");
    String title = request.getParameter("item_title");
    String itemDescription = request.getParameter("item_description");
    String quantity = request.getParameter("quantity");
    String unitPrice = request.getParameter("unit_price");
    String payment=request.getParameter("payment");
    if(id_assn!=null && id_client!=null && id_order!=null && title!=null && itemDescription!=null && quantity!=null && unitPrice!=null &&name!=null && email!=null && address!=null && city!=null && state!=null && zipcode!=null && phone_number!=null && payment!=null){
        Orders orders=new Orders(Long.valueOf(id_order),title,itemDescription,Integer.valueOf(quantity),Double.valueOf(unitPrice));
        Client client=new Client(Long.valueOf(id_client),name,email,address,city,state,zipcode,phone_number);
        Association association=new Association();
        association.setPayment(payment);
        association.setId(Long.valueOf(id_assn));
        AssociationController associationController=JspApplication.getAssnController();
        associationController.update(association,client,orders);

%>
<p>Datele au fost adaugate.</p><%
} else {
%>
<h1> Suntem in tabela Asociere.</h1>
<form action="update-assn.jsp" method="post">
    <table>
        <tr>
            <td align="right">Id Asociere:</td>
            <td> <input type="text" name="id_assn" size="40" /></td>
        </tr>
        <tr>
            <td align="right">Id Client:</td>
            <td> <input type="text" name="id_client" size="40" /></td>
        </tr>
        <tr>
            <td align="right">Name:</td>
            <td> <input type="text" name="name" size="40" /></td>
        </tr>
        <tr>
            <td align="right">Email:</td>
            <td> <input type="text" name="email" size="30" /></td>
        </tr>
        <tr>
            <td align="right">Address:</td>
            <td> <input type="text" name="address" size="30" /></td>
        </tr>
        <tr>
            <td align="right">City:</td>
            <td> <input type="text" name="city" size="30" /></td>
        </tr>
        <tr>
            <td align="right">State:</td>
            <td> <input type="text" name="state" size="30" /></td>
        </tr>
        <tr>
            <td align="right">Zipcode:</td>
            <td> <input type="text" name="zipcode" size="30" /></td>
        </tr>
        <tr>
            <td align="right">Phone Number:</td>
            <td> <input type="text" name="phone_number" size="30" /></td>
        </tr>
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
        <tr>
            <td align="right">Plata:</td>
            <td> <input type="text" name="payment" size="30" /></td>
        </tr>
    </table>
    <input type="submit" value="Adauga Asocierea" />
</form>
<%
    }
%>
<br/>
<a href="index.html"><b>Home</b></a>
<br/>
</body>
</html>
