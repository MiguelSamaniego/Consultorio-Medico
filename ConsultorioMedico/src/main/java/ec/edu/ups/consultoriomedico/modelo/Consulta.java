/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Adrian
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter  @Setter
    private int id;
    @Getter  @Setter
    private Calendar fecha;
    @Getter  @Setter
    private Paciente paciente;
    @Getter  @Setter
    private Doctor doctor;
    @Getter  @Setter
    private String observaciones;
    @Getter  @Setter
    private int tiempo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @Setter @Getter
    private PrescripcionCabecera prescripcionCabecera;        
  

}
