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
            String query = "SELECT Id_Solicitud FROM Solicitud WHERE UsuarioId_Usuario = '" + solicitud.getUsuario().getId() + "' AND ComputadorId_Equipo = " + solicitud.getComputador().getId() + " AND Solicitud.Estado = 1";
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

    public boolean VerifyInactivity(Usuario usuario) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT Estado FROM Solicitud WHERE UsuarioId_Usuario = '" + usuario.getId() + "'");
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    return false;
                }
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
        System.out.println("Inicio de Funcion");
        java.util.Date miObjetoJavaUtilDate = new Date();
        Timestamp fecha = new Timestamp(miObjetoJavaUtilDate.getTime());
        Connection connection = null;
        Statement statement = null;

        int resultSet;

        System.out.println("AntesTry");
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            System.out.println("AntesUpdate");
            resultSet = statement.executeUpdate("INSERT INTO Solicitud(`Fecha`, `ComputadorId_Equipo`, `UsuarioId_Usuario`, `Estado`) VALUES ('"
                    + fecha + "'," + object.getComputador().getId() + ",'" + object.getUsuario().getId() + "'," + 1 + ")");
            System.out.println("despuesUpdate");
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

    public String[] getInfo(Usuario user) {
        String[] datos = {"", "", "", "", ""};
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT S.Id_Solicitud, C.Id_Equipo, E.Nombre, E.Id_Edificio, SA.Codigo\n"
                    + " FROM ((Solicitud AS S INNER JOIN Computador AS C ON S.ComputadorID_Equipo = C.Id_Equipo)\n"
                    + " INNER JOIN Sala AS SA ON C.SalaId_Sala = SA.Id_Sala)\n"
                    + " INNER JOIN Edificio AS E ON E.Id_Edificio = SA.EdificioId_Edificio\n"
                    + " WHERE S.UsuarioID_Usuario = '" + user.getId() + "' AND S.Estado = 1\n";
            System.out.println(consulta);
            // Comentario
            resultSet = statement.executeQuery(consulta);
            if (resultSet.next()) {
                datos[0] = Integer.toString(resultSet.getInt(1));
                datos[1] = Integer.toString(resultSet.getInt(2));
                datos[2] = resultSet.getString(3);
                datos[3] = Integer.toString(resultSet.getInt(4));
                datos[4] = resultSet.getString(5);
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

    public boolean actualizar(Solicitud oldSolicitud, Solicitud newSolicitud) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String fecha = newSolicitud.getFecha().format(formatter);
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Solicitud "
                    //+ " Fecha = '" + fecha + "' , "
                    + " SET Estado = " + newSolicitud.getEstado()
                    + " WHERE Id_Solicitud =" + oldSolicitud.getId() + ";");
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
