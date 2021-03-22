
package com.example.demo.controladores;

import com.example.demo.modelos.Alumnos;
import com.example.demo.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AlumnoUIControlador {
 @Autowired
 private AlumnoServicio servicio;
 
     @GetMapping("/l")
 public String irlista(Model model){
     setParametro(model,"lista",servicio.getTodos ());
     return "lista_alumnos";
 }
     @GetMapping("/l2")
 public String irl2(Model model){
     setParametro(model,"lista",servicio.getTodos ());
     return "lista2";
 }

 @RequestMapping("/")
 public String index(Model model){
     setParametro(model,"alumno", servicio.getTodos());
     return "index";
 }
  @RequestMapping("/principal")
 public String principal(Model model){
     setParametro(model,"alumno", servicio.getTodos());
     return "principal";
 }
  @RequestMapping("/login")
 public String login(Model model){
     setParametro(model,"alumno", servicio.getTodos());
     return "registrarvista";
 }
 
 @GetMapping("/crear")
 public String irCrear(Model model){
     setParametro(model,"alumno", new Alumnos());
     return "alumno";
 }
 
 @GetMapping("/actualizar/{id}")
 public String irActualizar(@PathVariable("id") Long id, Model model){
     setParametro(model,"alumno",servicio.getValor(id));
     return "alumno";
 }
 
 @PostMapping("/guardar")
 public String guardar(Alumnos alumno, Model model){
     servicio.guardar(alumno);
     return "redirect:/l";
 }
 
 @GetMapping("/eliminar/{id}")
 public String eliminar(@PathVariable("id") Long id, Model model){
     servicio.eliminar(id);
     return "redirect:/l";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }
}
