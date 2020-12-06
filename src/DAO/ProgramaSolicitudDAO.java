package DAO;

import static DAO.ProgramaDAO.DB_URL;
import Entidad.Solicitud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import Entidad.Programa;
import Entidad.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramaSolicitudDAO {
    
    static final String DB_URL
            = "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER
            = "admin";
    static final String DB_PASSWD
            = "4waxA687";
    
    public boolean crear(Programa programa, Solicitud solicitud) {        
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "INSERT INTO Programa_Solicitud(`Id_Programa`, `Id_Solicitud`) VALUES (" +
                    programa.getId() + ", " + solicitud.getId() + ")";
            resultSet = statement.executeUpdate(consulta);
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
    
    public ArrayList<String[]> getBorrowsHistoryInfo(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String[]> borrowsHistoryInfo = new ArrayList<String[]>();
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();    
            String consulta = "SELECT B.UsuarioId_Usuario, Nombre, Tiempo\n" +
                                "FROM (	SELECT UsuarioId_Usuario,max(cont) AS Mas_Usado\n" +
                                "        FROM(SELECT S.UsuarioId_Usuario, P.Nombre, count(P.Nombre) AS Cont\n" +
                                "             FROM (Solicitud AS S INNER JOIN Programa_Solicitud AS PS ON S.Id_Solicitud = PS.Id_Solicitud)\n" +
                                "                   INNER JOIN Programa AS P ON PS.Id_Programa = P.Id_Programa\n" +
                                "			 GROUP BY S.UsuarioId_Usuario, P.Nombre) AS A\n" +
                                "        GROUP BY UsuarioId_Usuario) AS B,\n" +
                                "	 (	SELECT S.UsuarioId_Usuario, P.Nombre, count(P.Nombre) AS Cont\n" +
                                "        FROM (Solicitud AS S INNER JOIN Programa_Solicitud AS PS ON S.Id_Solicitud = PS.Id_Solicitud)\n" +
                                "			INNER JOIN Programa AS P ON PS.Id_Programa = P.Id_Programa\n" +
                                "        GROUP BY S.UsuarioId_Usuario, P.Nombre) AS C,\n" +
                                "     (	SELECT UsuarioId_Usuario, SEC_TO_TIME(SUM(((TIME_TO_SEC(FechaHoraFin) - TIME_TO_SEC(FechaHoraInicio))+datediff(FechaHoraFin, FechaHoraInicio)*86400))) AS Tiempo\n" +
                                "        FROM prestamoequipos.Solicitud\n" +
                                "        GROUP BY UsuarioId_Usuario) AS D\n" +
                                "WHERE Mas_Usado = Cont AND B.UsuarioId_Usuario = C.UsuarioId_Usuario AND C.UsuarioId_Usuario = D.UsuarioId_Usuario\n" +
                                "ORDER BY B.UsuarioId_Usuario;";
            resultSet = statement.executeQuery(consulta);  
            String[] lastTuple = {"", "", ""};
            int i=0;
            while (resultSet.next()) {                                
                    String[] currentTuple = {resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)};
                    if(lastTuple[0].equals(currentTuple[0])){
                        currentTuple[1] = lastTuple[1] + ", " +currentTuple[1];
                        borrowsHistoryInfo.remove(--i);
                    }                    
                    borrowsHistoryInfo.add(currentTuple);
                    lastTuple = currentTuple;
                    i++;
                  
            }
            return borrowsHistoryInfo;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return borrowsHistoryInfo;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return borrowsHistoryInfo;
            } catch (SQLException ex) {
            }
        }
    } 
    
    public String getRequestPrograms(String requestId){        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String requestPrograms = "";
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT P.Nombre\n"
                    + "FROM (Solicitud AS S INNER JOIN Programa_Solicitud AS PS ON S.Id_Solicitud = PS.Id_Solicitud)\n"
                    + "	INNER JOIN Programa AS P ON P.Id_Programa = PS.Id_Programa\n"
                    + "WHERE S.Id_Solicitud = " + requestId);
            int count = 0;
            if (resultSet.next()) {
                if(count == 0){
                    requestPrograms =  resultSet.getString(1);
                    count++;
                }else{
                    requestPrograms += ", " + resultSet.getString(1);
                }               
            }
            return requestPrograms;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return requestPrograms;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return requestPrograms;
            } catch (SQLException ex) {

            }
        }
    }
}
