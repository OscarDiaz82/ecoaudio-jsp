package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Medico;
import util.DatabaseConnection;

/**
 *
 * @author oscar
 */
public class MedicoRepository implements Repository<Medico> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Medico> findAll() {
        List<Medico> medicos = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM medicos")) {
            
            while (resultSet.next()) {                
                Medico medico = createMedico(resultSet);
                medicos.add(medico);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicos;
    }

    @Override
    public Medico getByid(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Medico medico) {
        String sql = "";
        if(medico.getId() != null && medico.getId() > 0) {
            sql = "UPDATE medicos SET nombre=?, apellido=?, documento=?, correoelectronico=? WHERE id_medico=?";            
        } else {
            sql = "INSERT INTO medicos (nombre, apellido, documento, correoelectronico) VALUES (?,?,?,?)";
        }
        
        try(PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, medico.getNombre());
            statement.setString(2, medico.getApellido());
            statement.setString(3, medico.getDocumento());
            statement.setString(4, medico.getCorreoElectronico());
            if (medico.getId() != null && medico.getId() > 0) {
                statement.setInt(5, medico.getId());
            }
            statement.executeUpdate();            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Medico createMedico(ResultSet resultSet) throws SQLException {
        Medico medico = new Medico();
        medico.setId(resultSet.getInt("id_medico"));
        medico.setNombre(resultSet.getString("nombre"));
        medico.setApellido(resultSet.getString("apellido"));
        medico.setDocumento(resultSet.getString("documento"));
        medico.setCorreoElectronico(resultSet.getString("correoelectronico"));
        return medico;
    }

}
