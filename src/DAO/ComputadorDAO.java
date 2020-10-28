package DAO;

import Entidad.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidad.Programa;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class ComputadorDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cpxq1relua92.us-east-1.rds.amazonaws.com:3306/prestamoequipos";
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER
            = "admin";
    static final String DB_PASSWD
            = "4waxA687";

    /*
    public boolean crear(Computador object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO usuarios(`Id_Equipo`, `Sistema_Operativo`, `Hardware`, `Disponibilidad`, `SalaId_sala`) VALUES (\""
                    + object.getId() + "\",\"" + object.getSistemaOperativo() + "\",\"" + object.getHardware()+ "\",\"" + object.getHardware()+ "\",\"" 
                    + object.isDisponibilidad()+ "\",\"" + object.getSistemaOperativo() + "\",\"" + object.+ "\")");
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

    public boolean leer(Computador par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM usuarios "
                    + "WHERE NOMBRE = '" + par.getNombre()
                    + "' AND PASSWORD='" + par.getPassword() + "'");
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

    public boolean actualizar(Usuario oldUser, Usuario newUser) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE usuarios "
                    + "SET NOMBRE = '" + newUser.getNombre() + "' , "
                    + "PASSWORD = '" + newUser.getPassword()
                    + "' WHERE NOMBRE='" + oldUser.getNombre()
                    + "' AND PASSWORD='" + oldUser.getPassword() + "';");
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

    public boolean eliminar(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM usuarios "
                    + "WHERE NOMBRE='" + object.getNombre()
                    + "' AND PASSWORD='" + object.getPassword() + "';");
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
    }*/

    public boolean changeAvailability(Computador comp) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            if (comp.isDisponibilidad()) {
                resultSet = statement.executeUpdate("UPDATE Computador SET Disponibilidad = 0");
            } else {
                resultSet = statement.executeUpdate("UPDATE Computador SET Disponibilidad = 1");
            }
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

    public String[][] getInfo(ArrayList<Programa> programs) {
        String[][] informacion = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT C.Id_Equipo, E.Nombre, E.Id_Edificio, S.Id_sala\n"
                    + "FROM ((Computador_Programa AS CP INNER JOIN Computador AS C ON CP.Id_Equipo = C.Id_Equipo) \n"
                    + "INNER JOIN Sala AS S ON C.SalaId_sala = S.Id_sala) \n"
                    + "INNER JOIN Edificio AS E ON S.EdificioId_Edificio = E.Id_Edificio\n"
                    + "WHERE CP.Id_Programa IN(";
            for (int i = 0; i < programs.size(); i++) {
                consulta = consulta + programs.get(i).getId();
                if (i != (programs.size() - 1)) {
                    consulta = consulta + ",";
                }
            }
            consulta = consulta + ");";
            System.out.println(consulta);
            resultSet = statement.executeQuery(consulta);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println(columnsNumber);
            informacion = new String[columnsNumber][4];
            for (int i = 0; i < columnsNumber; i++) {
                if (resultSet.next()) {
                    informacion[i][0] = resultSet.getString(1);
                    informacion[i][1] = resultSet.getString(2);
                    informacion[i][2] = resultSet.getString(3);
                    informacion[i][3] = resultSet.getString(4);
                }
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
}
