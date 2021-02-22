/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador;

import com.controlactivos.modelo.entidades.Partes;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IPartesControlador {

    void insertarPartes(Partes nuevoPartes);
    List<Partes> listarPartes();
    void modificarObjeto(Partes objeto);
    void eliminarObjeto(Partes objeto);

}
