
package com.example.demo.controladores;

import com.example.demo.modelos.Profesor;
import com.example.demo.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfesorUIControlador {
  @Autowired
 private ProfesorServicio serviciop;
 
 
   @GetMapping("/lp")
 public String irlp(Model model){
     setParametro(model,"lista2",serviciop.getTodosp ());
     return "lista_profesor";
 }
   @GetMapping("/principalp")
 public String irP_P(Model model){
     setParametro(model,"profesor", new Profesor());
     return "Principal_Prof";
 }
  @GetMapping("/p")
 public String irProfesor(Model model){
     setParametro(model,"profesor", new Profesor());
     return "profesor";
 }
 
 @GetMapping("/crearp")
 public String irCrear(Model model){
     setParametro(model,"profesor", new Profesor());
     return "profesor";
 }
 @GetMapping("/actualizarp/{id}")
 public String irActualizar(@PathVariable("id") Long id, Model model){
     setParametro(model,"profesor",serviciop.getValorp(id));
     return "profesor";
 }
 
 @PostMapping("/guardarp")
 public String guardarp(Profesor profesor, Model model){
     serviciop.guardarp(profesor);
     return "redirect:/lp";
 }
 
 @GetMapping("/eliminarp/{id}")
 public String eliminar(@PathVariable("id") Long id, Model model){
     serviciop.eliminarp(id);
     return "redirect:/lp";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }  
    
    
}
