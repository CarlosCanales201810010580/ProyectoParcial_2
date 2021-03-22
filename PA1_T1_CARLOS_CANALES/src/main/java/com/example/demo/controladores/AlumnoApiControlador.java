
package com.example.demo.controladores;

import com.example.demo.modelos.Alumnos;
import com.example.demo.servicios.AlumnoServicio;
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
@RequestMapping(value="/ws/alumno")
public class AlumnoApiControlador {
    @Autowired
    private AlumnoServicio servicio;
    
    @GetMapping(value="/")
    public List<Alumnos> Mostrar_Todos(){
        return servicio.getTodos();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Alumnos> Mostrar_Valor(@PathVariable Long id){
        return servicio.getValor(id);
    }               
    
    @PostMapping(value="/guardar")
    public Alumnos Guardar(@RequestBody Alumnos alumno){
        return servicio.guardar(alumno);
    }
    
    @GetMapping(value="/eliminar/{id}")
    public Optional<Alumnos> Eliminar_Por_ID(@PathVariable Long id){
        Optional<Alumnos> alumnoEliminado=servicio.getValor(id);
        servicio.eliminar(id);
        return alumnoEliminado;
    }
}
