
package DAO;

import Entidad.Solicitud;
import Entidad.Programa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class SolicitudDAO {
     static final String DB_URL =
            "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV =
            "com.mysql.jdbc.Driver";
    static final String DB_USER =
            "admin";
    static final String DB_PASSWD =
            "4waxA687";
    
    public boolean crear(Solicitud object) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = object.getFecha().format(formatter);
        
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Solicitud(`Fecha`, `ComputadorId_Equipo`, `UsuarioId_Usuario`, `Estado`) VALUES ('"
                    + fecha + "'," + object.getComputador().getId() + ",'" + object.getUsuario().getId() + "'," + object.getEstado() + ")");
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }

    public boolean leer(Solicitud par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Solicitud "
                    + "WHERE Id_Solicitud = " + par.getId());
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return resultSet.next();
            } catch (SQLException ex) {

            }
        }

    }

    public boolean actualizar(Solicitud oldSolicitud, Solicitud newSolicitud) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = newSolicitud.getFecha().format(formatter);
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Solicitud "
                    + "SET Id_Solicitud = " + newSolicitud.getId() + " , "
                    + "Fecha = '" + fecha + "' , "
                    + "ComputadorId_Equipo = " + newSolicitud.getComputador().getId() + " , "
                    + "UsuarioId_Usuario = '" + newSolicitud.getUsuario().getId() + " ' ,"
                    + "Estado = " + newSolicitud.getEstado()
                    + "WHERE Id_Solicitud=" + oldSolicitud.getId()+ ";");
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
                connection.close();

            } catch (SQLException ex) {

            }
        }
    }

    public boolean eliminar(Solicitud object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Solicitud "
                    + "WHERE Id_Solicitud= " + object.getId()+ ";");
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
                connection.close();

            } catch (SQLException ex) {

            }
        }
    }
   
}
