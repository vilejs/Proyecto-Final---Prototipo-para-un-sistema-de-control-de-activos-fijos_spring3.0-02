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
@Table(name = "Items")
public class Items implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idItem;
    private String item;   
    private String marcaitem;
    private String modeloitem;
    private String noserieitem;
    private String coloritem;
    private String fechaitem;
    private String descripcionitem;
    private String estadoitem;
    
    
    //Relacion Departamentos
      @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
      @JoinColumn(name = "fkDepartamento")
      private Departamentos fkDepartamento;

      
      //Relacion Usuarios
      @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
      @JoinColumn(name = "fkUsuario")
      private Usuarios fkUsuario;
   
    //relacion partes
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkItem")
    private List<Partes> fkParte = new ArrayList<Partes>();
    
    //relacion mantenimientos
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkItem")
    private List<Mantenimientos> fkMantenimeinto = new ArrayList<Mantenimientos>();

    public Items() {
    }

    public Items(int idItem, String item, String marcaitem, String modeloitem, String noserieitem, String coloritem, String fechaitem, String descripcionitem,String estadoitem, Departamentos fkDepartamento, Usuarios fkUsuario) {
        this.idItem = idItem;
        this.item = item;
        this.marcaitem = marcaitem;
        this.modeloitem = modeloitem;
        this.noserieitem = noserieitem;
        this.coloritem = coloritem;
        this.fechaitem = fechaitem;
        this.descripcionitem = descripcionitem;
        this.estadoitem = estadoitem;
        this.fkDepartamento = fkDepartamento;
        this.fkUsuario = fkUsuario;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMarcaitem() {
        return marcaitem;
    }

    public void setMarcaitem(String marcaitem) {
        this.marcaitem = marcaitem;
    }

    public String getModeloitem() {
        return modeloitem;
    }

    public void setModeloitem(String modeloitem) {
        this.modeloitem = modeloitem;
    }

    public String getNoserieitem() {
        return noserieitem;
    }

    public void setNoserieitem(String noserieitem) {
        this.noserieitem = noserieitem;
    }

    public String getColoritem() {
        return coloritem;
    }

    public void setColoritem(String coloritem) {
        this.coloritem = coloritem;
    }

    public String getFechaitem() {
        return fechaitem;
    }

    public void setFechaitem(String fechaitem) {
        this.fechaitem = fechaitem;
    }

    public String getDescripcionitem() {
        return descripcionitem;
    }

    public void setDescripcionitem(String descripcionitem) {
        this.descripcionitem = descripcionitem;
    }

    public String getEstadoitem() {
        return estadoitem;
    }

    public void setEstadoitem(String estadoitem) {
        this.estadoitem = estadoitem;
    }

    
    public Departamentos getFkDepartamento() {
        return fkDepartamento;
    }

    public void setFkDepartamento(Departamentos fkDepartamento) {
        this.fkDepartamento = fkDepartamento;
    }

    public Usuarios getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuarios fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public List<Partes> getFkParte() {
        return fkParte;
    }

    public void setFkParte(List<Partes> fkParte) {
        this.fkParte = fkParte;
    }

    public List<Mantenimientos> getFkMantenimeinto() {
        return fkMantenimeinto;
    }

    public void setFkMantenimeinto(List<Mantenimientos> fkMantenimeinto) {
        this.fkMantenimeinto = fkMantenimeinto;
    }

      

    @Override
    public String toString() {
        return "Items{" + "idItem=" + idItem + ", item=" + item + ", marcaitem=" + marcaitem + ", modeloitem=" + modeloitem + ", noserieitem=" + noserieitem + ", coloritem=" + coloritem + ", fechaitem=" + fechaitem + ", descripcionitem=" + descripcionitem + ", estadoitem=" + estadoitem + ", fkDepartamento=" + fkDepartamento + "fkUsuario=" + fkUsuario + ", fkParte=" + fkParte+ ", fkMantenimeinto=" + fkMantenimeinto + '}';
    }


   
}
