/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author pcuser
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class PrescripcionCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter  @Setter
    private int id;
    @Getter  @Setter
    private String observacion;

    
    @Getter  @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescripcionCabecera")
    private List<PrescripcionDetalle> listaPrescripcionesDetalle;

   public PrescripcionCabecera(String observacion) {
        this.observacion = observacion;
    }
    
}
