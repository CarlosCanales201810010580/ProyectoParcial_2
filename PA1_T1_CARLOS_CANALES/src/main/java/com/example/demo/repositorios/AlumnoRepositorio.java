
package com.example.demo.repositorios;

import com.example.demo.modelos.Alumnos;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepositorio extends CrudRepository<Alumnos, Long> {
    
}
