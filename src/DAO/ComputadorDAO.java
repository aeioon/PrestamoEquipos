package DAO;

import Entidad.Computador;
import Entidad.Usuario;
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

    public boolean crear(Computador object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Computador(`Sistema_Operativo`, `Hardware`, `Disponibilidad`, `SalaId_sala`) VALUES (\"" + object.getSistemaOperativo() + "\",\"" + object.getHardware() + "\","
                    + (object.isDisponibilidad() ? "1" : "0") + "," + object.getSala().getId() + ")");
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
            resultSet = statement.executeQuery("SELECT * FROM Computador "
                    + "WHERE Id_Equipo = " + par.getId());
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

    public boolean actualizar(Computador oldComp, Computador newComp) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Computador "
                    + "SET Id_Equipo = " + newComp.getId() + " , "
                    + "Sistema_Operativo = '" + newComp.getSistemaOperativo() + "' , "
                    + "Hardware = '" + newComp.getHardware() + "' , "
                    + "Disponibilidad = " + (newComp.isDisponibilidad() ? "1" : "0") + " , "
                    + "SalaId_sala = " + newComp.getSala().getId()
                    + " WHERE Id_Equipo=" + oldComp.getId() + ";");
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

    public boolean eliminar(Computador object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Computador "
                    + "WHERE Id_Equipo= " + object.getId() + ";");
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

    /**
     * Retorna un areglo computadores disponibles con su informacion
     *
     * @param programs lista de programas seleccionados
     * @return arrayList
     */
    public ArrayList<String[]> getInfoComputersAvailable(ArrayList<Programa> programs) {
        ArrayList<String[]> informacion = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT DISTINCT C.Id_Equipo, E.Nombre, E.Id_Edificio, SA.Id_sala\n"
                    + "FROM (((Computador_Programa AS CP INNER JOIN Computador AS C ON CP.Id_Equipo = C.Id_Equipo) \n"
                    + "	INNER JOIN Sala AS SA ON C.SalaId_sala = SA.Id_sala) \n"
                    + "	INNER JOIN Edificio AS E ON SA.EdificioId_Edificio = E.Id_Edificio) \n"
                    + "WHERE  C.Disponibilidad = 1";
            if (programs.size() != 0) {
                for (int i = 0; i < programs.size(); i++) {
                    consulta = consulta + "AND CP.Id_Programa = " + programs.get(i).getId();
                    if (i != (programs.size() - 1)) {
                        consulta = consulta + "AND C.Id_Equipo IN(\n"
                                + "SELECT DISTINCT C.Id_Equipo\n"
                                + "FROM (((Computador_Programa AS CP INNER JOIN Computador AS C ON CP.Id_Equipo = C.Id_Equipo) \n"
                                + "	INNER JOIN Sala AS SA ON C.SalaId_sala = SA.Id_sala) \n"
                                + "	INNER JOIN Edificio AS E ON SA.EdificioId_Edificio = E.Id_Edificio) \n"
                                + "WHERE  C.Disponibilidad = 1";
                    }
                }
                consulta = consulta + ");";
            } else {
                consulta = consulta + ";";
            }

            resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                String[] fila = new String[4];
                fila[0] = resultSet.getString(1);
                fila[1] = resultSet.getString(2);
                fila[2] = resultSet.getString(3);
                fila[3] = resultSet.getString(4);
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
    
    public static void test(ArrayList<Programa> programs) {   
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT DISTINCT C.Id_Equipo, E.Nombre, E.Id_Edificio, SA.Id_sala\n"
                    + "FROM (((Computador_Programa AS CP INNER JOIN Computador AS C ON CP.Id_Equipo = C.Id_Equipo) \n"
                    + "	INNER JOIN Sala AS SA ON C.SalaId_sala = SA.Id_sala) \n"
                    + "	INNER JOIN Edificio AS E ON SA.EdificioId_Edificio = E.Id_Edificio) \n"
                    + "WHERE  C.Disponibilidad = 1";
            if (programs.size() != 0) {
                for (int i = 0; i < programs.size(); i++) {
                    consulta = consulta + " AND CP.Id_Programa = " + programs.get(i).getId();
                    if (i != (programs.size() - 1)) {
                        consulta = consulta + " AND C.Id_Equipo IN(\n"
                                + "SELECT DISTINCT C.Id_Equipo\n"
                                + "FROM (((Computador_Programa AS CP INNER JOIN Computador AS C ON CP.Id_Equipo = C.Id_Equipo) \n"
                                + "	INNER JOIN Sala AS SA ON C.SalaId_sala = SA.Id_sala) \n"
                                + "	INNER JOIN Edificio AS E ON SA.EdificioId_Edificio = E.Id_Edificio) \n"
                                + "WHERE  C.Disponibilidad = 1";
                    }
                }
                for (int i = 0; i < programs.size()-1; i++) {
                    consulta = consulta + ")";
                }                
            } 
            consulta = consulta + ";";
            

            System.out.println(consulta);
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            
        } 
    }
    
    public static void main(String[] args) {
        ArrayList<Programa> array = new ArrayList<Programa>();
        Programa uno = new Programa(1,"nose","x2");
        Programa dos = new Programa(2,"nose","x2");
        Programa tres = new Programa(3,"nose","x2");
        array.add(uno);
        array.add(dos);
        array.add(tres);
        test(array);
    }

}
