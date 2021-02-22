/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador;

import com.controlactivos.modelo.entidades.Usuarios;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IUsuariosControlador {

    public void insertarUsuarios(Usuarios nuevoClientes);
    public List<Usuarios> listarUsuarios();
    void modificarObjeto(Usuarios objeto);
    void eliminarObjeto(Usuarios objeto);
    
}
    



