# Wev-vanilla-app
Vanilla project of a full stack application. 
No framework used.

# About
This is a project for the Database course 
It is built with Java, MySQL and Html/JSP.
The project should make CRUD operations from a front-end all the way to the back-end with the use of APIs.

# How it works
The project uses a simple UI for all CRUD operations on a database with a Many-to-Many relationship.
The "Vanilla" from the name of the project comes from the fact that no framework were used.
The database is "connected" to the back-end via the jdbc.mysql driver.
The source code uses native MySQL queries to manipulate the database.

# Database
The database has 2 main tables with a Many to Many relationship.
Because of the M:N relationship I have built another table named "Association" that stores the foreign keys from the Clients and Orders tables.
The Delete and Update functions are on cascade, meaning that they should delete/update if any of those that are connected through a foreign key are modified.

<img src="https://user-images.githubusercontent.com/74871618/212979682-1026945e-e8ac-4948-872e-a8dac68a1768.png" style="height:360px"/>
