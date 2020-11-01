package DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Entidad.Programa;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ProgramaDAO {
    static final String DB_URL
            = "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
        static final String DB_DRV
            = "com.mysql.jdbc.Driver";
        static final String DB_USER
            = "admin";
        static final String DB_PASSWD
            = "4waxA687";
    
    public ArrayList<Programa> getAllProgramsAvailable() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Programa> programs = new ArrayList<Programa>();
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Programa");
            while(resultSet.next()){
                Programa program = new Programa(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                programs.add(program);
            }
            return programs;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return programs;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return programs;
            } catch (SQLException ex) {
            }
        }
    }
    
    public boolean crear(Programa object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Programa (`Nombre`, `Version`) VALUES"
                    + " ('" + object.getNombre() + "','" + object.getVersion()+ "')");
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

    public boolean leer(Programa par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Programa "
                    + "WHERE Id_Programa = " + par.getId());
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

    public boolean actualizar(Programa oldPrograma, Programa newPrograma) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Programa "
                    + "SET Id_Programa = " + newPrograma.getId() + " , "
                    + "Version = '" + newPrograma.getVersion()
                    + "' WHERE Id_Programa=" + oldPrograma.getId()+ ";");
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

    public boolean eliminar(Programa object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Programa "
                    + "WHERE Id_Programa= " + object.getId()+ ";");
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
