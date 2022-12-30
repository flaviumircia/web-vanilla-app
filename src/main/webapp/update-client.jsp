<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,org.example.*,java.sql.*, java.io.*, java.util.*"%>
<%@ page import="org.example.controllers.ClientController" %>
<%@ page import="org.example.models.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adauga Client</title>
</head>
<jsp:useBean id="jb" scope="session" class="org.example.Main" />
<jsp:setProperty name="jb" property="*" />
<body>
<%
    String id=request.getParameter("id");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String zipcode = request.getParameter("zipcode");
    String phone_number = request.getParameter("phone_number");
    Long id_client;
    if(id!=null && name!=null && email!=null && address!=null && city!=null && state!=null && zipcode!=null && phone_number!=null){
        ClientController clientController=JspApplication.getClientController();
        id_client=Long.valueOf(id);
        Client client=new Client(id_client,name,email,address,city,state,zipcode,phone_number);
        clientController.updateClient(client);

%>
<p>Datele au fost adaugate.</p><%
} else {
%>
<h1> Suntem in tabela Client.</h1>
<form action="update-client.jsp" method="post">
    <table>
        <tr>
            <td align="right">Id:</td>
            <td> <input type="text" name="id" size="40" /></td>
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
    </table>
    <input type="submit" value="Modifica clientul" />
</form>
<%
    }
%>
<br/>
<a href="index.html"><b>Home</b></a>
<br/>
</body>
</html>
