package DAO;

import static DAO.SolicitudDAO.DB_URL;
import Entidad.Solicitud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import Entidad.Programa;

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
            System.out.println(consulta);
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
    
}
