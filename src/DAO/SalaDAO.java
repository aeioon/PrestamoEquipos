package DAO;

import Entidad.Sala;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SalaDAO {
    static final String DB_URL =
            "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV =
            "com.mysql.jdbc.Driver";
    static final String DB_USER =
            "admin";
    static final String DB_PASSWD =
            "4waxA687";
    
    public boolean crear(Sala object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Sala (`Codigo`, `Nombre`, `Tipo`, `EncargadoId_Encargado`, `EdificioId_Edificio`)"
                    + " VALUES ('" + object.getCodigo()+ "', '" + object.getNombre() + "', '" + object.getTipo()+ "', '" + object.getEncargado().getId()+ "'," 
                    + object.getEdificio().getId() + ")");
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

    public boolean leer(Sala par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Sala "
                    + "WHERE Id_Sala = " + par.getId());
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

    public boolean actualizar(Sala oldSala, Sala newSala) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Sala "
                    + "SET Id_Sala = " + newSala.getId() + " , "
                    + "Codigo = '" + newSala.getCodigo() +  "' , "
                    + "Nombre = '" + newSala.getNombre() +  "' , "
                    + "Tipo = '" + newSala.getTipo() +  "' , "
                    + "EncargadoId_Encargado = '" + newSala.getEncargado().getId() + "' , "
                    + "EdificioId_Edificio = " + newSala.getEdificio().getId()
                    + " WHERE Id_Sala=" + oldSala.getId()+ ";");
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

    public boolean eliminar(Sala object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Sala "
                    + "WHERE Id_Sala= " + object.getId()+ ";");
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
