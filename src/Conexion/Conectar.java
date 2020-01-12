package Conexion;

import java.sql.*;

public class Conectar{

    static String bd = "ejemmplo";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    Connection connection = null;

    public Conectar(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,login,password);
        if (connection!=null){
            System.out.println("Conexi�n a base de datos "+bd+" OK\n");
        }
        }catch(SQLException | ClassNotFoundException ex){
            System.out.println("Error sql "+ex.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar(){
        connection = null;
    }


}
