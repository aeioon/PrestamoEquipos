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

    public boolean occupyComputer(Computador computer){
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Computador SET Disponibilidad = 0 WHERE Id_Equipo = " + computer.getId());
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
    
    public boolean freeComputer(int computer){
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Computador SET Disponibilidad = 1 WHERE Id_Equipo = " + computer);
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
            String consulta = "SELECT C.Id_Equipo, E.Nombre, E.Id_Edificio, S.Id_sala\n" +
                               "FROM (((SELECT DISTINCT Computador_Programa.Id_Equipo\n" +
                                      "FROM Computador_Programa LEFT JOIN (SELECT DISTINCT Todos.Id_Equipo, Todos.Id_Programa \n" +
                                      "FROM ((SELECT DISTINCT EquiposP.Id_Equipo, P.Id_Programa \n" +
                                      "FROM (SELECT DISTINCT CP.Id_Equipo FROM Computador_Programa AS CP) AS EquiposP INNER JOIN (SELECT* FROM Programa";
            if(programs.size() != 0){
                consulta = consulta + " WHERE Id_Programa IN(";
                for(int i = 0; i < programs.size(); i++){
                    consulta = consulta + programs.get(i).getId();
                    if(i != programs.size() - 1){
                        consulta = consulta + ",";
                    }
                }
                consulta = consulta + ")";
            }         
            consulta = consulta +      ") AS P) AS Todos\n" +
                                       "LEFT JOIN Computador_Programa ON Computador_Programa.Id_Programa = Todos.Id_Programa AND Computador_Programa.Id_Equipo = Todos.Id_Equipo)\n" +
                                       "WHERE Computador_Programa.Id_Programa IS NULL) AS SinRequest ON Computador_Programa.Id_Equipo = SinRequest.Id_Equipo\n" +
                                  "WHERE SinRequest.Id_Equipo IS NULL) AS Equipos INNER JOIN Computador AS C ON Equipos.Id_Equipo = C.Id_Equipo) INNER JOIN Sala AS S ON S.Id_Sala = C.SalaId_Sala) INNER JOIN Edificio AS E ON E.Id_Edificio = S.EdificioId_Edificio";
            System.out.println(consulta);
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] fila = new String[4];
                
                fila[0] = Integer.toString(resultSet.getInt(1));
                fila[1] = resultSet.getString(2);
                fila[2] = Integer.toString(resultSet.getInt(3));
                fila[3] = resultSet.getString(4);
                informacion.add(fila);
                System.out.println("FILA ES" + fila[0]+" "+fila[1]+" "+fila[2]+" "+fila[3]+"\n");
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
