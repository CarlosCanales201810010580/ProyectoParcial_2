
package com.example.demo.controladores;

import com.example.demo.modelos.Administrador;
import com.example.demo.servicios.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministradorUIControlador {
 
    @Autowired
 private AdministradorServicio servicioAdmin;
 
 
   @GetMapping("/ladmin")
 public String ListaAdmin(Model model){
     setParametro(model,"listaadmin",servicioAdmin.getTodosAdmin ());
     return "lista_administrador";
 }
 
  @GetMapping("/admin")
 public String irAdmin(Model model){
     setParametro(model,"administrador", new Administrador());
     return "administrador";
 }
      @GetMapping("/listaAd")
 public String irlistaAdmin(Model model){
     setParametro(model,"listaadmin",servicioAdmin.getTodosAdmin ());
     return "lista_contacto";
 }

 
 @GetMapping("/crearadmin")
 public String Crear_Admin(Model model){
     setParametro(model,"administrador", new Administrador());
     return "administrador";
 }
 
 @GetMapping("/actualizaradmin/{id}")
 public String irActualizar(@PathVariable("id") Long id, Model model){
     setParametro(model,"administrador",servicioAdmin.getValorAdmin(id));
     return "administrador";
 }
 
 @PostMapping("/guardaradmin")
 public String guardaradmin(Administrador administrador, Model model){
     servicioAdmin.guardarAdmin(administrador);
     return "redirect:/ladmin";
 }
 
 @GetMapping("/eliminaradmin/{id}")
 public String eliminaradmin(@PathVariable("id") Long id, Model model){
     servicioAdmin.eliminarAdmin(id);
     return "redirect:/ladmin";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }  
    
    
}
