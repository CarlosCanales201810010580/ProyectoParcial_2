
package com.example.demo.controladores;

import com.example.demo.modelos.Asignatura;
import com.example.demo.servicios.AsignaturaServicios;
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
@RequestMapping(value="/ws/asignatura")

public class AsignaturaApiControlador {
@Autowired
    private AsignaturaServicios servicio;
    
    @GetMapping(value="/")
    public List<Asignatura> Mostrar_Todos(){
        return servicio.getTodosa();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Asignatura> Mostrar_Valor(@PathVariable Long id){
        return servicio.getValora(id);
    }               
    
    @PostMapping(value="/guardar")
    public Asignatura Guardar(@RequestBody Asignatura asignatura){
        return servicio.guardara(asignatura);
    }
    
    @GetMapping(value="/eliminar/{id}")
    public Optional<Asignatura> Eliminar_Por_ID(@PathVariable Long id){
        Optional<Asignatura> asignaturaEliminada=servicio.getValora(id);
        servicio.eliminara(id);
        return asignaturaEliminada;
    }    
}
