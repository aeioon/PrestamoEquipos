package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Entidad.Computador;
import Entidad.Programa;
import java.sql.DriverManager;
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
    
    public ArrayList<Programa> getAll() {
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
}
