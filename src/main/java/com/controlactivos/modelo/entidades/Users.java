package com.controlactivos.modelo.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para usuarios de acceso al sistema
 * 
 * @author J. Simbaña
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idUser;
    private String userName;
    private String password;
    private String email;
    
    //Relacion Usuarios
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fkPerfil")
    private Perfil fkPerfil;

    public Users(int idUser, String userName, String password, String email, Perfil fkPerfil) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fkPerfil = fkPerfil;
    }

    public Users() {
    }
    
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getFkPerfil() {
        return fkPerfil;
    }

    public void setFkPerfil(Perfil fkPerfil) {
        this.fkPerfil = fkPerfil;
    }
    
    
    
    
}
