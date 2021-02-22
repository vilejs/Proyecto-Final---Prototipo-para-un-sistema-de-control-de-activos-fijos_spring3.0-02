/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador.impl;

import com.controlactivos.modelo.dao.impl.PartesDaoImpl;
import com.controlactivos.modelo.entidades.Partes;
import java.util.List;
import com.controlactivos.modelo.dao.IPartesDao;
import com.controlactivos.controlador.IPartesControlador;

/**
 *
 * @author J. Simbaña
 */
public class PartesControladorImpl implements IPartesControlador {

    @Override
    public void insertarPartes(Partes nuevoPartes) {
            IPartesDao partesDao = new PartesDaoImpl(Partes.class);
            partesDao.insertarPartes(nuevoPartes);
        }
    
    @Override
    public List<Partes> listarPartes(){
        IPartesDao partesDao = new PartesDaoImpl(Partes.class);
        return partesDao.listarPartes();
    }
    
    @Override
    public void modificarObjeto(Partes objeto) {
        IPartesDao partesDao = new PartesDaoImpl(Partes.class);
        partesDao.modificarObjeto(objeto);
    }

    @Override
    public void eliminarObjeto(Partes objeto) {
        IPartesDao partesDao = new PartesDaoImpl(Partes.class);
        partesDao.eliminarObjeto(objeto);
    }
    
    

}
