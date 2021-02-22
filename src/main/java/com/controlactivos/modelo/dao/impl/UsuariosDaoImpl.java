/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao.impl;

import com.controlactivos.modelo.entidades.Usuarios;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.controlactivos.modelo.dao.IUsuariosDao;

/**
 *
 * @author J. Simbaña
 */
public class UsuariosDaoImpl extends GenericDaoImpl<Usuarios> implements IUsuariosDao {

//    EntityManagerFactory emf=Persistence.createEntityManagerFactory("semana9PU");
//   EntityManager em=emf.createEntityManager();
    public UsuariosDaoImpl(Class<Usuarios> entityClass) {
        super(entityClass);
    }

    @Override
    public void insertarUsuarios(Usuarios nuevoUsuario) {

        this.beginTransaction();
        this.create(nuevoUsuario);
        this.commit();

//        EntityTransaction etx= em.getTransaction();
//        etx.begin();
//        em.persist(nuevoClientes);
//        etx.commit();
//    }
    }

 
@Override
    public List<Usuarios> listarUsuarios(){
        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuarios> p= cb.createQuery(Usuarios.class);
        Root<Usuarios> usuariosList= p.from(Usuarios.class);
        p.select(usuariosList);
//        p.where(cb.equal(clientesList.get("nombres"), "e"));
        return this.entityManager.createQuery(p).getResultList();
    }

     @Override
    public void modificarObjeto(Usuarios objeto) {
        try {
                this.beginTransaction();
                this.update(objeto);
                this.commit();
        } catch (Exception e) {
                this.rollback();
        }
    }
    
    @Override
    public void eliminarObjeto(Usuarios objeto) {
        try {
            this.beginTransaction();
            this.delete(objeto);
            this.commit();
        } catch (Exception e) {
            this.rollback();
        }
    }
    
}
