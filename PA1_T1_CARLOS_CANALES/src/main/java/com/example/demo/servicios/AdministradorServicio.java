
package com.example.demo.servicios;

import com.example.demo.modelos.Administrador;
import com.example.demo.repositorios.AdministradorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

   @Service
public class AdministradorServicio {
  
           @Autowired
    private AdministradorRepositorio repositorio;
    
    public Administrador guardarAdmin(Administrador entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminarAdmin(Long id){
        repositorio.deleteById(id);
    }
    
    public Optional<Administrador> getValorAdmin(Long id){
        return repositorio.findById(id);
    }
    
    public List<Administrador> getTodosAdmin(){
        return (List<Administrador>)repositorio.findAll();
    }
}
