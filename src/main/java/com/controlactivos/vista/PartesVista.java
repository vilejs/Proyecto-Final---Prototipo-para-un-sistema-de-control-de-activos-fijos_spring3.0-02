/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.vista;

import com.controlactivos.controlador.IItemsControlador;
import com.controlactivos.controlador.impl.PartesControladorImpl;
import com.controlactivos.modelo.entidades.Partes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.controlactivos.controlador.IPartesControlador;
import com.controlactivos.controlador.impl.ItemsControladorImpl;
import com.controlactivos.modelo.entidades.Items;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author J. Simbaña
 */
@ManagedBean(name = "partecore")
@ViewScoped

public class PartesVista implements Serializable {

    private String parte;
    private String tipoparte;
    private String marcaparte;
    private String noserieparte;
    private String fechaparte;
    private String descripcionparte;
   

    private IPartesControlador partesControlador;
    private Partes nuevoPartes;
    private List<Partes> listapart;

    
    // datos del item
    private int idItem;
    private IItemsControlador itemControlador;
    private Items nuevoItem;
    private List<Items> listaitm;
    
    private Partes editarObjeto;
        
        
         
        
        
    public PartesVista() {
    }
  
    @PostConstruct
    public void init() {
        partesControlador = new PartesControladorImpl();
         itemControlador = new ItemsControladorImpl();
         listarItems();
         listarPartes();

    }

    public void insertarPartes() {
 try {
        nuevoPartes = new Partes();
        nuevoPartes.setParte(parte);
        nuevoPartes.setTipoparte(tipoparte);
        nuevoPartes.setMarcaparte(marcaparte);
        nuevoPartes.setNoserieparte(noserieparte);
        nuevoPartes.setDescripcionparte(descripcionparte);
        nuevoPartes.setFechaparte(fechaparte);
        
       // datos del item
         
         nuevoItem= new Items();
         nuevoItem.setIdItem(idItem);
         nuevoPartes.setFkItem(nuevoItem);
           
            partesControlador.insertarPartes(nuevoPartes);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "CORRECTO"));
            limpiar();
            listarPartes();
            } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
    /***
     * Metodo para editar un objeto
     * @param obj
     */
    public void editarModalPanel(Partes obj){
        setEditarObjeto(new Partes());
        setEditarObjeto(obj);
        setIdItem(obj.getFkItem().getIdItem());
    }
    
    /***
     * Metodo para eliminar objeto
     *  
     */
    public void eliminarModalPanel(){
        partesControlador.eliminarObjeto(getEditarObjeto());
        this.init();
    }
    
    /***
     * Metodo para actualizar el registro en la base de datos
     */
    public void actualizarModalPanel(){
        try{
            partesControlador.modificarObjeto(getEditarObjeto());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "ACTUALIZACION CORRECTA"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }

    public void listarPartes() {
        
        listapart = partesControlador.listarPartes();
    }

    
    public void listarItems() {
       
        listaitm = itemControlador.listarItems();
    }
    
    public void limpiar() {
        parte = "";
        tipoparte = "";
        marcaparte = "";
        noserieparte = "";
        descripcionparte = "";
        fechaparte = "";
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

    public IPartesControlador getPartesControlador() {
        return partesControlador;
    }

    public void setPartesControlador(IPartesControlador partesControlador) {
        this.partesControlador = partesControlador;
    }

    public Partes getNuevoPartes() {
        return nuevoPartes;
    }

    public void setNuevoPartes(Partes nuevoPartes) {
        this.nuevoPartes = nuevoPartes;
    }

    public List<Partes> getListapart() {
        return listapart;
    }

    public void setListapart(List<Partes> listapart) {
        this.listapart = listapart;
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

    public Partes getEditarObjeto() {
        return editarObjeto;
    }

    public void setEditarObjeto(Partes editarObjeto) {
        this.editarObjeto = editarObjeto;
    }
    
}
