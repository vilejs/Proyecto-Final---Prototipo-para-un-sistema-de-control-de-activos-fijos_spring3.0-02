/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author J. Simbaña
 */
@Entity
@Table(name = "Mantenimientos")
public class Mantenimientos implements Serializable {

   @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private int idMantenimiento;
    private String tipomant;
    private String fechamant;
    private String horamant;
    private String descripcionmant;
    private String observacionesmant;
    private String recomendacionesmant;
  
       
   ///Relacion items
     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
      @JoinColumn(name = "fkItem")
      private Items fkItem;
     
     //Relacion Usuarios
      @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
      @JoinColumn(name = "fkUsuario")
       private Usuarios fkUsuario;
    


    public Mantenimientos() {
    }

    public Mantenimientos(int idMantenimiento, String tipomant, String fechamant, String horamant, String descripcionmant, String observacionesmant,String recomendacionesmant, Usuarios fkUsuario, Items fkItem) {
        this.idMantenimiento = idMantenimiento;
        this.tipomant = tipomant;
        this.fechamant = fechamant;
        this.horamant = horamant;
        this.descripcionmant = descripcionmant;
        this.observacionesmant = observacionesmant;
        this.recomendacionesmant = recomendacionesmant;
        this.fkUsuario = fkUsuario;
        this.fkItem = fkItem;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getTipomant() {
        return tipomant;
    }

    public void setTipomant(String tipomant) {
        this.tipomant = tipomant;
    }

    public String getFechamant() {
        return fechamant;
    }

    public void setFechamant(String fechamant) {
        this.fechamant = fechamant;
    }

    public String getHoramant() {
        return horamant;
    }

    public void setHoramant(String horamant) {
        this.horamant = horamant;
    }

   

    public String getDescripcionmant() {
        return descripcionmant;
    }

    public void setDescripcionmant(String descripcionmant) {
        this.descripcionmant = descripcionmant;
    }

    public String getObservacionesmant() {
        return observacionesmant;
    }

    public void setObservacionesmant(String observacionesmant) {
        this.observacionesmant = observacionesmant;
    }

    public String getRecomendacionesmant() {
        return recomendacionesmant;
    }

    public void setRecomendacionesmant(String recomendacionesmant) {
        this.recomendacionesmant = recomendacionesmant;
    }

    public Items getFkItem() {
        return fkItem;
    }

    public void setFkItem(Items fkItem) {
        this.fkItem = fkItem;
    }

    public Usuarios getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuarios fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    
    @Override
    public String toString() {
        return "Mantenimiento{" + "idMantenimiento=" + idMantenimiento + ", tipomant=" + tipomant + ", fechamant=" + fechamant + ", horamant=" + horamant + ", descripcionmant=" + descripcionmant + ", observacionesmant=" + observacionesmant + ", recomendacionesmant=" + recomendacionesmant + "fkItem=" + fkItem + "fkUsuario=" + fkUsuario + '}';
    }

   
}
