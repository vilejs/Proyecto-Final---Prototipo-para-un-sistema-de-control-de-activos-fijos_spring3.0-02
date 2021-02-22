/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador;

import com.controlactivos.modelo.entidades.Departamentos;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IDepartamentosControlador {

    public void insertarDepartamentos(Departamentos nuevoDepartamentos);
    public List<Departamentos> listarDepartamentos();
    public Departamentos buscarDepartamentos(int idDepartamento);
    public void modificarDepartamentos(Departamentos nuevoVehiculo);
    public void eliminarDepartamentos(Departamentos nuevoDepartamentos);
    
}
