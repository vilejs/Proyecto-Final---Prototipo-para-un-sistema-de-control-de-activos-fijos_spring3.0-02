/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao;

import com.controlactivos.modelo.entidades.Usuarios;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IUsuariosDao {

    void insertarUsuarios(Usuarios nuevoUsuario);
    List<Usuarios> listarUsuarios();
    void eliminarObjeto(Usuarios usuario);
    void modificarObjeto(Usuarios usuario);
    
}
