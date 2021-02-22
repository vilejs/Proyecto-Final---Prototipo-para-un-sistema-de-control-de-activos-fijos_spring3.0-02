/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.controlador.impl;

import com.controlactivos.modelo.dao.impl.DepartamentosDaoImpl;
import com.controlactivos.modelo.entidades.Departamentos;
import java.util.List;
import com.controlactivos.modelo.dao.IDepartamentosDao;
import com.controlactivos.controlador.IDepartamentosControlador;

/**
 *
 * @author J. Simbaña
 */
public class DepartamentosControladorImpl implements IDepartamentosControlador {

    @Override
    public void insertarDepartamentos(Departamentos nuevoDepartamentos) {
        IDepartamentosDao departamentosDao = new DepartamentosDaoImpl(Departamentos.class);
        departamentosDao.insertarDepartamentos(nuevoDepartamentos);
    }

    
    @Override
    public List<Departamentos> listarDepartamentos(){
      IDepartamentosDao departamentosDao = new DepartamentosDaoImpl(Departamentos.class);
       return departamentosDao.listarDepartamentos();  
    }
    

    @Override
	public Departamentos buscarDepartamentos(int idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public void modificarDepartamentos(Departamentos nuevoDepartamentos) {
		IDepartamentosDao departamentosDao = new DepartamentosDaoImpl(Departamentos.class);
		departamentosDao.modificarDepartamentos(nuevoDepartamentos);
		
	}

	@Override
	public void eliminarDepartamentos(Departamentos nuevoDepartamentos) {
		IDepartamentosDao departamentosDao = new DepartamentosDaoImpl(Departamentos.class);
		departamentosDao.eliminarDepartamentos(nuevoDepartamentos);
	}
 

     
    
}
