
package com.example.demo.repositorios;
import com.example.demo.modelos.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorRepositorio extends CrudRepository<Profesor, Long>  {
    
}
