package com.controlactivos.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Clase de Perfil para los accesos al usuario
 * 
 * @author J. Simbaña
 */
@Entity
@Table(name = "Perfil")
public class Perfil implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idPerfil;
    private String nombre;
    private String descripcion;

    public Perfil() {
    }
    
    public Perfil(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Perfil{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
