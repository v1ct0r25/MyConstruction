package cl.myconstruction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cl.myconstruction.model.Usuario;
import cl.myconstruction.util.Conexion;

public class UsuarioDAO {

    public Usuario validarUsuario(String usuario, String password) {

        Usuario usuarioEncontrado = null;

        String sql = "SELECT * FROM usuarios "
                   + "WHERE usuario = ? AND password = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                usuarioEncontrado = new Usuario();

                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setUsuario(rs.getString("usuario"));
                usuarioEncontrado.setPassword(rs.getString("password"));
                usuarioEncontrado.setNombre(rs.getString("nombre"));
                usuarioEncontrado.setEmail(rs.getString("email"));
                usuarioEncontrado.setRol(rs.getString("rol"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarioEncontrado;
    }
}