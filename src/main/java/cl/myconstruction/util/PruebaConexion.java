package cl.myconstruction.util;

import java.sql.Connection;

public class PruebaConexion {

    public static void main(String[] args) {

        try {

            Connection conexion = Conexion.conectar();

            System.out.println("=================================");
            System.out.println("CONEXION EXITOSA A MYSQL");
            System.out.println("MyConstruction");
            System.out.println("=================================");

            conexion.close();

        } catch (Exception e) {

            System.out.println("=================================");
            System.out.println("ERROR DE CONEXION");
            System.out.println("=================================");

            e.printStackTrace();
        }
    }
}