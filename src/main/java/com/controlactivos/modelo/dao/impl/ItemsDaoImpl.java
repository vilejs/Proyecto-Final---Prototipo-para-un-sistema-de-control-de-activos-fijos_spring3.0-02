/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao.impl;

import com.controlactivos.modelo.entidades.Items;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.controlactivos.modelo.dao.IItemsDao;

/**
 *
 * @author J. Simbaña
 */
public class ItemsDaoImpl extends GenericDaoImpl<Items> implements IItemsDao {


    public ItemsDaoImpl(Class<Items> entityClass) {
        super(entityClass);
    }

    @Override
    public void insertarItems(Items nuevoItem) {

        this.beginTransaction();
        this.create(nuevoItem);
        this.commit();


    }

    @Override
    public List<Items> listarItems(){
        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Items> p= cb.createQuery(Items.class);
        Root<Items> itemList= p.from(Items.class);
        p.select(itemList);
        return this.entityManager.createQuery(p).getResultList();
    }
    
        @Override
        public void modificarObjeto(Items objeto) {
            try {
                    this.beginTransaction();
                    this.update(objeto);
                    this.commit();
            } catch (Exception e) {
                    this.rollback();
            }
	}


	@Override
	public void eliminarObjeto(Items objeto) {
            try {
                    this.beginTransaction();
                    this.delete(objeto);
                    this.commit();
            } catch (Exception e) {
                    this.rollback();
            }
	}
    
}
