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
    
    public String getTotalTimeUserBorrows(String userId){
      Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String totalTimeUserBorrows = new String();
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT SEC_TO_TIME(SUM(((TIME_TO_SEC(FechaHoraFin) - TIME_TO_SEC(FechaHoraInicio))+datediff(FechaHoraFin, FechaHoraInicio)*86400))) \n"
                    + "FROM prestamoequipos.Solicitud\n"
                    + "WHERE UsuarioId_Usuario = \""+ userId +"\"\n");                    
            resultSet.next();
            totalTimeUserBorrows = resultSet.getString(1);        
            return totalTimeUserBorrows;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return totalTimeUserBorrows;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return totalTimeUserBorrows;
            } catch (SQLException ex) {
            }
        }
    }
    
    public String getMostUsedSoftware(String userId){
      Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String mostUsedSoftware = new String();
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();            
            resultSet = statement.executeQuery("SELECT P.Nombre, count(P.Nombre)\n"
                    + "FROM (Solicitud AS S INNER JOIN Programa_Solicitud AS PS ON S.Id_Solicitud = PS.Id_Solicitud) \n"
                    + "INNER JOIN Programa AS P ON PS.Id_Programa = P.Id_Programa\n"
                    + "WHERE S.UsuarioId_Usuario = \""+ userId +"\"\n");            
            int currentMostUsedSoftwareCount = 0;
            while(resultSet.next()){                
                if(resultSet.getInt(2) > currentMostUsedSoftwareCount){
                    currentMostUsedSoftwareCount = resultSet.getInt(2);
                    mostUsedSoftware = resultSet.getString(1);
                }else if(resultSet.getInt(2) == currentMostUsedSoftwareCount){
                    mostUsedSoftware += ", " + resultSet.getString(1);
                }
            }
            return mostUsedSoftware;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return mostUsedSoftware;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return mostUsedSoftware;
            } catch (SQLException ex) {
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
            resultSet = statement.executeQuery("SELECT Id_Usuario "
                    + "FROM Usuario;");                        
            while(resultSet.next()){                
                String[] currentTuple = {resultSet.getString(1), getMostUsedSoftware(resultSet.getString(1)), getTotalTimeUserBorrows(resultSet.getString(1))};
                borrowsHistoryInfo.add(currentTuple);
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
