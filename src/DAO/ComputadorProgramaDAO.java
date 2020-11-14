package DAO;

import Entidad.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Entidad.Programa;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComputadorProgramaDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER
            = "admin";
    static final String DB_PASSWD
            = "4waxA687";

    public boolean crear(Computador computador, Programa programa) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Computador_Programa (Id_Equipo, Id_Programa) VALUES(" + computador.getId() + "," + programa.getId() + ")");
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

    public boolean quitar(Computador computador, Programa programa) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Computador_Programa WHERE Id_Equipo = " + computador.getId() + " AND Id_Programa = " + programa.getId());
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

    public ArrayList<String[]> mostrar(Programa programa) {
        ArrayList<String[]> computadores = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT CP.Id_Equipo, ED.Id_Edificio, ED.Nombre, SA.Codigo \n"
                    + "FROM ((Computador_Programa AS CP INNER JOIN Computador AS CO ON CP.Id_Equipo = CO.Id_Equipo)\n"
                    + "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_Sala) \n"
                    + "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n"
                    + "WHERE CP.Id_Programa = " + programa.getId());
            while (resultSet.next()) {
                String[] computador = {"", "", "", ""};
                computador[0] = resultSet.getInt(1) + "";
                computador[1] = resultSet.getInt(2) + "";
                computador[2] = resultSet.getString(3);
                computador[3] = resultSet.getString(4);
                computadores.add(computador);
            }
            return computadores;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return computadores;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return computadores;
            } catch (SQLException ex) {

            }
        }
    }
    
    public ArrayList<String[]> equiposSinPrograma(Programa programa) {
        ArrayList<String[]> computadores = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT Equipos.Id_Equipo, ED.Id_Edificio, ED.Nombre, SA.Codigo\n" +
                                               "FROM (((SELECT Computador.Id_Equipo\n" +
                                                     "FROM Computador LEFT JOIN (Select Id_Equipo FROM Computador_Programa WHERE Id_Programa =" + programa.getId() + ") AS CP ON Computador.Id_Equipo = CP.Id_Equipo\n" +
                                                     "WHERE CP.Id_Equipo IS NULL) AS Equipos INNER JOIN Computador ON Equipos.Id_Equipo = Computador.Id_Equipo)\n" +
                                                     "INNER JOIN Sala AS SA ON Computador.SalaId_sala = SA.Id_Sala)\n" +
                                                     "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio;");
            while (resultSet.next()) {
                String[] computador = {"", "", "", ""};
                computador[0] = resultSet.getInt(1) + "";
                computador[1] = resultSet.getInt(2) + "";
                computador[2] = resultSet.getString(3);
                computador[3] = resultSet.getString(4);
                computadores.add(computador);
            }
            return computadores;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return computadores;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return computadores;
            } catch (SQLException ex) {

            }
        }

    }
}
