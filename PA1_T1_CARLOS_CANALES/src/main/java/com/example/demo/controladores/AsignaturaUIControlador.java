
package com.example.demo.controladores;

import com.example.demo.modelos.Asignatura;
import com.example.demo.servicios.AsignaturaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AsignaturaUIControlador {
    
    @Autowired
 private AsignaturaServicios servicioa;
 
 
   @GetMapping("/la")
 public String irla(Model model){
     setParametro(model,"lista3",servicioa.getTodosa ());
     return "lista_asignatura";
 }
 
  @GetMapping("/a")
 public String irAsignatura(Model model){
     setParametro(model,"asignatura", new Asignatura());
     return "asignatura";
 }
 
 @GetMapping("/creara")
 public String irCrear(Model model){
     setParametro(model,"asignatura", new Asignatura());
     return "asignatura";
 }
 
 @GetMapping("/actualizara/{id}")
 public String irActualizar(@PathVariable("id") Long id, Model model){
     setParametro(model,"asignatura",servicioa.getValora(id));
     return "asignatura";
 }
 
 @PostMapping("/guardara")
 public String guardara(Asignatura asignatura, Model model){
     servicioa.guardara(asignatura);
     return "redirect:/la";
 }
 
 @GetMapping("/eliminara/{id}")
 public String eliminar(@PathVariable("id") Long id, Model model){
     servicioa.eliminara(id);
     return "redirect:/la";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }  
    
  
}
