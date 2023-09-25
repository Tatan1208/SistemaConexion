package com.jeac.connection.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class connectionDB {
    public static Connection getConnectionBD(){
        //Objeto para guardar la conexion
        Connection connection = null;

        //variables de conexion
        String db = "sena_db";
        String url = "jdbc:mysql://localhost:3307/" +db;
        String name = "root";
        String pass = "root";

        try{
            //Sirve para comprobar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, pass);
            //Intento conectarme a la base de datos
        }catch (ClassNotFoundException | SQLException ex){

            System.out.println("Ocurrio un error en la conexion: " + ex.getMessage());
        }

        return connection;
    }

    public static void main(String[] args) {
        Connection connection2 = getConnectionBD();

        if (connection2 != null){
            System.out.println("Todo fino pa' " + connection2 );
        }else{
            System.out.println("Pailas " + connection2);
        }

    }
}
