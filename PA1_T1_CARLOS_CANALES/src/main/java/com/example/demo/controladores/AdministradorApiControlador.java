
package com.example.demo.controladores;

import com.example.demo.modelos.Administrador;
import com.example.demo.servicios.AdministradorServicio;
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
@RequestMapping(value="/ws/administrador")

public class AdministradorApiControlador {
    
    
    @Autowired
    private AdministradorServicio servicio;
    
    @GetMapping(value="/")
    public List<Administrador> Mostrar_Todos(){
        return servicio.getTodosAdmin();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Administrador> Mostrar_Valor(@PathVariable Long id){
        return servicio.getValorAdmin(id);
    }               
    
    @PostMapping(value="/guardar")
    public Administrador Guardar(@RequestBody Administrador administrador){
        return servicio.guardarAdmin(administrador);
    }
    
    @GetMapping(value="/eliminar/{id}")
    public Optional<Administrador> Eliminar_Por_ID(@PathVariable Long id){
        Optional<Administrador> administradorEliminado=servicio.getValorAdmin(id);
        servicio.eliminarAdmin(id);
        return administradorEliminado;
    }    
    
}
