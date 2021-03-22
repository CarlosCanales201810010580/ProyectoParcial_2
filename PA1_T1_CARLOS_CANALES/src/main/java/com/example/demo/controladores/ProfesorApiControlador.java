
package com.example.demo.controladores;

import com.example.demo.modelos.Profesor;
import com.example.demo.servicios.ProfesorServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ws/profesor")

public class ProfesorApiControlador {
    
    @Autowired
    private ProfesorServicio servicio;
    
    @GetMapping(value="/")
    public List<Profesor> Mostrar_Todos(){
        return servicio.getTodosp();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Profesor> Mostrar_Valor(@PathVariable Long id){
        return servicio.getValorp(id);
    }               
    
    @PostMapping(value="/guardar")
    public Profesor Guardar(@RequestBody Profesor profesor){
        return servicio.guardarp(profesor);
    }
    
    @GetMapping(value="/eliminar/{id}")
    public Optional<Profesor> Eliminar_Por_ID(@PathVariable Long id){
        Optional<Profesor> profesorEliminado=servicio.getValorp(id);
        servicio.eliminarp(id);
        return profesorEliminado;
    }    
}
