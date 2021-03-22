
package com.example.demo.controladores;

import com.example.demo.modelos.Aula;
import com.example.demo.servicios.AulaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AulaControlador {
  
     @Autowired
 private AulaServicio servicioau;
 
 
   @GetMapping("/lau")
 public String irlau(Model model){
     setParametro(model,"lista4",servicioau.getTodosau ());
     return "lista_aula";
 }
 
  @GetMapping("/au")
 public String irAula(Model model){
     setParametro(model,"aula", new Aula());
     return "aula";
 }
 
 @GetMapping("/crearau")
 public String irCrear(Model model){
     setParametro(model,"aula", new Aula());
     return "aula";
 }
 
 @GetMapping("/actualizarau/{id}")
 public String irActualizar(@PathVariable("id") Long id, Model model){
     setParametro(model,"aula",servicioau.getValorau(id));
     return "aula";
 }
 
 @PostMapping("/guardarau")
 public String guardarau(Aula aula, Model model){
     servicioau.guardarau(aula);
     return "redirect:/lau";
 }
 
 @GetMapping("/eliminarau/{id}")
 public String eliminar(@PathVariable("id") Long id, Model model){
     servicioau.eliminarau(id);
     return "redirect:/lau";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }  
    
  
}
