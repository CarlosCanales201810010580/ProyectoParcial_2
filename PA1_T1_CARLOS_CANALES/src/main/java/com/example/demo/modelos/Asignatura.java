
package com.example.demo.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Asignatura {
   
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String clave;
    private String descripcion;
    private String creditos;
}
