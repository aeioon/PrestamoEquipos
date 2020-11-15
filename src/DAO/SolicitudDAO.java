package DAO;

import static DAO.ComputadorDAO.DB_URL;
import Entidad.Solicitud;
import Entidad.Programa;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class SolicitudDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER
            = "admin";
    static final String DB_PASSWD
            = "4waxA687";

    public int getIdSolicitud(Solicitud solicitud) {
        int id = -1;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String query = "SELECT max(Id_Solicitud) FROM Solicitud WHERE UsuarioId_Usuario = '" +  solicitud.getUsuario().getId() + "' AND ComputadorId_Equipo ='" + solicitud.getComputador().getId() + "';";
            System.out.println(query);
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return id;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return id;
            } catch (SQLException ex) {

            }
        }
    }

    public boolean VerifyActivity(Usuario usuario) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT CO.Id_Equipo\n" +
                                                "FROM (((Usuario AS US INNER JOIN Solicitud AS SO ON US.Id_Usuario = SO.UsuarioId_Usuario)\n" +
                                                        "INNER JOIN Computador AS CO ON SO.ComputadorId_Equipo = CO.Id_Equipo)\n" +
                                                        "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_sala)\n" +
                                                        "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n" +
                                                "WHERE  CO.Disponibilidad = 0 AND US.Id_Usuario = '" + usuario.getId() + "'AND SO.Id_Solicitud IN(SELECT Max(Id_Solicitud) \n" +
                                                                "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n" +
                                                                "GROUP BY Computador.Id_Equipo);");
            while (resultSet.next()) {
                return true;
            }
            return false;
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

    public boolean ChangeRequestStatus(Usuario usuario) {
        Connection connection = null;
        Statement statement = null;
        ResultSet query = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Solicitud SET Estado = 0 WHERE UsuarioId_Usuario = '" + usuario.getId() + "'");
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

    public boolean crear(Solicitud object) {
        java.util.Date miObjetoJavaUtilDate = new Date();
        Timestamp fecha = new Timestamp(miObjetoJavaUtilDate.getTime());
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Solicitud(`Fecha`, `ComputadorId_Equipo`, `UsuarioId_Usuario`) VALUES ('"
                    + fecha + "'," + object.getComputador().getId() + ",'" + object.getUsuario().getId() + "')");
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
            if (resultSet.next()) {
                return true;
            } else {
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

    public ArrayList<String[]> getInfo(Usuario user) {
        ArrayList<String[]> datos = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT SO.Id_Solicitud, CO.Id_Equipo, ED.Nombre, ED.Id_Edificio, SA.Codigo\n" +
                              "FROM ((Solicitud AS SO INNER JOIN Computador AS CO ON SO.ComputadorId_Equipo = CO.Id_Equipo)\n" +
                                    "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_sala)\n" +
                                    "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n" +
                              "WHERE  CO.Disponibilidad = 0 AND SO.UsuarioId_Usuario = '" + user.getId() + "' \n" +
                                                            "AND SO.Id_Solicitud IN(SELECT Max(Id_Solicitud) \n" +
                                                                                    "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n" +
                                                                                    "GROUP BY Computador.Id_Equipo);";
            System.out.println(consulta);
            // Comentario
            resultSet = statement.executeQuery(consulta);
            while(resultSet.next()) {
                String[] computador = {"","","","",""};
                computador[0] = Integer.toString(resultSet.getInt(1));
                computador[1] = Integer.toString(resultSet.getInt(2));
                computador[2] = resultSet.getString(3);
                computador[3] = Integer.toString(resultSet.getInt(4));
                computador[4] = resultSet.getString(5);
                datos.add(computador);
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

    public boolean eliminar(Solicitud object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Solicitud "
                    + "WHERE Id_Solicitud = " + object.getId() + ";");
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
