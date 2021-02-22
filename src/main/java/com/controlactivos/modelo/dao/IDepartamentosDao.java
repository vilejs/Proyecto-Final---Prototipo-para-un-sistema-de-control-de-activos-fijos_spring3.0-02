/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao;

import com.controlactivos.modelo.entidades.Departamentos;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IDepartamentosDao {

    void insertarDepartamentos(Departamentos nuevoDepartamentos);
    List<Departamentos> listarDepartamentos();
    Departamentos buscarDepartamentos(int idVDepartamento);
    void modificarDepartamentos(Departamentos nuevoDepartamentos);
    void eliminarDepartamentos(Departamentos nuevoDepartamentos);
    
}
