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
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    public boolean returnComputer(Computador computer) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Solicitud\n" +
                                                "SET\n" +
                                                "FechaHoraFin = '"+LocalDateTime.now()+"'\n" +
                                                "WHERE '"+LocalDateTime.now()+"' >= Solicitud.FechaHoraInicio AND '" + LocalDateTime.now()+"' <= Solicitud.FechaHoraFin AND ComputadorId_Equipo = "+ computer.getId());
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
    public ArrayList<String[]> getInfoComputersAvailable(ArrayList<Programa> programs, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        ArrayList<String[]> informacion = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "SELECT C.Id_Equipo, E.Id_Edificio, E.Nombre, S.Codigo\n"
                    + "FROM (((SELECT DISTINCT Computador_Programa.Id_Equipo\n"
                    + "FROM Computador_Programa LEFT JOIN (SELECT DISTINCT Todos.Id_Equipo, Todos.Id_Programa \n"
                    + "FROM ((SELECT DISTINCT EquiposP.Id_Equipo, P.Id_Programa \n"
                    + "FROM (SELECT DISTINCT CP.Id_Equipo FROM Computador_Programa AS CP) AS EquiposP INNER JOIN (SELECT* FROM Programa";
            if (programs.size() != 0) {
                consulta = consulta + " WHERE Id_Programa IN(";
                for (int i = 0; i < programs.size(); i++) {
                    consulta = consulta + programs.get(i).getId();
                    if (i != programs.size() - 1) {
                        consulta = consulta + ",";
                    }
                }
                consulta = consulta + ")";
            } else {
                consulta = consulta + " WHERE Id_Programa < 0";
            }
            consulta = consulta + ") AS P) AS Todos\n"
                    + "LEFT JOIN Computador_Programa ON Computador_Programa.Id_Programa = Todos.Id_Programa AND Computador_Programa.Id_Equipo = Todos.Id_Equipo)\n"
                    + "WHERE Computador_Programa.Id_Programa IS NULL) AS SinRequest ON Computador_Programa.Id_Equipo = SinRequest.Id_Equipo\n"
                    + "WHERE SinRequest.Id_Equipo IS NULL) AS Equipos INNER JOIN Computador AS C ON Equipos.Id_Equipo = C.Id_Equipo) INNER JOIN Sala AS S ON S.Id_Sala = C.SalaId_Sala) INNER JOIN Edificio AS E ON E.Id_Edificio = S.EdificioId_Edificio\n"
                    + "WHERE C.Id_Equipo NOT IN (SELECT DISTINCT SO.ComputadorId_Equipo\n" +
                                                 "FROM Solicitud AS SO\n" +
                                                 "WHERE (('" + fechaHoraInicio + "' /*inicio*/ BETWEEN SO.FechaHoraInicio AND SO.FechaHoraFin) OR\n" +
                                                 "('" + fechaHoraFin+ "' /*fin*/ BETWEEN SO.FechaHoraInicio AND SO.FechaHoraFin) OR\n" +
                                                 "('" + fechaHoraInicio + "' < SO.FechaHoraInicio AND '" + fechaHoraFin + "' > SO.FechaHoraFin)) AND ComputadorId_Equipo IS NOT NULL);";
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] fila = new String[4];
                fila[0] = Integer.toString(resultSet.getInt(1));
                fila[1] = Integer.toString(resultSet.getInt(2));
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

    public ArrayList<String[]> getConcurrenceInfo() {
        ArrayList<String[]> concurrenceInfo = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "Select distinct CO.Id_Equipo, justActive.UsuarioId_Usuario, ED.Nombre, SA.Codigo, CO.Disponibilidad\n"
                    + "From ((Computador as CO INNER JOIN Sala as SA ON CO.SalaId_sala = SA.Id_sala)\n"
                    + "INNER JOIN Edificio as ED ON SA.EdificioId_Edificio = ED.Id_Edificio)\n"
                    + "LEFT JOIN (SELECT SO.Id_Solicitud, SO.UsuarioId_Usuario, CO.Id_Equipo, ED.Nombre, ED.Id_Edificio, SA.Codigo\n"
                    + "FROM ((Solicitud AS SO INNER JOIN Computador AS CO ON SO.ComputadorId_Equipo = CO.Id_Equipo)\n"
                    + "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_sala)\n"
                    + "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n"
                    + "WHERE  CO.Disponibilidad = 0 AND SO.Id_Solicitud IN (SELECT Max(Id_Solicitud)\n"
                    + "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n"
                    + "WHERE '"+LocalDateTime.now()+"' > Solicitud.FechaHoraInicio AND '"+LocalDateTime.now()+"' < Solicitud.FechaHoraFin\n"
                    + "GROUP BY Computador.Id_Equipo)) AS justActive ON justActive.Id_Equipo = CO.Id_Equipo";
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String[] fila = new String[5];
                fila[0] = Integer.toString(resultSet.getInt(1));
                fila[1] = resultSet.getString(2) == null ? " " : resultSet.getString(2);
                fila[2] = resultSet.getString(3);
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
                    + "FROM Computador INNER JOIN Solicitud ON Computador.Id_Equipo = Solicitud.ComputadorId_Equipo\n"
                    + "WHERE '"+LocalDateTime.now()+"' >= Solicitud.FechaHoraInicio AND '"+LocalDateTime.now()+"' <= Solicitud.FechaHoraFin;";
            resultSet = statement.executeQuery(consulta);
            resultSet.next();
            double numberOfComputersNotAvailable= resultSet.getInt(1);
            concurrencePercentage = (numberOfComputersNotAvailable) / numberOfComputers;
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

    public String[] getWholeComputerInfo(Computador computer) {
        String[] datos = {"", "", "", "", "", "", "", "", ""};
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            String consulta = "Select distinct CO.Id_Equipo, justActive.UsuarioId_Usuario, ED.Nombre, SA.Codigo, CO.Disponibilidad, CO.Hardware, SA.UsuarioId_Encargado, EN.Nombres, EN.Apellidos\n" +
                    "From (((Computador as CO INNER JOIN Sala as SA ON CO.SalaId_sala = SA.Id_sala)\n" +
                    "INNER JOIN Edificio as ED ON SA.EdificioId_Edificio = ED.Id_Edificio)\n" +
                    "INNER JOIN Usuario as EN ON SA.UsuarioId_Encargado = EN.Id_Usuario)\n" 
                    + "LEFT JOIN (SELECT SO.Id_Solicitud, SO.UsuarioId_Usuario, CO.Id_Equipo, ED.Nombre, ED.Id_Edificio, SA.Codigo\n"
                    + "FROM ((Solicitud AS SO INNER JOIN Computador AS CO ON SO.ComputadorId_Equipo = CO.Id_Equipo)\n"
                    + "INNER JOIN Sala AS SA ON CO.SalaId_sala = SA.Id_sala)\n"
                    + "INNER JOIN Edificio AS ED ON SA.EdificioId_Edificio = ED.Id_Edificio\n"
                    + "WHERE  CO.Disponibilidad = 0 AND SO.Id_Solicitud IN (SELECT Max(Id_Solicitud)\n"
                    + "FROM Solicitud INNER JOIN Computador ON Solicitud.ComputadorId_Equipo = Computador.Id_Equipo\n"
                    + "WHERE '"+LocalDateTime.now()+"' > Solicitud.FechaHoraInicio AND '"+LocalDateTime.now()+"' < Solicitud.FechaHoraFin\n"
                    + "GROUP BY Computador.Id_Equipo)) AS justActive ON justActive.Id_Equipo = CO.Id_Equipo\n"
                    + "WHERE CO.Id_Equipo =" + computer.getId();
            resultSet = statement.executeQuery(consulta);

            if (resultSet.next()) {
                datos[0] = Integer.toString(resultSet.getInt(1));
                datos[1] = resultSet.getString(2);
                datos[2] = resultSet.getString(3);
                datos[3] = resultSet.getString(4);
                datos[4] = Integer.toString(resultSet.getInt(5));
                datos[5] = resultSet.getString(6);
                datos[6] = resultSet.getString(7);
                datos[7] = resultSet.getString(8);
                datos[8] = resultSet.getString(9);
            }

            return datos;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return datos;
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
            String consultaProgramas = "Select distinct PO.Nombre\n"
                    + "From (Computador as CO INNER JOIN Computador_Programa as CP on CO.Id_Equipo = CP.Id_Equipo)\n"
                    + "INNER JOIN Programa as PO On PO.Id_Programa = CP.Id_Programa\n"
                    + "Where CO.Id_Equipo = " + computer.getId();
            resultSet = statement.executeQuery(consultaProgramas);
            while (resultSet.next()) {
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
