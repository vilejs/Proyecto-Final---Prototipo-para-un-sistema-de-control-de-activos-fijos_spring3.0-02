/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador.impl;

import com.controlactivos.modelo.dao.impl.MantenimientosDaoImpl;
import com.controlactivos.modelo.entidades.Mantenimientos;
import java.util.List;
import com.controlactivos.modelo.dao.IMantenimientosDao;
import com.controlactivos.controlador.IMantenimientosControlador;

/**
 *
 * @author J. Simbaña
 */
public class MantenimientosControladorImpl implements IMantenimientosControlador {

    @Override
    public void insertarMantenimientos(Mantenimientos nuevoMantenimiento) {
        IMantenimientosDao mantenimientoDao = new MantenimientosDaoImpl(Mantenimientos.class);
        mantenimientoDao.insertarMantenimientos(nuevoMantenimiento);
    }

    @Override
    public List<Mantenimientos> listarMantenimientos(){
        IMantenimientosDao mantenimientoDao = new MantenimientosDaoImpl(Mantenimientos.class);
        return mantenimientoDao.listarMantenimientos();
    }
    
    @Override
    public void modificarObjeto(Mantenimientos objeto) {
        IMantenimientosDao mantenimientoDao = new MantenimientosDaoImpl(Mantenimientos.class);
        mantenimientoDao.modificarObjeto(objeto);
    }

    @Override
    public void eliminarObjeto(Mantenimientos objeto) {
        IMantenimientosDao mantenimientoDao = new MantenimientosDaoImpl(Mantenimientos.class);
        mantenimientoDao.eliminarObjeto(objeto);
    }
    
}
