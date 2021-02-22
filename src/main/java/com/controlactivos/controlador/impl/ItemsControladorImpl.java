/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador.impl;

import com.controlactivos.modelo.dao.impl.ItemsDaoImpl;
import com.controlactivos.modelo.entidades.Items;
import java.util.List;
import com.controlactivos.modelo.dao.IItemsDao;
import com.controlactivos.controlador.IItemsControlador;

/**
 *
 * @author J. Simbaña
 */
public class ItemsControladorImpl implements IItemsControlador {

    @Override
    public void insertarItems(Items nuevoItem) {
        IItemsDao itemsDao = new ItemsDaoImpl(Items.class);
        itemsDao.insertarItems(nuevoItem);
    }

    @Override
    public List<Items> listarItems(){
        IItemsDao itemsDao = new ItemsDaoImpl(Items.class);
        return itemsDao.listarItems();   
    }

    @Override
    public void modificarObjeto(Items objeto) {
        IItemsDao itemsDao = new ItemsDaoImpl(Items.class);
        itemsDao.modificarObjeto(objeto);
    }

    @Override
    public void eliminarObjeto(Items objeto) {
        IItemsDao itemsDao = new ItemsDaoImpl(Items.class);
        itemsDao.eliminarObjeto(objeto);
    }
}
