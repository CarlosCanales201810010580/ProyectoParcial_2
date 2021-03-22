
package com.example.demo.servicios;

import com.example.demo.modelos.Aula;
import com.example.demo.repositorios.AulaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

   @Service
public class AulaServicio {
    
       @Autowired
    private AulaRepositorio repositorio;
    
    public Aula guardarau(Aula entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminarau(Long id){
        repositorio.deleteById(id);
    }
    
    public Optional<Aula> getValorau(Long id){
        return repositorio.findById(id);
    }
    
    public List<Aula> getTodosau(){
        return (List<Aula>)repositorio.findAll();
    }
}
