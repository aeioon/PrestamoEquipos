package DAO;

import Entidad.Computador;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidad.Programa;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class ComputadorDAO {
    static final String DB_URL =
            "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV =
            "com.mysql.jdbc.Driver";
    static final String DB_USER =
            "admin";
    static final String DB_PASSWD =
            "4waxA687";
    
    public boolean crear(Computador object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Computador(`Sistema_Operativo`, `Hardware`, `Disponibilidad`, `SalaId_sala`) VALUES (\"" + object.getSistemaOperativo() + "\",\"" + object.getHardware()+ "\"," 
                    + (object.isDisponibilidad()?"1":"0") + "," + object.getIdSala() + ")");
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

    public boolean leer(Computador par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Computador "
                    + "WHERE Id_Equipo = " + par.getId());
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

    public boolean actualizar(Computador oldComp, Computador newComp) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Computador "
                    + "SET Id_Equipo = " + newComp.getId() + " , "
                    + "Sistema_Operativo = '" + newComp.getSistemaOperativo()+ "' , "
                    + "Hardware = '" + newComp.getHardware() + "' , "
                    + "Disponibilidad = " + (newComp.isDisponibilidad()?"1":"0") + " , "
                    + "SalaId_sala = " + newComp.getIdSala()
                    + " WHERE Id_Equipo=" + oldComp.getId()+ ";");
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

    public boolean eliminar(Computador object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Computador "
                    + "WHERE Id_Equipo= " + object.getId()+ ";");
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
    
    public boolean changeAvailability(Computador comp){
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            if (comp.isDisponibilidad()) {
                String update = "UPDATE Computador SET Disponibilidad = 0 WHERE Id_Equipo =" + comp.getId() + ";";
                resultSet = statement.executeUpdate(update);
            } else {
                String update = "UPDATE Computador SET Disponibilidad = 1 WHERE Id_Equipo =" + comp.getId() + ";";
                resultSet = statement.executeUpdate(update);
            }
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
    
    public static int getNextRequestId(){
        String[] informacion = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int nextId = 0;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT Id_Solicitud FROM Solicitud ORDER BY Id_Solicitud DESC LIMIT 1";                                
            resultSet = statement.executeQuery(consulta);
            resultSet.next();
            nextId = Integer.parseInt(resultSet.getString(1)) + 1;
            return nextId;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return nextId;
        }
    }
    
    public void createRequest(Computador comp, Usuario user){
        String request = "INSERT INTO Solicitud (Fecha, ComputadorId_Equipo, UsuarioId_Usuario) VALUES (curdate(), '" + comp.getId() + "', '" + user.getId() + "');";
    }

    public String[][] getInfo(ArrayList<Programa> programs) {
        String[][] informacion = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT C.Id_Equipo, E.Nombre, E.Id_Edificio, S.Id_sala\n"
                    + "FROM ((Computador_Programa AS CP INNER JOIN Computador AS C ON CP.Id_Equipo = C.Id_Equipo) \n"
                    + "INNER JOIN Sala AS S ON C.SalaId_sala = S.Id_sala) \n"
                    + "INNER JOIN Edificio AS E ON S.EdificioId_Edificio = E.Id_Edificio\n"
                    + "WHERE CP.Id_Programa IN(";
            for (int i = 0; i < programs.size(); i++) {
                consulta = consulta + programs.get(i).getId();
                if (i != (programs.size() - 1)) {
                    consulta = consulta + ",";
                }
            }
            consulta = consulta + ");";
            System.out.println(consulta);
            resultSet = statement.executeQuery(consulta);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println(columnsNumber);
            informacion = new String[columnsNumber][4];
            for (int i = 0; i < columnsNumber; i++) {
                if (resultSet.next()) {
                    informacion[i][0] = resultSet.getString(1);
                    informacion[i][1] = resultSet.getString(2);
                    informacion[i][2] = resultSet.getString(3);
                    informacion[i][3] = resultSet.getString(4);
                }
            }
            return informacion;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return informacion;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return informacion;
            } catch (SQLException ex) {

            }
        }
    }
    
    public static void main(String[] args) {
       
    }
}
