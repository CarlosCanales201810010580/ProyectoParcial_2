
package com.example.demo.servicios;

import com.example.demo.modelos.Asignatura;
import com.example.demo.repositorios.AsignaturaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AsignaturaServicios {
     @Autowired
    private AsignaturaRepositorio repositorio;
    
    public Asignatura guardara(Asignatura entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminara(Long id){
        repositorio.deleteById(id);
    }
    
    public Optional<Asignatura> getValora(Long id){
        return repositorio.findById(id);
    }
    
    public List<Asignatura> getTodosa(){
        return (List<Asignatura>)repositorio.findAll();
    }
    
}
