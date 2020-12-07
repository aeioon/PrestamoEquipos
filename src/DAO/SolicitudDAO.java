package DAO;

import static DAO.ComputadorDAO.DB_URL;
import Entidad.Solicitud;
import Entidad.Programa;
import Entidad.Usuario;
import Entidad.Computador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    public boolean verifyComputerOccupation(Computador computador) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT SO.Id_Solicitud\n"
                    + "FROM Solicitud AS SO\n"
                    + "WHERE SO.Id_Solicitud IN(SELECT Max(Id_Solicitud)\n"
                    + "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n"
                    + "WHERE '" + LocalDateTime.now() + "' > Solicitud.FechaHoraInicio AND '" + LocalDateTime.now() + "' < Solicitud.FechaHoraFin AND ComputadorId_Equipo = " + computador.getId() + ");");
            while (resultSet.next()) {
                return false;
            }
            return true;
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

    // Devuelve el id de una solicitud
    public int getIdSolicitud(Solicitud solicitud) {
        int id = -1;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String query = "SELECT max(Id_Solicitud) FROM Solicitud WHERE UsuarioId_Usuario = '" + solicitud.getUsuario().getId() + "'";
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

    // verifica que el usuario no tenga un dispositivo de computo asignado a su cuenta
    public boolean VerifyActivity(Usuario usuario) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT CO.Id_Equipo\n"
                    + "FROM (((Usuario AS US INNER JOIN Solicitud AS SO ON US.Id_Usuario = SO.UsuarioId_Usuario)\n"
                    + "INNER JOIN Computador AS CO ON SO.ComputadorId_Equipo = CO.Id_Equipo)\n"
                    + "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_sala)\n"
                    + "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n"
                    + "WHERE US.Id_Usuario = '" + usuario.getId() + "'AND SO.Id_Solicitud IN(SELECT Max(Id_Solicitud) \n"
                    + "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n"
                    + "WHERE '" + LocalDateTime.now() + "' > Solicitud.FechaHoraInicio AND '" + LocalDateTime.now() + "' < Solicitud.FechaHoraFin \n"
                    + "GROUP BY Computador.Id_Equipo);");
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

    public boolean makeBorrow(Solicitud solicitud, Computador computador) {
        Connection connection = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            CallableStatement cst = connection.prepareCall("{CALL makeBorrow(?,?,?,?,?,?)}");
            cst.setInt(1, computador.getId());
            cst.setInt(2, solicitud.getId());
            cst.setString(3, String.valueOf(solicitud.getFechaHoraInicio()));
            cst.setString(4, String.valueOf(solicitud.getFechaHoraFin()));
            cst.setString(5, String.valueOf(LocalDateTime.now()));
            cst.registerOutParameter(6, java.sql.Types.INTEGER);
            cst.execute();
            System.out.println(cst.getInt(6));
            if (cst.getInt(6) == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }
    }

    public boolean crear(Solicitud object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            java.util.Date miObjetoJavaUtilDate = new Date();
            Timestamp fecha = new Timestamp(miObjetoJavaUtilDate.getTime());
            resultSet = statement.executeUpdate("INSERT INTO Solicitud(`FechaHoraInicio`, `FechaHoraFin`, `ComputadorId_Equipo`, `UsuarioId_Usuario`) VALUES ('"
                    + object.getFechaHoraInicio() + "','" + object.getFechaHoraFin() + "'," + null + ",'" + object.getUsuario().getId() + "')");
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

    public ArrayList<String[]> getInfoTotal(Usuario user) {
        ArrayList<String[]> datos = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT SO.Id_Solicitud, CO.Id_Equipo, ED.Nombre, ED.Id_Edificio, SA.Codigo, SO.FechaHoraInicio, SO.FechaHoraFin\n"
                    + "FROM ((Solicitud AS SO INNER JOIN Computador AS CO ON SO.ComputadorId_Equipo = CO.Id_Equipo)\n"
                    + "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_sala)\n"
                    + "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n"
                    + "WHERE SO.UsuarioId_Usuario = '" + user.getId() + "' \n"
                    + "AND SO.Id_Solicitud IN(SELECT Id_Solicitud\n"
                    + "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n"
                    + "WHERE '" + LocalDateTime.now() + "' < Solicitud.FechaHoraInicio \n"
                    + "OR ('" + LocalDateTime.now() + "' > Solicitud.FechaHoraInicio AND '" + LocalDateTime.now() + "' < Solicitud.FechaHoraFin))";
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] computador = {"", "", "", "", "", "", ""};
                computador[0] = Integer.toString(resultSet.getInt(1));
                computador[1] = Integer.toString(resultSet.getInt(2));
                computador[2] = resultSet.getString(3);
                computador[3] = Integer.toString(resultSet.getInt(4));
                computador[4] = resultSet.getString(5);
                computador[5] = resultSet.getString(6);
                computador[6] = resultSet.getString(7);
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

    public ArrayList<String[]> getInfo(Usuario user) {
        ArrayList<String[]> datos = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT SO.Id_Solicitud, CO.Id_Equipo, ED.Nombre, ED.Id_Edificio, SA.Codigo\n"
                    + "FROM ((Solicitud AS SO INNER JOIN Computador AS CO ON SO.ComputadorId_Equipo = CO.Id_Equipo)\n"
                    + "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_sala)\n"
                    + "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n"
                    + "WHERE SO.UsuarioId_Usuario = '" + user.getId() + "' \n"
                    + "AND SO.Id_Solicitud IN(SELECT Max(Id_Solicitud) \n"
                    + "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n"
                    + "WHERE '" + LocalDateTime.now() + "' > Solicitud.FechaHoraInicio AND '" + LocalDateTime.now() + "' < Solicitud.FechaHoraFin \n"
                    + "GROUP BY Computador.Id_Equipo);";
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] computador = {"", "", "", "", ""};
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
