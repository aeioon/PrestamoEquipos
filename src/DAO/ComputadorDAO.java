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
    
    public boolean freeComputer(Computador computer){
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Computador SET Disponibilidad = 1 WHERE Id_Equipo = " + computer.getId());
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
            String consulta = "SELECT C.Id_Equipo, E.Nombre, E.Id_Edificio, S.Codigo\n" +
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
            }else{
                consulta = consulta + " WHERE Id_Programa < 0";
            }       
            consulta = consulta +      ") AS P) AS Todos\n" +
                                       "LEFT JOIN Computador_Programa ON Computador_Programa.Id_Programa = Todos.Id_Programa AND Computador_Programa.Id_Equipo = Todos.Id_Equipo)\n" +
                                       "WHERE Computador_Programa.Id_Programa IS NULL) AS SinRequest ON Computador_Programa.Id_Equipo = SinRequest.Id_Equipo\n" +
                                  "WHERE SinRequest.Id_Equipo IS NULL) AS Equipos INNER JOIN Computador AS C ON Equipos.Id_Equipo = C.Id_Equipo) INNER JOIN Sala AS S ON S.Id_Sala = C.SalaId_Sala) INNER JOIN Edificio AS E ON E.Id_Edificio = S.EdificioId_Edificio\n" +
                                  "WHERE C.Disponibilidad = 1";
            System.out.println(consulta);
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] fila = new String[4];
                
                fila[0] = Integer.toString(resultSet.getInt(1));
                fila[1] = resultSet.getString(2);
                fila[2] = Integer.toString(resultSet.getInt(3));
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
    
    public ArrayList<String[]> getConcurrenceInfo() {
        ArrayList<String[]> concurrenceInfo = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "Select distinct C.Id_Equipo, So.UsuarioId_Usuario ,E.Código, S.Codigo, C.Disponibilidad\n"
                    + "From (Computador as C INNER JOIN Sala as S ON C.SalaId_sala = S.Id_sala) \n"
                    + "	INNER JOIN Edificio as E ON S.EdificioId_Edificio = E.Id_Edificio\n"
                    + "    LEFT JOIN justActive as So ON So.ComputadorId_Equipo = C.Id_Equipo";
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] fila = new String[5];

                fila[0] = Integer.toString(resultSet.getInt(1));
                fila[1] = resultSet.getString(2);
                fila[2] = Integer.toString(resultSet.getInt(3));
                fila[3] = Integer.toString(resultSet.getInt(4));
                fila[4] = Integer.toString(resultSet.getInt(5));
                concurrenceInfo.add(fila);
            }

            return concurrenceInfo;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return concurrenceInfo;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }

    public double getConcurrencePercentage() {
        double concurrencePercentage = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT COUNT(Id_Equipo)\n"
                    + "FROM Computador;";
            resultSet = statement.executeQuery(consulta);
            resultSet.next();
            double numberOfComputers = resultSet.getInt(1);
            consulta = "SELECT COUNT(Id_Equipo)\n"
                    + "FROM Computador\n"
                    + "WHERE Disponibilidad = 1;";
            resultSet = statement.executeQuery(consulta);
            resultSet.next();
            double numberOfComputersAvailable = resultSet.getInt(1);
            concurrencePercentage = ((numberOfComputers - numberOfComputersAvailable) / numberOfComputers) * 100;
            return concurrencePercentage;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return concurrencePercentage;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }

    public boolean changeAvailability(Computador computador) {
        boolean querySuccess = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "Update Computador\n"
                    + "Set Disponibilidad = 1\n"
                    + "Where Id_Equipo = " + computador.getId();
            resultSet = statement.executeQuery(consulta);
            querySuccess = true;
            return querySuccess;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return querySuccess;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }

    public ArrayList<String> getHoleComputerInfo(Computador computer) {
        ArrayList<String> holeComputerInfo = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "Select distinct C.Id_Equipo, So.UsuarioId_Usuario ,E.Código, S.Codigo, C.Disponibilidad, C.Hardware, S.EncargadoId_Encargado, En.Nombres, En.Apellidos\n"
                    + "                    From (Computador as C INNER JOIN Sala as S ON C.SalaId_sala = S.Id_sala) \n"
                    + "                    INNER JOIN Edificio as E ON S.EdificioId_Edificio = E.Id_Edificio\n"
                    + "                    LEFT JOIN Encargado as En ON S.EncargadoId_Encargado = En.Id_Encargado\n"
                    + "                    LEFT JOIN justActive as So ON So.ComputadorId_Equipo = C.Id_Equipo\n"
                    + "WHERE C.Id_Equipo = " + computer.getId();
            resultSet = statement.executeQuery(consulta);
            resultSet.next();            
            holeComputerInfo.add(Integer.toString(resultSet.getInt(1)));
            holeComputerInfo.add(resultSet.getString(2));
            holeComputerInfo.add(Integer.toString(resultSet.getInt(3)));
            holeComputerInfo.add(Integer.toString(resultSet.getInt(4)));
            holeComputerInfo.add(Integer.toString(resultSet.getInt(5)));
            holeComputerInfo.add(resultSet.getString(6));
            holeComputerInfo.add(resultSet.getString(7));
            holeComputerInfo.add(resultSet.getString(8));
            holeComputerInfo.add(resultSet.getString(9));            

            return holeComputerInfo;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return holeComputerInfo;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }
    
    public ArrayList<String> getComputerPrograms(Computador computer) {
        ArrayList<String> holeComputerInfo = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();                      
            String consultaProgramas = "Select distinct P.Nombre\n"
                    + "From (Computador as C INNER JOIN Computador_Programa as CoP on C.Id_Equipo = CoP.Id_Equipo)\n"
                    + "	INNER JOIN Programa as P On P.Id_Programa = CoP.Id_Programa\n"
                    + "Where C.Id_Equipo = " + computer.getId();
            resultSet = statement.executeQuery(consultaProgramas);
            while(resultSet.next()){
                holeComputerInfo.add(resultSet.getString(1));
            }

            return holeComputerInfo;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return holeComputerInfo;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }
}
