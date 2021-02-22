/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.vista;

import com.controlactivos.controlador.IItemsControlador;
import com.controlactivos.controlador.impl.MantenimientosControladorImpl;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.controlactivos.controlador.IMantenimientosControlador;
import com.controlactivos.controlador.IUsuariosControlador;
import com.controlactivos.controlador.impl.ItemsControladorImpl;
import com.controlactivos.controlador.impl.UsuariosControladorImpl;
import com.controlactivos.modelo.entidades.Items;
import com.controlactivos.modelo.entidades.Mantenimientos;
import com.controlactivos.modelo.entidades.Usuarios;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author J. Simbaña
 */
@ManagedBean(name = "mantenimientocore")
@ViewScoped

public class MantenimientosVista implements Serializable {

    private String tipomant;
    private String fechamant;
    private String horamant;
    private String descripcionmant;
    private String observacionesmant;
    private String recomendacionesmant;
   

    private IMantenimientosControlador mantenimientoControlador;
    private Mantenimientos nuevoMantenimiento;
    private List<Mantenimientos> listarmant;
    
     // datos del usuario
    private Usuarios nuevoUsuario;
    private int idUsuario; // fk del departamento
    private IUsuariosControlador usuariosControlador;
    private List<Usuarios> listaUser;    

    // datos del item
    private int idItem;
    private IItemsControlador itemControlador;
    private Items nuevoItem;
    private List<Items> listaitm;
    private Mantenimientos editarObjeto;
    
    

    public MantenimientosVista() {
    }

    @PostConstruct
    public void init() {
         mantenimientoControlador = new MantenimientosControladorImpl();
         itemControlador = new ItemsControladorImpl();
         usuariosControlador = new UsuariosControladorImpl();
         listarItems();
         listarUsuarios();
         listarMantenimientos();
    }

    public void insertarMantenimientos() {
 try {
        nuevoMantenimiento = new Mantenimientos();
        nuevoMantenimiento.setTipomant(tipomant);
        nuevoMantenimiento.setFechamant(fechamant);
        nuevoMantenimiento.setHoramant(horamant);
        nuevoMantenimiento.setDescripcionmant(descripcionmant);
        nuevoMantenimiento.setObservacionesmant(observacionesmant);
        nuevoMantenimiento.setRecomendacionesmant(recomendacionesmant);
        
 // datos del item
         
         nuevoItem= new Items();
         nuevoItem.setIdItem(idItem);
         nuevoMantenimiento.setFkItem(nuevoItem);
 
  // datos del usuario
         
         nuevoUsuario= new Usuarios();
         nuevoUsuario.setIdUsuario(idUsuario);
         nuevoMantenimiento.setFkUsuario(nuevoUsuario);        
       
            mantenimientoControlador.insertarMantenimientos(nuevoMantenimiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "CORRECTO"));
            limpiar();
            listarMantenimientos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
    /***
     * Metodo para editar un objeto
     * @param obj
     */
    public void editarModalPanel(Mantenimientos obj){
        setEditarObjeto(new Mantenimientos());
        setEditarObjeto(obj);
        setIdItem(obj.getFkItem().getIdItem());
        setIdUsuario(obj.getFkUsuario().getIdUsuario());
    }
    
    /***
     * Metodo para eliminar objeto
     *  
     */
    public void eliminarModalPanel(){
        mantenimientoControlador.eliminarObjeto(getEditarObjeto());
        this.init();
    }
    
    /***
     * Metodo para actualizar el registro en la base de datos
     */
    public void actualizarModalPanel(){
        try{
            mantenimientoControlador.modificarObjeto(getEditarObjeto());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "ACTUALIZACION CORRECTA"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
    public void listarMantenimientos() {
        listarmant = mantenimientoControlador.listarMantenimientos();
    }

    public void listarItems() {
       
        listaitm = itemControlador.listarItems();
    }
    
     public void listarUsuarios() {
          listaUser = usuariosControlador.listarUsuarios();
    }
    
    public void limpiar() {
        tipomant = "";
        fechamant = "";
        horamant = "";
        descripcionmant = "";
        observacionesmant = "";
        recomendacionesmant = "";
        
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

    public Usuarios getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuarios nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public IItemsControlador getItemControlador() {
        return itemControlador;
    }

    public void setItemControlador(IItemsControlador itemControlador) {
        this.itemControlador = itemControlador;
    }

    public Items getNuevoItem() {
        return nuevoItem;
    }

    public void setNuevoItem(Items nuevoItem) {
        this.nuevoItem = nuevoItem;
    }

    public List<Items> getListaitm() {
        return listaitm;
    }

    public void setListaitm(List<Items> listaitm) {
        this.listaitm = listaitm;
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

    public IMantenimientosControlador getMantenimientoControlador() {
        return mantenimientoControlador;
    }

    public void setMantenimientoControlador(IMantenimientosControlador mantenimientoControlador) {
        this.mantenimientoControlador = mantenimientoControlador;
    }

    public Mantenimientos getNuevoMantenimiento() {
        return nuevoMantenimiento;
    }

    public void setNuevoMantenimiento(Mantenimientos nuevoMantenimiento) {
        this.nuevoMantenimiento = nuevoMantenimiento;
    }

    public List<Mantenimientos> getListarmant() {
        return listarmant;
    }

    public void setListarmant(List<Mantenimientos> listarmant) {
        this.listarmant = listarmant;
    }

    public Mantenimientos getEditarObjeto() {
        return editarObjeto;
    }

    public void setEditarObjeto(Mantenimientos editarObjeto) {
        this.editarObjeto = editarObjeto;
    }
    
}
