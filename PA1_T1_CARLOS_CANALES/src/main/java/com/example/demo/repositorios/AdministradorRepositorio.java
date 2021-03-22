
package com.example.demo.repositorios;

import com.example.demo.modelos.Administrador;
import org.springframework.data.repository.CrudRepository;

public interface AdministradorRepositorio extends CrudRepository<Administrador, Long> {
    
}
