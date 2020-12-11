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
    
     public ArrayList<String[]> getRequestStats() {
        ArrayList<String[]> results = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT Programa.Id_Programa, Programa.Nombre, Programa.version, A.Exitosas, count(Solicitud.Id_Solicitud)\n" +
                                "FROM Programa INNER JOIN (Programa_Solicitud INNER JOIN Solicitud ON Solicitud.Id_Solicitud = Programa_Solicitud.Id_Solicitud) ON Programa.Id_Programa = Programa_Solicitud.Id_Programa, (SELECT Programa_Solicitud.Id_Programa, count(Solicitud.Id_Solicitud) AS Exitosas\n" +
                                "FROM Programa_Solicitud INNER JOIN Solicitud ON Solicitud.Id_Solicitud = Programa_Solicitud.Id_Solicitud\n" +
                                "WHERE Solicitud.ComputadorId_Equipo IS NOT NULL\n" +
                                "GROUP BY Programa_Solicitud.Id_Programa\n" +
                                "union\n" +
                                "SELECT Programa_Solicitud.Id_Programa, 0 AS Exitosas\n" +
                                "FROM Programa_Solicitud INNER JOIN Solicitud ON Solicitud.Id_Solicitud = Programa_Solicitud.Id_Solicitud\n" +
                                "WHERE Programa_Solicitud.Id_Programa NOT IN (SELECT DISTINCT Id_programa\n" +
                                "FROM (Programa_Solicitud INNER JOIN Solicitud ON Solicitud.Id_Solicitud = Programa_Solicitud.Id_Solicitud)\n" +
                                "WHERE Solicitud.ComputadorId_Equipo IS NOT NULL)\n" +
                                "GROUP BY Programa_Solicitud.Id_Programa) AS A\n" +
                                "WHERE A.Id_Programa = Programa.Id_Programa\n" +
                                "GROUP BY  Programa.Id_Programa, Programa.Nombre, Programa.version, A.Exitosas;";
                                
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] fila = new String[5];
                fila[0] = Integer.toString(resultSet.getInt(1));
                fila[1] = resultSet.getString(2);
                fila[2] = resultSet.getString(3);
                fila[3] = Integer.toString(resultSet.getInt(4));
                fila[4] = Integer.toString(resultSet.getInt(5));;
                results.add(fila);
            }
            
            return results;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return results;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return results;
            } catch (SQLException ex) {

            }
        }
    }   
        
        
     
    public int[] getRequestStats(Programa program) {
        int[] results = new int[2];
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT* FROM (SELECT count(Solicitud.Id_Solicitud) AS Exitosas\n" +
                                "FROM (Programa INNER JOIN (Programa_Solicitud INNER JOIN Solicitud ON Solicitud.Id_Solicitud = Programa_Solicitud.Id_Solicitud) ON Programa.Id_Programa = Programa_Solicitud.Id_Programa)\n" +
                                "WHERE Programa.Id_Programa = "+ program.getId()+" AND Solicitud.ComputadorId_Equipo IS NOT NULL) AS A, (SELECT count(Solicitud.Id_Solicitud) AS No_Exitosas\n" +
                                "FROM (Programa INNER JOIN (Programa_Solicitud INNER JOIN Solicitud ON Solicitud.Id_Solicitud = Programa_Solicitud.Id_Solicitud) ON Programa.Id_Programa = Programa_Solicitud.Id_Programa)\n" +
                                "WHERE Programa.Id_Programa = "+ program.getId()+" AND Solicitud.ComputadorId_Equipo IS NULL) AS B;";
                                
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                results[0] = resultSet.getInt(1);
                results[1] = resultSet.getInt(2);
            }
            
            return results;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return results;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return results;
            } catch (SQLException ex) {

            }
        }
    }
     
    public ArrayList<String[]> getProgramRequestHistory(Programa program) {
        ArrayList<String[]> informacion = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT Solicitud.Id_Solicitud, Usuario.Nombres, Usuario.Apellidos, Solicitud.FechaHoraInicio, Solicitud.FechaHoraFin, Solicitud.ComputadorId_Equipo IS NULL\n" +
                                "FROM (Programa INNER JOIN (Programa_Solicitud INNER JOIN Solicitud ON Solicitud.Id_Solicitud = Programa_Solicitud.Id_Solicitud) ON Programa.Id_Programa = Programa_Solicitud.Id_Programa) \n" +
                                "       INNER JOIN Usuario ON Solicitud.UsuarioId_Usuario = Usuario.Id_Usuario\n" +
                                "WHERE Programa.Id_programa = "+ program.getId();
                                
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] fila = new String[5];

                fila[0] = Integer.toString(resultSet.getInt(1));
                fila[1] = resultSet.getString(2) + " " + resultSet.getString(3);
                fila[2] = resultSet.getString(4);
                fila[3] = resultSet.getString(5);
                int exitoso = resultSet.getInt(6);
                if (exitoso == 0){
                    fila[4] = "Exitoso";
                } else{
                    fila[4] = "No Exitoso";
                }
                informacion.add(fila);
                
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
