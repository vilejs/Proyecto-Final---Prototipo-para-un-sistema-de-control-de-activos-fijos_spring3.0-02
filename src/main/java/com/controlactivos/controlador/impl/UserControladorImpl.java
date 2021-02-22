/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador.impl;

import com.controlactivos.controlador.IUserControlador;
import com.controlactivos.modelo.dao.IUserDao;
import com.controlactivos.modelo.dao.impl.UserDaoImpl;
import com.controlactivos.modelo.entidades.Users;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public class UserControladorImpl implements IUserControlador {

    @Override
    public void insertarUser(Users nuevoUser) {
        IUserDao usuariosDao = new UserDaoImpl(Users.class);
        usuariosDao.insertarUser(nuevoUser);
    }

    @Override
    public List<Users> listarUser() {
    IUserDao usuariosDao = new UserDaoImpl(Users.class);
    return usuariosDao.listarUser();
    }
    
    @Override
    public void eliminarUser(Users usuario){
        IUserDao usuariosDao = new UserDaoImpl(Users.class);
        usuariosDao.eliminarObjeto(usuario);
    } 

    @Override
    public Users findUserbyName(Users usuario) {
        IUserDao usuariosDao = new UserDaoImpl(Users.class);
        return usuariosDao.findUserbyName(usuario);
    }

    @Override
    public void modificarObjeto(Users objeto) {
        IUserDao usuariosDao = new UserDaoImpl(Users.class);
        usuariosDao.modificarObjeto(objeto);
    }
    
    
    
}
