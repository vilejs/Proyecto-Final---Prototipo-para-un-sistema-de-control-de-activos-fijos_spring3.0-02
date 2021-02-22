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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author J. Simbaña
 */
@Entity
@Table(name = "departamentos")
public class Departamentos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idDepartamento;  
    private String Nombredpto;
    private String Extensiondpto;
   
    
    
//
    //Relacion clientes
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDepartamento")
        private List<Usuarios> fkUsuario = new ArrayList<Usuarios>();
     
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDepartamento")
      private List<Items> fkItem = new ArrayList<Items>();

    public Departamentos() {
        fkUsuario = new ArrayList<Usuarios>();
        fkItem = new ArrayList<Items>();
        
    }

    public Departamentos(int idDepartamento, String Nombredpto, String Extensiondpto) {
        this.idDepartamento = idDepartamento;
        this.Nombredpto = Nombredpto;
        this.Extensiondpto = Extensiondpto;
     
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombredpto() {
        return Nombredpto;
    }

    public void setNombredpto(String Nombredpto) {
        this.Nombredpto = Nombredpto;
    }

    public String getExtensiondpto() {
        return Extensiondpto;
    }

    public void setExtensiondpto(String Extensiondpto) {
        this.Extensiondpto = Extensiondpto;
    }

    public List<Usuarios> getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(List<Usuarios> fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public List<Items> getFkItem() {
        return fkItem;
    }

    public void setFkItem(List<Items> fkItem) {
        this.fkItem = fkItem;
    }

    
 
    @Override
    public String toString() {
        return "Departamentos{" + "idDepartamento=" + idDepartamento + ", Nombredpto=" + Nombredpto + ", Extensiondpto=" + Extensiondpto + ", fkUsuario=" + fkUsuario + ", fkItem=" + fkItem+ '}';
    }  
   
}
