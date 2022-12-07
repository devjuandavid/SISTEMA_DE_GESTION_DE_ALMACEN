
package com.emergente.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static public String driver="com.mysql.jdbc.Driver";
    static public String url="jdbc:mysql://localhost:3306/bd_almacen";
    static public String usuario="root";
    static public String password="admin";
    
    protected Connection conn = null;

    public ConexionDB() {
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver"+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar"+ex.getMessage());
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la Conexion"+ex.getMessage());
        }
    }
}
