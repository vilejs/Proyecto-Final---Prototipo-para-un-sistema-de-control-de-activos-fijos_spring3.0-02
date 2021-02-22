/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao;

import com.controlactivos.modelo.entidades.Mantenimientos;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IMantenimientosDao {

    void insertarMantenimientos(Mantenimientos nuevoMantenimiento);
    List<Mantenimientos> listarMantenimientos();
    void modificarObjeto(Mantenimientos objeto);
    void eliminarObjeto(Mantenimientos objeto);
    
}
