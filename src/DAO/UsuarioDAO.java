package DAO;

import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER
            = "admin";
    static final String DB_PASSWD
            = "4waxA687";

     public boolean crear(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO `prestamoequipos`.`Usuario`\n" +
                                                "(`Id_Usuario`,\n" +
                                                "`Contraseña`,\n" +
                                                "`Nombres`,\n" +
                                                "`Apellidos`,\n" +
                                                "`Carrera`,\n" +
                                                "`Facultad`,\n" +
                                                "`Rol`)\n" +
                                                "VALUES\n" +
                                                "('"+object.getId()+"',\n" +
                                                "'"+object.getContraseña()+"',\n" +
                                                "'"+object.getNombres()+"',\n" +
                                                "'"+object.getApellidos()+"',\n" +
                                                "'"+object.getCarrera()+"',\n" +
                                                "'"+object.getFacultad()+"',\n" +
                                                +object.getRol()+");");
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

    
    public Usuario leer(Usuario usuario) {
        Usuario usuarioCompleto = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Usuario "
                    + "WHERE Id_Usuario = BINARY '" + usuario.getId()
                    + "' AND Contraseña = BINARY '" + usuario.getContraseña() + "'");
            if (resultSet.next()) {
                usuarioCompleto = new Usuario();
                usuarioCompleto.setId(resultSet.getString(1));
                usuarioCompleto.setContraseña(resultSet.getString(2));
                usuarioCompleto.setNombres(resultSet.getString(3));
                usuarioCompleto.setApellidos(resultSet.getString(4));
                usuarioCompleto.setCarrera(resultSet.getString(5));
                usuarioCompleto.setFacultad(resultSet.getString(6));
                usuarioCompleto.setRol(resultSet.getInt(7));
            }
            return usuarioCompleto;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return usuarioCompleto;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return usuarioCompleto;
            } catch (SQLException ex) {

            }
        }
    }        
    
    public boolean Buscar(String idUsuario) {        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Usuario "
                    + "WHERE Id_Usuario = BINARY '" + idUsuario +"'");
            return resultSet.next();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return true;
        }
    }   
    
    public ArrayList<String[]> getWholeUserBorrowsInfo(String userId){   
        ProgramaSolicitudDAO psDao  = new ProgramaSolicitudDAO();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String[]> wholeUserBorrowsInfo = new ArrayList<String[]>();
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT S.Id_Solicitud, S.FechaHoraInicio, S.FechaHoraFin, S.ComputadorId_Equipo, SA.Codigo, E.Código, P.Nombre\n" +
                                "FROM ((((((Programa AS P INNER JOIN Programa_Solicitud AS PS ON P.Id_Programa = PS.Id_Programa)\n" +
                                "	RIGHT JOIN Solicitud AS S ON PS.Id_Solicitud = S.Id_Solicitud)\n" +
                                "    INNER JOIN Computador AS C ON C.Id_Equipo = S.ComputadorId_Equipo))\n" +
                                "    INNER JOIN Sala AS SA ON SA.Id_sala = C.SalaId_sala)\n" +
                                "    INNER JOIN Edificio AS E ON E.Id_Edificio = SA.EdificioId_Edificio)   \n" +
                                "WHERE S.Id_Solicitud   IN (SELECT DISTINCT Id_Solicitud\n" +
                                "                           FROM Usuario INNER JOIN Solicitud ON Id_Usuario = UsuarioId_Usuario\n" +
                                "                           WHERE Id_Usuario = '"+userId+"')\n" +
                                "ORDER BY Id_Solicitud;";
            resultSet = statement.executeQuery(consulta);
            String[] lastTuple = {"", "", "", "", "", "", ""};
            int i=0;
            while (resultSet.next()) {                                
                    String[] currentTuple = {resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)== null? "---":resultSet.getString(7)};                
                    if(lastTuple[0].equals(currentTuple[0])){
                        currentTuple[6] = lastTuple[6] + ", " +currentTuple[6];
                        wholeUserBorrowsInfo.remove(--i);
                    }                    
                    wholeUserBorrowsInfo.add(currentTuple);
                    lastTuple = currentTuple;
                    i++;
                  
            }
            return wholeUserBorrowsInfo;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return wholeUserBorrowsInfo;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return wholeUserBorrowsInfo;
            } catch (SQLException ex) {

            }
        }
    }
}
