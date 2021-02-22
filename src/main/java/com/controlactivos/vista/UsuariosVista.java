/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.vista;

import com.controlactivos.controlador.IDepartamentosControlador;
import com.controlactivos.controlador.IUsuariosControlador;
import com.controlactivos.controlador.impl.DepartamentosControladorImpl;
import com.controlactivos.controlador.impl.UsuariosControladorImpl;
import com.controlactivos.modelo.entidades.Departamentos;
import com.controlactivos.modelo.entidades.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioscore")
@ViewScoped

public class UsuariosVista implements Serializable {

    
    private String cedulausuario;
    private String nombreusuario;
    private String apellidousuario;
    private String direccionusuario;
    private String telefonousuario;
    private String correousuario;

    private Usuarios nuevoUsuario;
    private Usuarios editarUsr;
    private IUsuariosControlador usuariosControlador;
    private List<Usuarios> listaUser;
    
     // datos del departamento
    private Departamentos nuevoDepartamentos;
    private int idDepartamento; // fk del departamento
    private IDepartamentosControlador departamentosControlador;
    private List<Departamentos> listarDepart;
    
    private Usuarios editarObjeto;
    

    public UsuariosVista() {
    }

    @PostConstruct
    public void init() {
        usuariosControlador = new UsuariosControladorImpl();
        departamentosControlador = new DepartamentosControladorImpl();
        listarDepartamentos();
        listarUsuarios();

    }
    
    
     /***
     * Metodo para editar un usuario
     * @param usuario
     */
    public void editarUsuario(Usuarios usuario){
        setEditarUsr(new Usuarios());
        setEditarUsr(usuario);
        setIdDepartamento(usuario.getFkDepartamento().getIdDepartamento());
    }
    
    /***
     * Metodo para eliminar un usuario 
     */
    public void eliminaUsuario(){
        usuariosControlador.eliminarObjeto(getEditarUsr());
        this.init();
    }
    
    /***
     * Metodo para editar un objeto
     * @param obj
     */
    public void editarModalPanel(Usuarios obj){
        setEditarObjeto(new Usuarios());
        setEditarObjeto(obj);
    }
    
    /***
     * Metodo para actualizar el registro en la base de datos
     */
    public void actualizarModalPanel(){
        try{
            usuariosControlador.modificarObjeto(getEditarObjeto());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "ACTUALIZACION CORRECTA"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }

    public void insertarUsuarios() {
  try {
        nuevoUsuario = new Usuarios();
        nuevoUsuario.setCedulausuario(cedulausuario);
        nuevoUsuario.setNombreusuario(nombreusuario);
        nuevoUsuario.setApellidousuario(apellidousuario);
        nuevoUsuario.setDireccionusuario(direccionusuario);
        nuevoUsuario.setTelefonousuario(telefonousuario);
        nuevoUsuario.setCorreousuario(correousuario);
        
         // datos del departamento
         
         nuevoDepartamentos= new Departamentos();
         nuevoDepartamentos.setIdDepartamento(idDepartamento);
         nuevoUsuario.setFkDepartamento(nuevoDepartamentos);
	        
            usuariosControlador.insertarUsuarios(nuevoUsuario);
            listarUsuarios();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "CORRECTO"));
             } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }

    public void listarUsuarios() {
          listaUser = usuariosControlador.listarUsuarios();
    }

    public void listarDepartamentos() {
               listarDepart = departamentosControlador.listarDepartamentos();
    }

    
    public void limpiar() {
        cedulausuario = "";
        nombreusuario = "";
        apellidousuario = "";
        direccionusuario = "";
        telefonousuario = "";
        correousuario = "";
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

    public Usuarios getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuarios nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public IUsuariosControlador getUsuariosControlador() {
        return usuariosControlador;
    }

    public void setUsuariosControlador(IUsuariosControlador usuariosControlador) {
        this.usuariosControlador = usuariosControlador;
    }

   
    public List<Usuarios> getListaUser() {
        return listaUser;
    }

    public void setListaUser(List<Usuarios> listaUser) {
        this.listaUser = listaUser;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    

    public IDepartamentosControlador getDepartamentosControlador() {
        return departamentosControlador;
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

    public Usuarios getEditarUsr() {
        return editarUsr;
    }

    public void setEditarUsr(Usuarios editarUsr) {
        this.editarUsr = editarUsr;
    }

    public Usuarios getEditarObjeto() {
        return editarObjeto;
    }

    public void setEditarObjeto(Usuarios editarObjeto) {
        this.editarObjeto = editarObjeto;
    }
    
}
