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
    
    public ArrayList<String[]> getHoleUserBorrowsInfo(String userId){   
        ProgramaSolicitudDAO psDao  = new ProgramaSolicitudDAO();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String[]> holeUserBorrowsInfo = new ArrayList<String[]>();
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT S.Id_Solicitud, S.FechaHoraInicio, S.FechaHoraFin, S.ComputadorId_Equipo, SA.Codigo, E.Código\n"
                    + "FROM ((((Usuario AS U INNER JOIN Solicitud AS S ON U.Id_Usuario = S.UsuarioId_Usuario)	\n"
                    + "    INNER JOIN Computador AS C ON C.Id_Equipo = S.ComputadorId_Equipo))\n"
                    + "    INNER JOIN Sala AS SA ON SA.Id_sala = C.SalaId_sala)\n"
                    + "    INNER JOIN Edificio AS E ON E.Id_Edificio = SA.EdificioId_Edificio\n"
                    + "WHERE U.Id_Usuario = \"" + userId + "\" ");            
            while (resultSet.next()) {
                String[] currentTuple = {resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), psDao.getRequestPrograms(resultSet.getString(1))};                
                holeUserBorrowsInfo.add(currentTuple);
            }
            return holeUserBorrowsInfo;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return holeUserBorrowsInfo;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return holeUserBorrowsInfo;
            } catch (SQLException ex) {

            }
        }
    }
}
