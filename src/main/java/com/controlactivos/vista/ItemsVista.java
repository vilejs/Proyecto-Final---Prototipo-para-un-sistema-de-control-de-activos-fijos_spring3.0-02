/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.vista;

import com.controlactivos.controlador.IDepartamentosControlador;
import com.controlactivos.controlador.IItemsControlador;
import com.controlactivos.controlador.IUsuariosControlador;
import com.controlactivos.controlador.impl.DepartamentosControladorImpl;
import com.controlactivos.controlador.impl.ItemsControladorImpl;
import com.controlactivos.controlador.impl.UsuariosControladorImpl;
import com.controlactivos.modelo.entidades.Departamentos;
import com.controlactivos.modelo.entidades.Items;
import com.controlactivos.modelo.entidades.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author J. Simbaña
 */
@ManagedBean(name = "itemscore")
@ViewScoped

public class ItemsVista implements Serializable {

    private String item;   
    private String marcaitem;
    private String modeloitem;
    private String noserieitem;
    private String coloritem;
    private String fechaitem;
    private String descripcionitem;
    private String estadoitem;

    private IItemsControlador itemControlador;
    private Items nuevoItem;
    private List<Items> listaitm;
    
    
    // datos del departamento
         private Departamentos nuevoDepartamentos;
	 private int idDepartamento; // fk del departamento
	 private IDepartamentosControlador departamentosControlador;
         private List<Departamentos> listarDepart;
    
    // datos del usuario
        private Usuarios nuevoUsuario;
        private int idUsuario; // fk del departamento
        private IUsuariosControlador usuariosControlador;
        private List<Usuarios> listaUser;    
        
    //
    private Items editarObjeto;
        
         
    public ItemsVista() {
    }

    @PostConstruct
    public void init() {
        itemControlador = new ItemsControladorImpl();
        usuariosControlador = new UsuariosControladorImpl();
        departamentosControlador = new DepartamentosControladorImpl();
        listarUsuarios();
        listarDepartamentos();
        listarItems();

    }

    public void insertarItems() {
 try {
        nuevoItem = new Items();
        nuevoItem.setItem(item);
        nuevoItem.setMarcaitem(marcaitem);
        nuevoItem.setModeloitem(modeloitem);
        nuevoItem.setNoserieitem(noserieitem);
        nuevoItem.setColoritem(coloritem);
        nuevoItem.setFechaitem(fechaitem);
        nuevoItem.setDescripcionitem(descripcionitem);
        nuevoItem.setEstadoitem(estadoitem);

        
        // datos del departamento
         
         nuevoDepartamentos= new Departamentos();
         nuevoDepartamentos.setIdDepartamento(idDepartamento);
         nuevoItem.setFkDepartamento(nuevoDepartamentos);
         
         // datos del usuario
         
         nuevoUsuario= new Usuarios();
         nuevoUsuario.setIdUsuario(idUsuario);
         nuevoItem.setFkUsuario(nuevoUsuario);
        
       
            itemControlador.insertarItems(nuevoItem);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "CORRECTO"));
            limpiar();
            listarItems();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }

    }

    public void listarItems() {
              listaitm = itemControlador.listarItems();
    }

    public void listarDepartamentos() {
               listarDepart = departamentosControlador.listarDepartamentos();
    }
    
    public void listarUsuarios() {
          listaUser = usuariosControlador.listarUsuarios();
    }

    
    public void limpiar() {
        item = "";
        marcaitem = "";
        modeloitem = "";
        noserieitem = "";
        coloritem = "";
        fechaitem = "";
        descripcionitem = "";
        estadoitem= "";
    }
    
    
    /***
     * Metodo para editar un objeto
     * @param obj
     */
    public void editarModalPanel(Items obj){
        setEditarObjeto(new Items());
        setEditarObjeto(obj);
        setIdDepartamento(obj.getFkDepartamento().getIdDepartamento());
        setIdUsuario(obj.getFkUsuario().getIdUsuario());
        
    }
    
    /***
     * Metodo para eliminar objeto
     *  
     */
    public void eliminarModalPanel(){
        itemControlador.eliminarObjeto(editarObjeto);
        this.init();
    }
    
    /***
     * Metodo para actualizar el registro en la base de datos
     */
    public void actualizarModalPanel(){
        try{
            itemControlador.modificarObjeto(getEditarObjeto());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "ACTUALIZACION CORRECTA"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
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

    public Departamentos getNuevoDepartamentos() {
        return nuevoDepartamentos;
    }

    public void setNuevoDepartamentos(Departamentos nuevoDepartamentos) {
        this.nuevoDepartamentos = nuevoDepartamentos;
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

    public List<Departamentos> getListarDepart() {
        return listarDepart;
    }

    public void setListarDepart(List<Departamentos> listarDepart) {
        this.listarDepart = listarDepart;
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

    public Items getEditarObjeto() {
        return editarObjeto;
    }

    public void setEditarObjeto(Items editarObjeto) {
        this.editarObjeto = editarObjeto;
    }
    
}
