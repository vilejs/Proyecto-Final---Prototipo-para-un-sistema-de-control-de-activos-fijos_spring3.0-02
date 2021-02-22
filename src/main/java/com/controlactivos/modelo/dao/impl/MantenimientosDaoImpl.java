/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao.impl;

import com.controlactivos.modelo.entidades.Mantenimientos;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.controlactivos.modelo.dao.IMantenimientosDao;
import com.controlactivos.modelo.entidades.Items;

/**
 *
 * @author J. Simbaña
 */
public class MantenimientosDaoImpl extends GenericDaoImpl<Mantenimientos> implements IMantenimientosDao {


    public MantenimientosDaoImpl(Class<Mantenimientos> entityClass) {
        super(entityClass);
    }

    @Override
    public void insertarMantenimientos(Mantenimientos nuevoMantenimiento) {

        this.beginTransaction();
        this.create(nuevoMantenimiento);
        this.commit();


    }

    @Override
    public List<Mantenimientos> listarMantenimientos(){
        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Mantenimientos> p= cb.createQuery(Mantenimientos.class);
        Root<Mantenimientos> mantenimientoList= p.from(Mantenimientos.class);
        p.select(mantenimientoList);
//        p.where(cb.equal(reservacionmantenimientoList.get("empresa"), "Repuestos Pichincha"));
        return this.entityManager.createQuery(p).getResultList();
    }
    
     @Override
        public void modificarObjeto(Mantenimientos objeto) {
            try {
                    this.beginTransaction();
                    this.update(objeto);
                    this.commit();
            } catch (Exception e) {
                    this.rollback();
            }
	}


	@Override
	public void eliminarObjeto(Mantenimientos objeto) {
            try {
                    this.beginTransaction();
                    this.delete(objeto);
                    this.commit();
            } catch (Exception e) {
                    this.rollback();
            }
	}
    
}
