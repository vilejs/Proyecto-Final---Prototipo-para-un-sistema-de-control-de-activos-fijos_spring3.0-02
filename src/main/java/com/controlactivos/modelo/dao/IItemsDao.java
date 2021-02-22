/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao;

import com.controlactivos.modelo.entidades.Items;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IItemsDao {

    void insertarItems(Items nuevoItem);
    List<Items> listarItems();
    void modificarObjeto(Items objeto);
    void eliminarObjeto(Items objeto);
    
}
