/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.vista;
import com.controlactivos.controlador.impl.DepartamentosControladorImpl;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.controlactivos.modelo.entidades.Departamentos;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.controlactivos.controlador.IDepartamentosControlador;

/**
 *
 * @author J. Simbaña
 */
@ManagedBean(name = "departamentoscore")
@ViewScoped

public class DepartamentosVista implements Serializable {

    private String Nombredpto;
    private String Extensiondpto;
  

    private IDepartamentosControlador departamentosControlador;
    private Departamentos nuevoDepartamentos;
    private Departamentos editarDepartamentos;
    private List<Departamentos> listarDepart;

    public DepartamentosVista() {
    }

    @PostConstruct
    public void init() {
        departamentosControlador = new DepartamentosControladorImpl();
        listarDepartamentos();
        setEditarDepartamentos(new Departamentos());
    }

    public void insertarDepartamentos() {
        try {
            nuevoDepartamentos = new Departamentos();
            nuevoDepartamentos.setNombredpto(Nombredpto);
            nuevoDepartamentos.setExtensiondpto(Extensiondpto);
            nuevoDepartamentos.setFkItem(null);
            nuevoDepartamentos.setFkUsuario(null);

            departamentosControlador.insertarDepartamentos(nuevoDepartamentos);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "REGISTRO GUARDADO"));
            limpiar();
            listarDepartamentos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
    public void actualizarDepa(){
        try{
            departamentosControlador.modificarDepartamentos(getEditarDepartamentos());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "ACTUALIZACION CORRECTA"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
    /***
     * Metodo para editar un departamento
     * @param depa
     */
    public void editarDepartamento(Departamentos depa){
        setEditarDepartamentos(new Departamentos());
        getEditarDepartamentos().setExtensiondpto(depa.getExtensiondpto());
        getEditarDepartamentos().setIdDepartamento(depa.getIdDepartamento());
        getEditarDepartamentos().setNombredpto(depa.getNombredpto());
    }
    
    /***
     * Metodo para eliminar un departamento
     * @param departamento 
     */
    public void eliminarDepartamento(){
        departamentosControlador.eliminarDepartamentos(getEditarDepartamentos());
        this.init();
    }

    public void listarDepartamentos() {
        listarDepart = departamentosControlador.listarDepartamentos();
    }

    public void limpiar() {
        Nombredpto = "";
        Extensiondpto = "";
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

    

    public void setDepartamentosControlador(IDepartamentosControlador departamentosControlador) {
        this.departamentosControlador = departamentosControlador;
    }

    public Departamentos getNuevoDepartamentos() {
        return nuevoDepartamentos;
    }

    public void setNuevoDepartamentos(Departamentos nuevoDepartamentos) {
        this.nuevoDepartamentos = nuevoDepartamentos;
    }

    public List<Departamentos> getListarDepart() {
        return listarDepart;
    }

    public void setListarDepart(List<Departamentos> listarDepart) {
        this.listarDepart = listarDepart;
    }

    public Departamentos getEditarDepartamentos() {
        return editarDepartamentos;
    }

    public void setEditarDepartamentos(Departamentos editarDepartamentos) {
        this.editarDepartamentos = editarDepartamentos;
    }

}
