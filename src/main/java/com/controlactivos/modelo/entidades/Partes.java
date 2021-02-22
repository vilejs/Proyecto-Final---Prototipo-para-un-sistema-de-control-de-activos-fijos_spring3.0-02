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

@Entity
@Table(name = "Partes")
public class Partes implements Serializable {

     @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    
    private int idParte;
    private String parte;
    private String tipoparte;
    private String marcaparte;
    private String noserieparte;
    private String fechaparte;
    private String descripcionparte;
    
    
    ///Relacion items
     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
      @JoinColumn(name = "fkItem")
      private Items fkItem;

    public Partes() {
    }

    public Partes(int idParte,String parte, String tipoparte,  String marcaparte, String noserieparte, String fechaparte, String descripcionparte, Items fkItem ) {
        this.idParte = idParte;
        this.parte= parte;
        this.tipoparte = tipoparte;
        this.marcaparte = marcaparte;
        this.noserieparte = noserieparte;
        this.descripcionparte = descripcionparte;
        this.fechaparte = fechaparte;
        this.fkItem = fkItem;
       
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }
    
    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }
    
    public String getTipoparte() {
        return tipoparte;
    }

    public void setTipoparte(String tipoparte) {
        this.tipoparte = tipoparte;
    }

    public String getMarcaparte() {
        return marcaparte;
    }

    public void setMarcaparte(String marcaparte) {
        this.marcaparte = marcaparte;
    }

    public String getNoserieparte() {
        return noserieparte;
    }

    public void setNoserieparte(String noserieparte) {
        this.noserieparte = noserieparte;
    }

    public String getDescripcionparte() {
        return descripcionparte;
    }

    public void setDescripcionparte(String descripcionparte) {
        this.descripcionparte = descripcionparte;
    }

    public String getFechaparte() {
        return fechaparte;
    }

    public void setFechaparte(String fechaparte) {
        this.fechaparte = fechaparte;
    }

    public Items getFkItem() {
        return fkItem;
    }

    public void setFkItem(Items fkItem) {
        this.fkItem = fkItem;
    }

   

    @Override
    public String toString() {
        return "Partes{" + "idParte=" + idParte + ", parte=" + parte + ", tipoparte=" + tipoparte + ", marcaparte=" + marcaparte + ", noserieparte=" + noserieparte + ", descripcionparte=" + descripcionparte + ", fechaparte=" + fechaparte+"fkItem=" + fkItem + '}';
    }

    
}
