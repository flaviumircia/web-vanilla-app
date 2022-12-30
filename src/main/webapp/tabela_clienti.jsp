<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,org.example.*,java.sql.*, java.io.*, java.util.*"%>
<%@ page import="org.example.controllers.ClientController" %>
<%@ page import="org.example.services.ClientService" %>
<%@ page import="org.example.models.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tabela Clienti</title>
</head>
<jsp:useBean id="jb" scope="session" class="org.example.Main" />
<jsp:setProperty name="jb" property="*" />
<body>
<h1 align="center"> Tabela Clienti:</h1>
<br/>
<p align="center"><a href="adauga-client.jsp"><button>Adauga un nou client</button></a>
<p align="center"><a href="update-client.jsp"><button>Modifica un client</button></a>
<p align="center"><a href="index.html"><button>Home</button></a></p>
<form action="sterge-client.jsp" method="post">
    <table border="1" align="center">
        <tr>
            <td><b>Mark:</b></td>
            <td><b>idClient:</b></td>
            <td><b>Nume:</b></td>
            <td><b>Email:</b></td>
            <td><b>City:</b></td>

        </tr>
        <%
            ClientController clientController=JspApplication.getClientController();
            List<Client> list=clientController.get();
            for(Client client:list){
        %>
        <tr>
            <td><input type="checkbox" name="primarykey" value="<%=client.getId()%>" /></td>
            <td><%= client.getId()%></td>
            <td><%= client.getName()%></td>
            <td><%= client.getEmail()%></td>
            <td><%= client.getAddress()%></td>
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
