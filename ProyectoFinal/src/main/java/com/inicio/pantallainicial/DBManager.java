package com.inicio.pantallainicial;

import java.sql.*;

public class DBManager {

    // Conexión a la base de datos
    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "nbamanager";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "toor";
    private static final String DB_MSQ_CONN_OK = "TE HAS CONECTADO A LA BASE DE DATOS";
    private static final String DB_MSQ_CONN_NO = "CONEXION FALLIDA";

    // Configuración de la tabla jugadores
    private static final String DB_jugadores = "jugadores";
    private static final String DB_ID = "idjugadores";
    private static final String DB_COS = "Coste";
    private static final String DB_DEF = "Defensa";
    private static final String DB_DES = "Destreza";
    private static final String DB_NOM = "Nombre";
    private static final String DB_POS = "Posicion";
    private static final String DB_TIR = "Tiro";

    private static final String DB_jugadores_select = "SELECT * FROM " + DB_jugadores;

    //////////////////////////////////////////////////
    // MÉTODOS DE CONEXIÓN A LA BASE DE DATOS
    //////////////////////////////////////////////////


    /**
     *  cargar el JDBC driver.
     */
    public static boolean loadDriver() {
        try {
            System.out.print("Cargando Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("OK!");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * conectar con la base de datos.
     */
    public static boolean connect() {
        try {
            System.out.print("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("OK!");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Comprueba la conexión y muestra su estado por pantalla
     *
     * @return true si la conexión existe y es válida, false en caso contrario
     */
    public static boolean isConnected() {
        // Comprobamos estado de la conexión
        try {
            if (conn != null && conn.isValid(0)) {
                System.out.println(DB_MSQ_CONN_OK);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(DB_MSQ_CONN_NO);
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Cierra la conexión con la base de datos
     */
    public static void close() {

        try {
            System.out.print("Cerrando la conexión...");
            conn.close();
            System.out.println("OK!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //////////////////////////////////////////////////
    // MÉTODOS DE TABLA JUGADORES
    //////////////////////////////////////////////////

    //////////////////////////////////////////////////
    // MÉTODOS DE UN SOLO JUGADOR
    //////////////////////////////////////////////////
    ;

    /**
     * Solicita a la BD el equipo con id indicado
     *
     * @param id id del equipo
     * @return ResultSet con el resultado de la consulta, null en caso de error
     */
    public static ResultSet getjugadores(String id) {
        try {
            // Realizamos la consulta SQL
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = DB_NOM + " WHERE " + DB_ID + "='" + id + "';";
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            //stmt.close();

            // Si no hay primer registro entonces no existe el cliente
            if (!rs.first()) {
                return null;
            }

            // Todo bien, devolvemos el cliente
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    private static ResultSet getTablaJugadores(int typeForwardOnly, int concurUpdatable) {
        try {
            
            Statement stmt = conn.createStatement(typeForwardOnly, concurUpdatable);
            ResultSet rs = stmt.executeQuery(DB_jugadores_select);
            //stmt.close();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void printTablaJugadores() {
        try {
            ResultSet rs = getTablaJugadores(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            while (rs.next()) {

                String n = rs.getString(DB_NOM);
                String t = rs.getString(DB_TIR);
                String D = rs.getString(DB_DES);
                String d = rs.getString(DB_DEF);
                String p = rs.getString(DB_POS);
                System.out.println(n + "\t" + t + "\t" + D + "\t" + d + "\t" +p );
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Solicita a la BD insertar un nuevo registro JUGADOR
     */
    public static boolean insertJugador(String nombre, String defensa, String destreza, String tiro, String posicion) {
        try {
            // Obtenemos la tabla clientes
            System.out.print("Insertando cliente " + nombre + "...");
            ResultSet rs = getTablaJugadores(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            // Insertamos el nuevo registro
            rs.moveToInsertRow();
            rs.updateString(DB_NOM, nombre);
            rs.updateString(DB_TIR, tiro);
            rs.updateString(DB_DES, destreza);
            rs.updateString(DB_DEF, defensa);
            rs.updateString(DB_POS, posicion);
            rs.insertRow();


            rs.close();
            System.out.println("OK!");
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public static boolean updateJugador(String nombre, String nuevoNombre, String nuevoDefensa, String nuevoDestreza, String nuevoTiro, String nuevoPosicion) {
        try {
            // Obtenemos el jugador
            System.out.print("Actualizando equipo " + nombre + "... ");
            ResultSet rs = getjugadores(nombre);

            // Si no existe
            if (rs == null) {
                System.out.println("Error. ResultSet null.");
                return false;
            }

            // Si tiene un primer registro, lo eliminamos
            if (rs.first()) {
                rs.updateString(DB_NOM, nuevoNombre);
                rs.updateString(DB_TIR, nuevoTiro);
                rs.updateString(DB_DES, nuevoDestreza);
                rs.updateString(DB_DEF, nuevoDefensa);
                rs.updateString(DB_POS, nuevoPosicion);
                rs.updateRow();
                rs.close();
                System.out.println("OK!");
                return true;
            } else {
                System.out.println("ERROR. ResultSet vacío.");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}






