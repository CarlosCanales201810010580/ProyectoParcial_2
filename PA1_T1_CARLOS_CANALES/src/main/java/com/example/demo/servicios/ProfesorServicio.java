
package com.example.demo.servicios;
import com.example.demo.modelos.Profesor;
import com.example.demo.repositorios.ProfesorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

   @Service
public class ProfesorServicio {
    @Autowired
    private ProfesorRepositorio repositorio;
    
    public Profesor guardarp(Profesor entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminarp(Long id){
        repositorio.deleteById(id);
    }
    
    public Optional<Profesor> getValorp(Long id){
        return repositorio.findById(id);
    }
    
    public List<Profesor> getTodosp(){
        return (List<Profesor>)repositorio.findAll();
    }
} 

