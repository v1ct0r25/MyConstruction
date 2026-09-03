package cl.myconstruction.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/myconstruction_db";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "12345";

    public static Connection conectar() throws SQLException {

        System.out.println("=================================");
        System.out.println("INTENTANDO CONECTAR A MYSQL");
        System.out.println("URL: " + URL);
        System.out.println("USUARIO: " + USUARIO);
        System.out.println("=================================");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("DRIVER MYSQL ENCONTRADO");

            Connection conexion =
                    DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("CONEXION MYSQL EXITOSA");

            return conexion;

        } catch (ClassNotFoundException e) {

            System.out.println("ERROR: DRIVER MYSQL NO ENCONTRADO");
            e.printStackTrace();

            throw new SQLException(
                    "No se encontró el driver de MySQL.", e
            );

        } catch (SQLException e) {

            System.out.println("ERROR AL CONECTAR CON MYSQL");
            e.printStackTrace();

            throw e;
        }
    }
}