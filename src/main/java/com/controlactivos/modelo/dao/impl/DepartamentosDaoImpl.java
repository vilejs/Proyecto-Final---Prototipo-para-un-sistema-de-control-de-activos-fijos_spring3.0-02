/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao.impl;

import com.controlactivos.modelo.entidades.Departamentos;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.controlactivos.modelo.dao.IDepartamentosDao;

/**
 *
 * @author J. Simbaña
 */
public class DepartamentosDaoImpl extends GenericDaoImpl<Departamentos> implements IDepartamentosDao {


    public DepartamentosDaoImpl(Class<Departamentos> entityClass) {
        super(entityClass);
    }

    @Override
    public void insertarDepartamentos(Departamentos nuevoDepartamentos) {

        this.beginTransaction();
        this.create(nuevoDepartamentos);
        this.commit();


    }

    @Override
    public List<Departamentos> listarDepartamentos(){
        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Departamentos> p= cb.createQuery(Departamentos.class);
        Root<Departamentos> departamentosList= p.from(Departamentos.class);
        p.select(departamentosList);
//        p.where(cb.equal(repuestosList.get("empresa"), "Repuestos Pichincha"));
        return this.entityManager.createQuery(p).getResultList();
    }
    
    
  
    @Override
	public Departamentos buscarDepartamentos(int idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}


	
    @Override
	public void modificarDepartamentos(Departamentos nuevoDepartamentos) {
		try {
			this.beginTransaction();
			this.update(nuevoDepartamentos);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
		
	}


	@Override
	public void eliminarDepartamentos(Departamentos nuevoDepartamentos) {
		try {
			this.beginTransaction();
			this.delete(nuevoDepartamentos);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
	}

    
}
