package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Usuario;
import util.DatabaseConnection;

public class UsuarioRepositoryimpl implements UsuarioRepository<Usuario> {
    
    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();                
    }

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getByid(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Usuario getByCedula(String cedula) {
        Usuario usuario = null;        
        try(PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula=?")) {
            statement.setString(1, cedula);
            try(ResultSet resultset = statement.executeQuery()) {                
                if(resultset.next()) {
                    System.out.println("Entre!");
                    usuario = createUsuario(resultset);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;        
    }
    
        private Usuario createUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setApellido(resultSet.getString("apellido"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setCedula(resultSet.getString("cedula"));
        usuario.setIdRol(resultSet.getInt("id_rol"));
        return usuario;
    }

}
