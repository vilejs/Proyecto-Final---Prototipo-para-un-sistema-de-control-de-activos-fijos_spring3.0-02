/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador.impl;

import com.controlactivos.modelo.dao.IUsuariosDao;
import com.controlactivos.modelo.dao.impl.UsuariosDaoImpl;
import com.controlactivos.modelo.entidades.Usuarios;
import java.util.List;
import com.controlactivos.controlador.IUsuariosControlador;

/**
 *
 * @author J. Simbaña
 */
public class UsuariosControladorImpl implements IUsuariosControlador {

    @Override
    public void insertarUsuarios(Usuarios nuevoUsuario) {
        IUsuariosDao usuariosDao = new UsuariosDaoImpl(Usuarios.class);
        usuariosDao.insertarUsuarios(nuevoUsuario);
    }

    @Override
    public List<Usuarios> listarUsuarios() {
    IUsuariosDao usuariosDao = new UsuariosDaoImpl(Usuarios.class);
    return usuariosDao.listarUsuarios();
    }
    
    @Override
    public void eliminarObjeto(Usuarios usuario){
        IUsuariosDao usuariosDao = new UsuariosDaoImpl(Usuarios.class);
        usuariosDao.eliminarObjeto(usuario);
    } 
    
    
    @Override
    public void modificarObjeto(Usuarios objeto) {
        IUsuariosDao usuariosDao = new UsuariosDaoImpl(Usuarios.class);
        usuariosDao.modificarObjeto(objeto);
    }
    
    
}
