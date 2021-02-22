/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao.impl;

import com.controlactivos.modelo.entidades.Partes;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.controlactivos.modelo.dao.IPartesDao;

/**
 *
 * @author J. Simbaña
 */
public class PartesDaoImpl extends GenericDaoImpl<Partes> implements IPartesDao {


    public PartesDaoImpl(Class<Partes> entityClass) {
        super(entityClass);
    }

    @Override
    public void insertarPartes(Partes nuevoPartes) {

        this.beginTransaction();
        this.create(nuevoPartes);
        this.commit();

//        EntityTransaction etx= em.getTransaction();
//        etx.begin();
//        em.persist(nuevoProveedores);
//        etx.commit();
    }

    @Override
    public List<Partes> listarPartes(){
        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Partes> p= cb.createQuery(Partes.class);
        Root<Partes> partesList= p.from(Partes.class);
        p.select(partesList);
//        p.where(cb.equal(proveedoresList.get("direccion"),"Conocoto"));
        return this.entityManager.createQuery(p).getResultList();
    }
    
    @Override
    public void modificarObjeto(Partes objeto) {
        try {
                this.beginTransaction();
                this.update(objeto);
                this.commit();
        } catch (Exception e) {
                this.rollback();
        }
    }


    @Override
    public void eliminarObjeto(Partes objeto) {
        try {
                this.beginTransaction();
                this.delete(objeto);
                this.commit();
        } catch (Exception e) {
                this.rollback();
        }
    }
    
}
