package com.mobile.api.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    public static java.sql.Connection getConnection() {
        Connection connection = null;
        try {
            /* Obt�m o driver de conex�o com o banco de dados */
            Class.forName("com.mysql.jdbc.Driver");
            /* Configura os par�metros da conex�o */
            String url = "jdbc:mysql://localhost:3306/mobileapi";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco de dados.");
            return null;
        }
    }
}

