/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.entidades;

/**
 *
 * @author J. Simbaña
 */
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
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable {

  
    
   @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private int idUsuario;
    private String cedulausuario;
    private String nombreusuario;
    private String apellidousuario;
    private String direccionusuario;
    private String telefonousuario;
    private String correousuario;



     //Relacion Departamentos
   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
   @JoinColumn(name = "fkDepartamento")
    private Departamentos fkDepartamento;
   


      @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUsuario")
      private List<Items> fkItem = new ArrayList<Items>();
      
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUsuario")
      private List<Mantenimientos> fkMantenimiento = new ArrayList<Mantenimientos>();

   
      
     
    public Usuarios() {
    }

    public Usuarios(int idUsuario, String cedulausuario, String nombreusuario, String apellidousuario, String direccionusuario, String telefonousuario, String correousuario, Departamentos fkDepartamento) {
        this.idUsuario = idUsuario;
        this.cedulausuario = cedulausuario;
        this.nombreusuario = nombreusuario;
        this.apellidousuario = apellidousuario;
        this.direccionusuario = direccionusuario;
        this.telefonousuario = telefonousuario;
        this.correousuario = correousuario;
        this.fkDepartamento = fkDepartamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCedulausuario() {
        return cedulausuario;
    }

    public void setCedulausuario(String cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getApellidousuario() {
        return apellidousuario;
    }

    public void setApellidousuario(String apellidousuario) {
        this.apellidousuario = apellidousuario;
    }

    public String getDireccionusuario() {
        return direccionusuario;
    }

    public void setDireccionusuario(String direccionusuario) {
        this.direccionusuario = direccionusuario;
    }

    public String getTelefonousuario() {
        return telefonousuario;
    }

    public void setTelefonousuario(String telefonousuario) {
        this.telefonousuario = telefonousuario;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public void setCorreousuario(String correousuario) {
        this.correousuario = correousuario;
    }

    public List<Items> getFkItem() {
        return fkItem;
    }

    public void setFkItem(List<Items> fkItem) {
        this.fkItem = fkItem;
    }

    public List<Mantenimientos> getFkMantenimiento() {
        return fkMantenimiento;
    }

    public void setFkMantenimiento(List<Mantenimientos> fkMantenimiento) {
        this.fkMantenimiento = fkMantenimiento;
    }

   
    public Departamentos getFkDepartamento() {
        return fkDepartamento;
    }

    public void setFkDepartamento(Departamentos fkDepartamento) {
        this.fkDepartamento = fkDepartamento;
    }
    



    @Override
    public String toString() {
        return "Uusarios{" + "idUsuario=" + idUsuario + ", cedulausuario=" + cedulausuario + ", nombreusuario=" + nombreusuario + ", apellidousuario=" + apellidousuario + ", direccionusuario=" + direccionusuario + ", telefonousuario=" + telefonousuario + ", correousuario=" + correousuario + ", fkDepartamento=" + fkDepartamento+ "fkItem=" + fkItem + "fkMantenimiento=" + fkMantenimiento + '}';
    }

    
}
