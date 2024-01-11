package repository;

import java.util.List;

public interface UsuarioRepository<Usuario> {

    List<Usuario> findAll();

    Usuario getByid(Integer id);

    void save(Usuario usuario);

    void delete(Integer id);
    
    Usuario getByCedula(String cedula);
}
