
package DAO;

import static DAO.UsuarioDAO.DB_URL;
import Entidad.Encargado;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriela
 */
public class EncargadoDAO {
    static final String DB_URL =
            "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV =
            "com.mysql.jdbc.Driver";
    static final String DB_USER =
            "admin";
    static final String DB_PASSWD =
            "4waxA687";
    
    public boolean crear(Encargado object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Encargado(`Id_Encargado`, `Contraseña`, `Nombres`, `Apellidos`) VALUES ('"
                    + object.getId() + "' , '" + object.getContraseña() + "', '" + object.getNombres() + "' , '" 
                    + object.getApellidos() + "')");
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

    public Encargado leer(Encargado encargado) {
        Encargado datos = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Encargado "
                    + "WHERE Id_Encargado = BINARY '" + encargado.getId()+ "' AND Contraseña = BINARY '" + encargado.getContraseña() + "'");
            if(resultSet.next()){
                datos.setId(resultSet.getString(1));
                datos.setContraseña(resultSet.getString(2));
                datos.setNombres(resultSet.getString(3));
                datos.setApellidos(resultSet.getString(4));
            }
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return datos;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return datos;
            } catch (SQLException ex) {

            }
        }

    }

    public boolean actualizar(Encargado oldEncargado, Encargado newEncargado) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Encargado "
                    + "SET Id_Encargado = '" + newEncargado.getId() + "' , "
                    + "Contraseña = '" + newEncargado.getContraseña()+ "' , "
                    + "Nombres = '" + newEncargado.getNombres()+ "' , "
                    + "Apellidos = '" + newEncargado.getApellidos()+ "' "
                    + " WHERE Id_Encargado= '" + oldEncargado.getId()+ "' ;");
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

    public boolean eliminar(Encargado object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Encargado "
                    + "WHERE Id_Encargado = BINARY'" + object.getId()+ "';");
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
